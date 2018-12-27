/**
 * @Title: JuzhenDfsClient.java
 * @Description: dfs client
 * @date: 2017年3月2日 下午4:34:38
 * @version: V1.0
 */
package com.wxbc.bcos.engine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wxbc.bcos.callback.SetDataTransctionSucCallback;
import com.wxbc.bcos.entity.*;
import com.wxbc.bcos.http.FileHttpClient;
import com.wxbc.bcos.message.FileInfo;
import com.wxbc.bcos.message.FileServer;
import com.wxbc.bcos.utils.DfsMD5;
import com.wxbc.bcos.utils.DfsMutexLock;
import com.wxbc.bcos.utils.DfsTimer;
import com.wxbc.bcos.web3j.*;
import com.wxbc.bcos.web3j.FileInfoManager.NotifyEventResponse;
import com.wxbc.middle.utils.CommonConst;
import org.bcos.channel.client.Service;
import org.bcos.channel.handler.ChannelConnections;
import org.bcos.contract.tools.ToolConf;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Int256;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.crypto.GenCredential;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.bcos.web3j.protocol.core.methods.response.EthAccounts;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.protocol.http.HttpService;
import org.bcos.web3j.protocol.parity.Parity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.wxbc.middle.utils.CommonConst.version;

@Component
public class CommonEngine implements BeanFactoryAware {
    private BeanFactory factory;
    //默认的合约名称
    final static String fileContractName = "FileInfoManager";
    final static String fileServerName = "FileServerManager";
    final static String COUFactoryName = "COUFactory";
    final static String FileDataName = "FileData";
    final static String COULogicName = "COULogic";
    final static String TestDataName = "TestData";
    final static String TestData1Name = "TestData1";
    final static String JsonDataName = "JsonData";
    private String fileServerContract;
    private String fileInfoContract;
    private String COUFactoryContract;
    private String FileDataContract;
    private String COULogicContract;
    private String TestDataContract;
    private String TestData1Contract;
    private String JsonDataContract;

    //request, and then listener callback
    private DfsMutexLock locker;
    protected String host;
    protected int port;
    private boolean isInit = false;
    private FileHttpClient httpClient;
    Web3j web3;
    private Service channelService;
    ChannelConnections channelConns;
    ChannelEthereumService channelEthereumService;
    private String orgID;

    @Value("${web3j.hostip}")
    private String hostIp;
    @Value("${web3j.systemproxycontract}")
    private String systemProxyContract;

    @Value("${web3j.orgid}")
    private String orgId;

    @Value("${web3j.account}")
    private String account;

    @Value("${web3j.privKey}")
    private String privKey;


    private Credentials credentials;
    private BigInteger gasPrice = new BigInteger("99999999999");
    private BigInteger gasLimited = new BigInteger("9999999999999");
    private Vector<FileServer> fileServers = new Vector<FileServer>();
    protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @PostConstruct
    public void initCommonEngine() {
        credentials = null;
        httpClient = new FileHttpClient();
        locker = new DfsMutexLock();
        int result = init(getHostIP(), account, privKey, orgId);
        if (0 != result) {
            logger.error("initCommonEngine: engine.init is FAILED!");
        } else {
            logger.info("initCommonEngine: engine.init is ok!");
        }
    }

    private List<String> getHostIP() {
        List<String> ipList = new ArrayList<>();
        for (String ip : hostIp.split(",")) {
            ipList.add(ip);
        }
        return ipList;
    }


    /**
     * @param connectionsStr 要连接的区块链节点(向其发送交易)列表
     *                       元素形式:NodeA@127.0.0.1:30333
     *                       NodeA为节点名称,可以是任意名称,@之后为节点IP地址和channelPort端口
     *                       每次发送交易时,sdk随机选取节点发送交易
     * @return 0 ：成功    其他：失败
     * @description 初始化Engine
     */
    public int init(List<String> connectionsStr, String account, String privKey, String orgID) {

        locker.lock();
        this.orgID = orgID;
        //channelService = new Service();
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Service channelService = context.getBean(Service.class);
        channelService.setOrgID(orgID); // 配置本机构名称
        channelConns = new ChannelConnections();
        channelConns.setConnectionsStr(connectionsStr);
        channelConns.setCaCertPath(CommonConst.caCertPath);
        channelConns.setClientKeystorePath(CommonConst.clientKeystorePath);
        ConcurrentHashMap<String, ChannelConnections> cc = new ConcurrentHashMap<String, ChannelConnections>();
        channelService.setAllChannelConnections(cc);
        channelService.getAllChannelConnections().put(orgID, channelConns);
        try {
            channelService.run();
            Thread.sleep(3000);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } //服务运行起来

        channelEthereumService = new ChannelEthereumService();
        channelEthereumService.setChannelService(channelService);

        web3 = Web3j.build(channelEthereumService);
        ToolConf toolConf = context.getBean(ToolConf.class);
        if (0 != privKey.length())
            toolConf.setPrivKey(privKey);
        if (0 != account.length())
            toolConf.setAccount(account);
        if (0 != systemProxyContract.length())
            toolConf.setSystemProxyAddress(systemProxyContract);
        credentials = GenCredential.create(toolConf.getPrivKey());
        if (credentials == null) {
            logger.error("Engine.init: credentials is null, please init again!");
            return EngineConst.ENGINE_ERROR_BAD;
        }
        //TestData1Contract = getContractAddr(TestData1Name);
        JsonDataContract = getContractAddr(JsonDataName);
        //FileDataContract = getContractAddr(FileDataName);
        locker.unlock();
        return EngineConst.ENGINE_ERROR_OK;
    }

    /**
     * @param host 主机地址
     * @param port JSONRPC端口
     * @return 0 ：成功    其他：失败
     * @description 初始化 （交易不签名， 方式使用SDK）
     */
    private int init(String host, int port) {
        locker.lock();
        isInit = false;
        this.host = host;
        this.port = port;
        httpClient.init(host, port);

        listFileServersSync();

        isInit = true;

        if (fileServers.isEmpty()) {
            FileServer server = new FileServer();
            server.setPort(port);
            server.setHost(host);
            fileServers.add(server);
            locker.unlock();
            return DfsConst.DFS_ERROR_FAIL;
        }

        locker.unlock();

        return DfsConst.DFS_ERROR_OK;
    }






    public String getJsonData(String key) {
        JsonData jsonData = createJsonData();
        Future<Utf8String> futureStr = jsonData.getJsonData(new Utf8String(key));
        String CQInfo = "";
        try {
            Utf8String ret = futureStr.get();
            CQInfo = ret.getValue();
        } catch (Exception e) {
            logger.error("getJsonData", e);
            return "";
        }
        return CQInfo;
    }

    public void setJsonData(String key, String value, String tradeUuid) {
        JsonData jsonData = createJsonData();
        try {
            SetDataTransctionSucCallback setDataTransctionSucCallback =
                    (SetDataTransctionSucCallback) factory.getBean("setDataTransctionSucCallback");
            setDataTransctionSucCallback.setTradeUuid(tradeUuid);
            jsonData.setJsonData(new Utf8String(key), new Utf8String(value), setDataTransctionSucCallback);
        } catch (Exception e) {
            logger.error(" setJsonData", e);
        }


    }

    public void setCouQuata(String cblnHash, String fiblnHash, String newamount, String tradeUuid) {
        TestData testData = createTestData();
        try {
            SetDataTransctionSucCallback setDataTransctionSucCallback =
                    (SetDataTransctionSucCallback) factory.getBean("setDataTransctionSucCallback");
            setDataTransctionSucCallback.setTradeUuid(tradeUuid);
            testData.setCOUCenterQuota(new Utf8String(cblnHash), new Utf8String(fiblnHash), new Int256(BigInteger.valueOf(Long.valueOf(newamount))), setDataTransctionSucCallback);
        } catch (Exception e) {
            logger.error(" center transfer COU fail.", e);
        }

    }

    public String getCouQuata(String cblnHash, String fiblnHash) {
        TestData testData = createTestData();
        String value = null;
        try {
            Future<Int256> couCenterQuota = testData.getCOUCenterQuota(new Utf8String(cblnHash), new Utf8String(fiblnHash));
            Int256 utf8String = couCenterQuota.get();
            value = utf8String.getValue().toString();

        } catch (Exception e) {
            logger.error(" center transfer COU fail.", e);
        }
        return value;

    }

    private TestData createTestData() {
        String addr ="0x1406a0c559995562fc77bf2a214a2dcfab4f6b2b"; //TestDataContract;
        return TestData.load(addr, web3, credentials, gasPrice, gasLimited);
    }

    private TestData1 createTestData1() {
        String addr = "0xa40c864c28ee8b07dc2eeab4711e3161fc87e1e2";//TestData1Contract;
        return TestData1.load(addr, web3, credentials, gasPrice, gasLimited);
    }

    /**
     * @param contractName 合约名称
     * @description 获取系统合约地址(同步接口)
     */
    private String getContractAddr(String contractName) {
        SystemProxy systemProxy = createSystemProxy();
        Random random = new Random();
        Calendar cal = Calendar.getInstance();
        String randomString = "" + cal.getTimeInMillis() + random.nextInt(1000000000);
        Future<List<Type>> futureStr = systemProxy.getRoute(new Utf8String(contractName));
        String strAddr = null;
        try {
            Address address = ((Address) futureStr.get().get(0));
            strAddr = address.toString();

        } catch (Exception e) {
            logger.error("get contract addr fail.", contractName, e.getMessage());
            return "";
        }
        return strAddr;
    }

    /**
     * @description 同步接口： 获取服务器列表
     */
    public int listFileServersSync() {
        FileServer fileServer = new FileServer();
        fileServer.setHost(host);
        fileServer.setPort(port);

        FileServerManager fileServerManager = createFileServerManager(/*fileServer*/);
        Future<Utf8String> futureStr = fileServerManager.listAll();
        Utf8String strUtf8Json = null;
        try {
            strUtf8Json = futureStr.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return DfsConst.DFS_ERROR_FAIL;
        }

        String strjson = strUtf8Json.getValue();
        QueryResultJson objQueryJson = JSON.parseObject(strjson, QueryResultJson.class);
        if (objQueryJson.getRet() != DfsConst.DFS_ERROR_OK &&
                objQueryJson.getRet() != DfsConst.DFS_ERROR_SUCCESS) {
            return DfsConst.DFS_ERROR_FAIL;
        }

        Vector<FileServer> vecServers = new Vector<FileServer>();
        for (JSONObject object : objQueryJson.getData().getItems()) {
            FileServer server = JSON.toJavaObject(object, FileServer.class);
            vecServers.add(server);
        }
        if (vecServers.isEmpty()) {
            return DfsConst.DFS_ERROR_FAIL;
        }

        //shuffle the servers
        shuffleServers(vecServers);

        locker.lock();
        fileServers.clear();
        for (FileServer server : vecServers) {
            if (server.getEnable() != 0) {
                //we only want the on service server node
                fileServers.addElement(server);
            }
        }

        locker.unlock();
        return DfsConst.DFS_ERROR_OK;
    }

    /**
     * @param vecServers 服务器列表
     * @description 随机化服务器
     */
    private void shuffleServers(Vector<FileServer> vecServers) {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        random.setSeed(calendar.getTimeInMillis() / 1000);
        Collections.shuffle(vecServers, random);
    }

    /**
     * @param host 主机地址
     * @param port JSONRPC端口
     * @return
     */
    private Parity createParity(String host, int port) {
        Parity parity;
        String uri = "http://";
        uri += host;
        uri += ":";
        uri += port;

        parity = Parity.build(new HttpService(uri));
        return parity;
    }

    /**
     * @param fileServer 文件服务器节点
     * @return
     */
    private Parity createParity(FileServer fileServer) {
        return createParity(fileServer.getHost(), fileServer.getPort());
    }

    /**
     * @description 检查server参数
     */
    private boolean checkFileServer(FileServer fileServer) {
        if (fileServer.getHost().isEmpty() || fileServer.getPort() <= 0 || !isServerParamValid(fileServer)) {
            return false;
        }

        return true;
    }

    /**
     * @description 检查null或空串
     */
    private boolean isServerParamValid(FileServer fileServer) {
        if (fileServer.getId() == null || fileServer.getGroup() == null) {
            return false;
        }

        if (fileServer.getId().isEmpty() || fileServer.getGroup().isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * @param parity
     */
    private String getFirstInnerAccount(Parity parity) {
        EthAccounts accounts = null;
        try {
            accounts = parity.ethAccounts().send();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return accounts.getAccounts().get(0);
    }

    public COUFactory createCOUFactory() {
        String addr = COUFactoryContract;

        return COUFactory.load(addr, web3, credentials, gasPrice, gasLimited);
    }

    public COULogic createCOULogic() {
        String addr = COULogicContract;

        return COULogic.load(addr, web3, credentials, gasPrice, gasLimited);
    }

    private JsonData createJsonData() {
        String addr = JsonDataContract;

        return JsonData.load(addr, web3, credentials, gasPrice, gasLimited);
    }

    private FileData createFileData() {
        String addr = FileDataContract;

        return FileData.load(addr, web3, credentials, gasPrice, gasLimited);
    }

    /**
     * @description 创建SystemProxy合约对象
     */
    private SystemProxy createSystemProxy() {
        String addr = systemProxyContract;
        return SystemProxy.load(addr, web3, credentials, gasPrice, gasLimited);
    }


    /**
     * @description 创建文件信息合约对象
     */
    private FileInfoManager createFileInfoManager() {

        String addr = fileInfoContract;

        return FileInfoManager.load(addr, web3, credentials, gasPrice, gasLimited);
    }

    /**
     * @description 创建文件服务合约对象
     */
    private FileServerManager createFileServerManager() {
        String addr = fileServerContract;

        return FileServerManager.load(addr, web3, credentials, gasPrice, gasLimited);
    }

    /**
     * @return 获取当前文件服务节点
     */
    public FileServer getCurrentFileServer() {
        for (FileServer server : fileServers) {
            if (server.getEnable() != 0 && server.getHost().equals(host) && server.getPort() == port)
                return server;
        }

        FileServer defaultServer = new FileServer();
        defaultServer.setPort(port);
        defaultServer.setHost(host);
        return defaultServer;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        factory = beanFactory;

    }
}

Before doing BCOS test, some necessary steps are required.

## Step 0. Deploy the smart contract on BCOS.
We will provide the smart contract named "JsonData.sol"(in the path "src/main/resources/JsonData.sol") that We used before.Deploying  is the first step when you try to test BCOS.

### The steps are as following:

1. Deploy contract on chain. For example,on bcos-test-a-01:
```
cp JsonData.sol /home/ubuntu/10.0.0.99_agent_0_genesis/build/tool
cd /home/ubuntu/10.0.0.99_agent_0_genesis/build/tool
babel-node deploy.js JsonData
```
The successful deployments will have output like this:
```
deploy.js  ........................Start........................
Soc File :JsonData
JsonDatacomplie success！
send transaction success: 0x06251b6023baab6f1fda82e4016182cec3f31c5ba95a3632fa9ee7b481b5337d
JsonDatacontract address 0xc6fc72f0fe6ebf9881a2103f2829d0e98d020062
JsonData deploy success!
```
The output "JsonDatacontract address 0xc6fc72f0fe6ebf9881a2103f2829d0e98d020062" will be used by the next step.

2. Update smart contract.

```
cd /home/ubuntu/10.0.0.99_agent_0_genesis/build/tool
babel-node cns_manager.js update JsonData
```

3. Check  line 108 of the file 'tool.js', if the code is different from the following, you need to replace the block of code ``case "SystemProxy"``.

```
cd /home/ubuntu/10.0.0.99_agent_0_genesis/build/systemcontract
vim tool.js
```
The code that works:
```js 
  case "SystemProxy":
  {   switch(func){
      // The following single case is the section we added for testing
      case "setRoute":{
        var func = "setRoute(string,address,bool)";
        var params = [options[4],options[5],false];
        var receipt = web3sync.sendRawTransaction(config.account,config.privKey,SystemProxy.address,func,params);
        break;
      }
        
      default:{
      console.log("-----------------SystemProxy route----------------------")
      var routelength=SystemProxy.getRouteSize();
      for( var i=0;i<routelength;i++){
        var key=SystemProxy.getRouteNameByIndex(i).toString();
        var route=SystemProxy.getRoute(key);
        console.log(i+" )"+ key+"=>"+route[0].toString()+","+route[1].toString()+","+route[2].toString());
      }
  }
    break;
  }
```
4. Set SystemconProxy route.
```
cd /home/ubuntu/10.0.0.99_agent_0_genesis/build/systemcontract
babel-node tool.js SystemProxy setRoute JsonData 0xc6fc72f0fe6ebf9881a2103f2829d0e98d020062
```
Successful deployments will have output like this:
```
RPC=http://0.0.0.0:8545
Ouputpath=./output/
{ HttpProvider: 'http://0.0.0.0:8545',
  Ouputpath: './output/',
  EncryptType: 0,
  privKey: 'bcec428d5205abe0f0cc8a734083908d9eb8563e31f943d760786edf42ad67dd',
  account: '0x64fa644d2a694681bd6addd6c5e36cccd8dcdde3' }
Soc File :SystemProxy
Func :setRoute
SystemProxy address 0xc77237cbab817cc3cdec01eb2c7ef8f4382fb268
send transaction success: 0x0fb73fbf27eb67b4ced8ba8f9e0715bbd654187ac9f0d88d54d72e24df421db9

```

5. Check 
```
cd /home/ubuntu/10.0.0.99_agent_0_genesis/build/systemcontract
babel-node tool.js SystemProxy list
```
Successful deployments will have output like this:
```
RPC=http://0.0.0.0:8545
Ouputpath=./output/
{ HttpProvider: 'http://0.0.0.0:8545',
  Ouputpath: './output/',
  EncryptType: 0,
  privKey: 'bcec428d5205abe0f0cc8a734083908d9eb8563e31f943d760786edf42ad67dd',
  account: '0x64fa644d2a694681bd6addd6c5e36cccd8dcdde3' }
Soc File :SystemProxy
Func :list
SystemProxy address 0xc77237cbab817cc3cdec01eb2c7ef8f4382fb268
-----------------SystemProxy route----------------------
0 )TransactionFilterChain=>0x138b0a3e4aae148ad54d76e1f28a6fc807c961b8,false,13
1 )ConfigAction=>0x848b5711591263dbd89b0d280997f3fde4dbc1a1,false,14
2 )NodeAction=>0xd0322f47ebfe49135556e2bd1a86a6d12c558faf,false,15
3 )ConsensusControlMgr=>0x720c30ef44fd2489265312bbf326e81afac3553b,false,16
4 )CAAction=>0x146d437df6aa3cf9aa76b3d269ba12f62bd2615f,false,17
5 )ContractAbiMgr=>0xd09025188c724f36c93004502f7554b3c98edf83,false,18
6 )FileInfoManager=>0x27bcccd503de86b3288144fee090077a9723049e,false,19
7 )FileServerManager=>0x47cb23b922b0c830d965b8aa0beca296df28f584,false,20
8 )JsonData=>0xc6fc72f0fe6ebf9881a2103f2829d0e98d020062,false,7
```
"JsonData" appears on route (8).


Also I have convert both of them to java files and put it at the path "./middle/src/main/java/com/wxbc/bcos/web3j/JsonData.java", 
which can be used  directly.
At this step ,you should alreay have the following terms which will be used in the next step.

    1.system proxy contract address
    2.account
    3.privKey
    4.hostIps and ports of all nodes
    5.ca.crt
    6.client.keystore
"ca.crt" and "client.keystore" are in this path "/home/ubuntu/10.0.0.99_agent_0_genesis/build/web3sdk/conf".
```
cd /home/ubuntu/10.0.0.99_agent_0_genesis/build/web3sdk/conf
ls ca.crt client.keystore
```
    
## Step 1. Modify Configurations

If you want to run this project to test BCOS, you need to modify these configurations before your testing.

1. Open file ./middle/settings.gradle and ./base/settings.gradle
Change "repo_path" to your own server address because I used my company's private repository,


2. Open file ./middle/src/resources/application.properties

Change these configurations according to the actural AWS environment
```properties

########  need to modify start ########
server.port=8463

web3j.orgid=WX
web3j.hostip=node1@10.0.0.99:8821,node2@10.0.0.51:8821,node3@10.0.0.95:8821,node4@10.0.0.223:8821,node5@10.0.0.5:8821,node6@10.0.0.86:8821,node7@10.0.0.42:8821,node8@10.0.0.208:8821,node9@10.0.0.25:8821,node10@10.0.0.26:8821
web3j.systemproxycontract=0xc77237cbab817cc3cdec01eb2c7ef8f4382fb268
web3j.account=0x64fa644d2a694681bd6addd6c5e36cccd8dcdde3
web3j.privKey=bcec428d5205abe0f0cc8a734083908d9eb8563e31f943d760786edf42ad67dd


######## need to modify end ########

```

These configurations are set for blockchain's connections;

3. Open file ./middle/src/main/java/com/wxbc/middle/utils/CommonConst.java

change these configurations to the AWS environment as well

```java

    //needs modification start
    
     public static final String caCertPath= "/home/ubuntu/1.3.5/ca.crt";
     public static final String clientKeystorePath="/home/ubuntu/1.3.5/client.keystore";
     public static final String keystorePassWord="123456";
     public static final String clientCertPassWord="123456";
        
    //needs modification end
```

These configurations are set for BCOS node's accessing permisson.

## Step 2. Run the project
Run file com.wxbc.Application to  start the project, if the project has been packaged as
a jar package, the command 'java -jar xxx.jar' can also make it running.

## Step 3. Call interface

All the interfaces are written in a file named "TestController.java".
You can call the following interface when the project is running.

1.  ${ip:port}/rest/setJsonData/{size}/{threads}
The parameter "size" represents the total number of request(or transaction),the parameter "threads" represents the number of threads working at the same time.
This interface will call the smart contract which has been deployed on the blockchain named "JsonData".
For example:
```
curl localhost:8463/rest/setJsonData/10/1
```
Successful request will have output like this:
``` 
{"returnCode":1000,"returnDesc":"Create/Insert Success","items":null}
```

Remark:

The response of the chain is asynchronous so you will receive it about 1 second later, and the first response will be printed in the console. Every one thousand responses will print one line of log. When the last one is printed, you can calculate the TPS with the total number of items and the total time cost. Or you can visit the class "com.wxbc.bcos.callback.SetDataTransctionSucCallback" to check how the result is calculated.

Here are some sample outputs:
```
[2018-12-27 11:21:17,694][nioEventLoopGroup-2-4][INFO][com.wxbc.bcos.callback.SetDataTransctionSucCallback.onResponse(SetDataTransctionSucCallback.java:46)] i = 1000 ;cost(ms) : 1412, tps :708.2152974504249
```
package com.wxbc.bcos.web3j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.EventEncoder;
import org.bcos.web3j.abi.EventValues;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Event;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.bcos.web3j.protocol.core.methods.request.EthFilter;
import org.bcos.web3j.protocol.core.methods.response.Log;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.tx.Contract;
import org.bcos.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.bcos.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version none.
 */
public final class TestData1 extends Contract {
    private static final String BINARY = "60606040526000805560018055341561001757600080fd5b6108b5806100266000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063032a02ea146100485780630e12febb1461014357600080fd5b341561005357600080fd5b610129600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061025c565b604051808215151515815260200191505060405180910390f35b341561014e57600080fd5b6101e1600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506103e1565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610221578082015181840152602081019050610206565b50505050905090810190601f16801561024e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6000816002856040518082805190602001908083835b6020831015156102975780518252602082019150602081019050602083039250610272565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060000190805190602001906102e09291906107d0565b50826002856040518082805190602001908083835b60208310151561031a57805182526020820191506020810190506020830392506102f5565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060010190805190602001906103639291906107d0565b507f6f52e1083ea2b4deef2cb48dbb504881c8b27cfedc2d85bc841b9ed1613c54cc60005460405180828152602001806020018281038252600f8152602001807f53657420435120737563636573732e00000000000000000000000000000000008152506020019250505060405180910390a1600190509392505050565b6103e9610850565b610502826002856040518082805190602001908083835b6020831015156104255780518252602082019150602081019050602083039250610400565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104ef5780601f106104c4576101008083540402835291602001916104ef565b820191906000526020600020905b8154815290600101906020018083116104d257829003601f168201915b505050505061068e90919063ffffffff16565b1561057e577f6f52e1083ea2b4deef2cb48dbb504881c8b27cfedc2d85bc841b9ed1613c54cc6001546040518082815260200180602001828103825260128152602001807f77726f6e67206669626c6e486173682e2e2e00000000000000000000000000008152506020019250505060405180910390a1610688565b6002836040518082805190602001908083835b6020831015156105b65780518252602082019150602081019050602083039250610591565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106805780601f1061065557610100808354040283529160200191610680565b820191906000526020600020905b81548152906001019060200180831161066357829003601f168201915b505050505090505b92915050565b600080825184511415156106a557600091506107c9565b600090505b83518110156107c45782818151811015156106c157fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916848281518110151561073c57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415156107b957600091506107c9565b8060010190506106aa565b600191505b5092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061081157805160ff191683800117855561083f565b8280016001018555821561083f579182015b8281111561083e578251825591602001919060010190610823565b5b50905061084c9190610864565b5090565b602060405190810160405280600081525090565b61088691905b8082111561088257600081600090555060010161086a565b5090565b905600a165627a7a72305820ed5d0eaca7199d3a1a2a57276a8f0e19556e558ed26e7a0620ccfa685c7a6c6d0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"cblnHash\",\"type\":\"string\"},{\"name\":\"fiblnHash\",\"type\":\"string\"},{\"name\":\"newAmount\",\"type\":\"string\"}],\"name\":\"setCOUCenterQuota\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"cblnHash\",\"type\":\"string\"},{\"name\":\"fiblnHash\",\"type\":\"string\"}],\"name\":\"getCOUCenterQuota\",\"outputs\":[{\"name\":\"cqSumC\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"_errno\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"_info\",\"type\":\"string\"}],\"name\":\"Notify\",\"type\":\"event\"}]";

    private TestData1(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private TestData1(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private TestData1(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private TestData1(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static List<NotifyEventResponse> getNotifyEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Notify", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NotifyEventResponse> responses = new ArrayList<NotifyEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NotifyEventResponse typedResponse = new NotifyEventResponse();
            typedResponse._errno = (Uint256) eventValues.getNonIndexedValues().get(0);
            typedResponse._info = (Utf8String) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NotifyEventResponse> notifyEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Notify", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NotifyEventResponse>() {
            @Override
            public NotifyEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NotifyEventResponse typedResponse = new NotifyEventResponse();
                typedResponse._errno = (Uint256) eventValues.getNonIndexedValues().get(0);
                typedResponse._info = (Utf8String) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> setCOUCenterQuota(Utf8String cblnHash, Utf8String fiblnHash, Utf8String newAmount) {
        Function function = new Function("setCOUCenterQuota", Arrays.<Type>asList(cblnHash, fiblnHash, newAmount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCOUCenterQuota(Utf8String cblnHash, Utf8String fiblnHash, Utf8String newAmount, TransactionSucCallback callback) {
        Function function = new Function("setCOUCenterQuota", Arrays.<Type>asList(cblnHash, fiblnHash, newAmount), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Utf8String> getCOUCenterQuota(Utf8String cblnHash, Utf8String fiblnHash) {
        Function function = new Function("getCOUCenterQuota", 
                Arrays.<Type>asList(cblnHash, fiblnHash), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<TestData1> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(TestData1.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<TestData1> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(TestData1.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static TestData1 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestData1(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static TestData1 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestData1(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static TestData1 loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestData1(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static TestData1 loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestData1(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }

    public static class NotifyEventResponse {
        public Uint256 _errno;

        public Utf8String _info;
    }
}

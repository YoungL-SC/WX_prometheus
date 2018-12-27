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
import org.bcos.web3j.abi.datatypes.generated.Int256;
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
public final class TestData extends Contract {
    private static final String BINARY = "60606040526000805560018055341561001757600080fd5b600061100190508073ffffffffffffffffffffffffffffffffffffffff166356004b6a6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001806020018481038452600a8152602001807f745f546573744461746100000000000000000000000000000000000000000000815250602001848103835260088152602001807f63626c6e48617368000000000000000000000000000000000000000000000000815250602001848103825260108152602001807f637153756d432c6669626c6e48617368000000000000000000000000000000008152506020019350505050602060405180830381600087803b151561013857600080fd5b6102c65a03f1151561014957600080fd5b505050604051805190505050610c17806101646000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630e12febb14610048578063d3db3e3f146100fc57600080fd5b341561005357600080fd5b6100e6600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506101bd565b6040518082815260200191505060405180910390f35b341561010757600080fd5b6101a3600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091908035906020019091905050610742565b604051808215151515815260200191505060405180910390f35b600080600080600080600061100195508573ffffffffffffffffffffffffffffffffffffffff1663c184e0ff6000604051602001526040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600a8152602001807f745f546573744461746100000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b151561027557600080fd5b6102c65a03f1151561028657600080fd5b5050506040518051905094508473ffffffffffffffffffffffffffffffffffffffff16637857d7c96000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15156102fe57600080fd5b6102c65a03f1151561030f57600080fd5b5050506040518051905093508373ffffffffffffffffffffffffffffffffffffffff1663cd30a1d1896040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260098152602001807f6669626c6e486173680000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b838110156103db5780820151818401526020810190506103c0565b50505050905090810190601f1680156104085780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b151561042757600080fd5b6102c65a03f1151561043857600080fd5b5050508473ffffffffffffffffffffffffffffffffffffffff1663e8434e398a866000604051602001526040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b838110156104ff5780820151818401526020810190506104e4565b50505050905090810190601f16801561052c5780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b151561054b57600080fd5b6102c65a03f1151561055c57600080fd5b5050506040518051905092508273ffffffffffffffffffffffffffffffffffffffff1663846719e0600080604051602001526040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b15156105df57600080fd5b6102c65a03f115156105f057600080fd5b5050506040518051905091508173ffffffffffffffffffffffffffffffffffffffff1663fda69fae6000604051602001526040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260068152602001807f637153756d430000000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15156106a457600080fd5b6102c65a03f115156106b557600080fd5b5050506040518051905090507f6f52e1083ea2b4deef2cb48dbb504881c8b27cfedc2d85bc841b9ed1613c54cc60005460405180828152602001806020018281038252601a8152602001807f73656c656374526573756c74207375636365737366756c2e2e2e0000000000008152506020019250505060405180910390a180965050505050505092915050565b600080600080600061100193508373ffffffffffffffffffffffffffffffffffffffff1663c184e0ff6000604051602001526040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600a8152602001807f745f546573744461746100000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15156107f757600080fd5b6102c65a03f1151561080857600080fd5b5050506040518051905092508273ffffffffffffffffffffffffffffffffffffffff166313db93466000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b151561088057600080fd5b6102c65a03f1151561089157600080fd5b5050506040518051905091508173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74876040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001838152602001828103825260068152602001807f637153756d43000000000000000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b151561094457600080fd5b6102c65a03f1151561095557600080fd5b5050508173ffffffffffffffffffffffffffffffffffffffff1663e942b516886040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260098152602001807f6669626c6e486173680000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015610a185780820151818401526020810190506109fd565b50505050905090810190601f168015610a455780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b1515610a6457600080fd5b6102c65a03f11515610a7557600080fd5b5050508273ffffffffffffffffffffffffffffffffffffffff166331afac3689846000604051602001526040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b83811015610b3c578082015181840152602081019050610b21565b50505050905090810190601f168015610b695780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b1515610b8857600080fd5b6102c65a03f11515610b9957600080fd5b5050506040518051905090507f0bdcb3b747cf033ae78b4b6e1576d2725709d03f68ad3d641b12cb72de614354816040518082815260200191505060405180910390a1600194505050505093925050505600a165627a7a723058207a17e2cb73edd7e43eb488007e9254b37f9b399d2adee52ffcc0e8e0348e1c5d0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"cblnHash\",\"type\":\"string\"},{\"name\":\"fiblnHash\",\"type\":\"string\"}],\"name\":\"getCOUCenterQuota\",\"outputs\":[{\"name\":\"cqSumC\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"cblnHash\",\"type\":\"string\"},{\"name\":\"fiblnHash\",\"type\":\"string\"},{\"name\":\"newAmount\",\"type\":\"int256\"}],\"name\":\"setCOUCenterQuota\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"_errno\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"_info\",\"type\":\"string\"}],\"name\":\"Notify\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"updateResult\",\"type\":\"event\"}]";

    private TestData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private TestData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private TestData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private TestData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public static List<UpdateResultEventResponse> getUpdateResultEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("updateResult", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UpdateResultEventResponse> responses = new ArrayList<UpdateResultEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UpdateResultEventResponse typedResponse = new UpdateResultEventResponse();
            typedResponse.count = (Int256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UpdateResultEventResponse> updateResultEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("updateResult", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UpdateResultEventResponse>() {
            @Override
            public UpdateResultEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UpdateResultEventResponse typedResponse = new UpdateResultEventResponse();
                typedResponse.count = (Int256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Future<Int256> getCOUCenterQuota(Utf8String cblnHash, Utf8String fiblnHash) {
        Function function = new Function("getCOUCenterQuota", 
                Arrays.<Type>asList(cblnHash, fiblnHash), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setCOUCenterQuota(Utf8String cblnHash, Utf8String fiblnHash, Int256 newAmount) {
        Function function = new Function("setCOUCenterQuota", Arrays.<Type>asList(cblnHash, fiblnHash, newAmount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCOUCenterQuota(Utf8String cblnHash, Utf8String fiblnHash, Int256 newAmount, TransactionSucCallback callback) {
        Function function = new Function("setCOUCenterQuota", Arrays.<Type>asList(cblnHash, fiblnHash, newAmount), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<TestData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(TestData.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<TestData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(TestData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static TestData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestData(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static TestData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestData(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static TestData loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestData(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static TestData loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestData(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }

    public static class NotifyEventResponse {
        public Uint256 _errno;

        public Utf8String _info;
    }

    public static class UpdateResultEventResponse {
        public Int256 count;
    }
}

package com.wxbc.bcos.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.tx.Contract;
import org.bcos.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.bcos.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version none.
 */
public final class JsonData extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b61045d8061001e6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063683ee59b14610048578063d68e37071461010057600080fd5b341561005357600080fd5b6100e6600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506101d6565b604051808215151515815260200191505060405180910390f35b341561010b57600080fd5b61015b600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610262565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561019b578082015181840152602081019050610180565b50505050905090810190601f1680156101c85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6000816000846040518082805190602001908083835b60208310151561021157805182526020820191506020810190506020830392506101ec565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390209080519060200190610257929190610378565b506001905092915050565b61026a6103f8565b6000826040518082805190602001908083835b6020831015156102a2578051825260208201915060208101905060208303925061027d565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390208054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103695780601f1061033e57610100808354040283529160200191610369565b820191906000526020600020905b81548152906001019060200180831161034c57829003601f168201915b50505050509050809050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106103b957805160ff19168380011785556103e7565b828001600101855582156103e7579182015b828111156103e65782518255916020019190600101906103cb565b5b5090506103f4919061040c565b5090565b602060405190810160405280600081525090565b61042e91905b8082111561042a576000816000905550600101610412565b5090565b905600a165627a7a723058209f450b2ca1d49da916c1ad4d4ef6614483b9f9b513d21513c0fcc5825210be470029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"jsonKey\",\"type\":\"string\"},{\"name\":\"jsonValue\",\"type\":\"string\"}],\"name\":\"setJsonData\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"jsonKey\",\"type\":\"string\"}],\"name\":\"getJsonData\",\"outputs\":[{\"name\":\"data\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    private JsonData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private JsonData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private JsonData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private JsonData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public Future<TransactionReceipt> setJsonData(Utf8String jsonKey, Utf8String jsonValue) {
        Function function = new Function("setJsonData", Arrays.<Type>asList(jsonKey, jsonValue), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setJsonData(Utf8String jsonKey, Utf8String jsonValue, TransactionSucCallback callback) {
        Function function = new Function("setJsonData", Arrays.<Type>asList(jsonKey, jsonValue), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Utf8String> getJsonData(Utf8String jsonKey) {
        Function function = new Function("getJsonData", 
                Arrays.<Type>asList(jsonKey), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<JsonData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(JsonData.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<JsonData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(JsonData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static JsonData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new JsonData(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static JsonData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new JsonData(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static JsonData loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new JsonData(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static JsonData loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new JsonData(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }
}

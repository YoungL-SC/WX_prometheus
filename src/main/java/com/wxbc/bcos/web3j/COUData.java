package com.wxbc.bcos.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.StaticArray;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Bytes1;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
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
public final class COUData extends Contract {
    private static final String BINARY = "";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"}],\"name\":\"getCQMapfIPubkeyByKey\",\"outputs\":[{\"name\":\"pubkeyArr\",\"type\":\"bytes1[1024]\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"COUHash\",\"type\":\"string\"},{\"name\":\"amt\",\"type\":\"uint256\"}],\"name\":\"setCOUInfoMapAmountByKey\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"setCQMapCenterPaidByKey\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"COUHash\",\"type\":\"string\"}],\"name\":\"getCOUInfoMapStatusByKey\",\"outputs\":[{\"name\":\"status\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"COUHash\",\"type\":\"string\"},{\"name\":\"Owner\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"setCOUInfoIntoMap\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"setCQMapCenterIssuedByKey\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"}],\"name\":\"getCQMapCenterPaidByKey\",\"outputs\":[{\"name\":\"amount\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ivHash\",\"type\":\"string\"}],\"name\":\"setInvSts\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"}],\"name\":\"getCQMapCenterQuotaByKey\",\"outputs\":[{\"name\":\"amount\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"COUHash\",\"type\":\"string\"}],\"name\":\"getCOUInfoMapOwnerByKey\",\"outputs\":[{\"name\":\"owner\",\"type\":\"bytes1[1024]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"COUHash\",\"type\":\"string\"}],\"name\":\"getCOUInfoMapAmountByKey\",\"outputs\":[{\"name\":\"amount\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"i\",\"type\":\"uint256\"}],\"name\":\"getCQInfoListByIndex\",\"outputs\":[{\"name\":\"fibln\",\"type\":\"bytes1[1024]\"},{\"name\":\"cbln\",\"type\":\"bytes1[1024]\"},{\"name\":\"CQTMHash\",\"type\":\"bytes1[1024]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"}],\"name\":\"getCQMapfiBnByKey\",\"outputs\":[{\"name\":\"fiBnArr\",\"type\":\"bytes1[1024]\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"ivHash\",\"type\":\"string\"}],\"name\":\"getInvSts\",\"outputs\":[{\"name\":\"status\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"fibln\",\"type\":\"string\"}],\"name\":\"setCQMapfIPubkeyByKey\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"fibln\",\"type\":\"string\"},{\"name\":\"cbln\",\"type\":\"string\"},{\"name\":\"setCQTimeHash\",\"type\":\"string\"}],\"name\":\"setCQInfoIntoList\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"COUHash\",\"type\":\"string\"},{\"name\":\"status\",\"type\":\"uint256\"}],\"name\":\"setCOUInfoMapStatusByKey\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"fibln\",\"type\":\"string\"}],\"name\":\"setCQMapfiBnByKey\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getCQInfoListLength\",\"outputs\":[{\"name\":\"len\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"setCQMapCenterQuotaByKey\",\"outputs\":[{\"name\":\"ret\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"}],\"name\":\"getCQMapCenterIssuedByKey\",\"outputs\":[{\"name\":\"amount\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    private COUData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private COUData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private COUData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private COUData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public Future<TransactionReceipt> getCQMapfIPubkeyByKey(Utf8String key) {
        Function function = new Function("getCQMapfIPubkeyByKey", Arrays.<Type>asList(key), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void getCQMapfIPubkeyByKey(Utf8String key, TransactionSucCallback callback) {
        Function function = new Function("getCQMapfIPubkeyByKey", Arrays.<Type>asList(key), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> setCOUInfoMapAmountByKey(Utf8String COUHash, Uint256 amt) {
        Function function = new Function("setCOUInfoMapAmountByKey", Arrays.<Type>asList(COUHash, amt), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCOUInfoMapAmountByKey(Utf8String COUHash, Uint256 amt, TransactionSucCallback callback) {
        Function function = new Function("setCOUInfoMapAmountByKey", Arrays.<Type>asList(COUHash, amt), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> setCQMapCenterPaidByKey(Utf8String key, Uint256 amount) {
        Function function = new Function("setCQMapCenterPaidByKey", Arrays.<Type>asList(key, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCQMapCenterPaidByKey(Utf8String key, Uint256 amount, TransactionSucCallback callback) {
        Function function = new Function("setCQMapCenterPaidByKey", Arrays.<Type>asList(key, amount), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> getCOUInfoMapStatusByKey(Utf8String COUHash) {
        Function function = new Function("getCOUInfoMapStatusByKey", 
                Arrays.<Type>asList(COUHash), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setCOUInfoIntoMap(Utf8String COUHash, Utf8String Owner, Uint256 amount) {
        Function function = new Function("setCOUInfoIntoMap", Arrays.<Type>asList(COUHash, Owner, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCOUInfoIntoMap(Utf8String COUHash, Utf8String Owner, Uint256 amount, TransactionSucCallback callback) {
        Function function = new Function("setCOUInfoIntoMap", Arrays.<Type>asList(COUHash, Owner, amount), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> setCQMapCenterIssuedByKey(Utf8String key, Uint256 amount) {
        Function function = new Function("setCQMapCenterIssuedByKey", Arrays.<Type>asList(key, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCQMapCenterIssuedByKey(Utf8String key, Uint256 amount, TransactionSucCallback callback) {
        Function function = new Function("setCQMapCenterIssuedByKey", Arrays.<Type>asList(key, amount), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> getCQMapCenterPaidByKey(Utf8String key) {
        Function function = new Function("getCQMapCenterPaidByKey", 
                Arrays.<Type>asList(key), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setInvSts(Utf8String ivHash) {
        Function function = new Function("setInvSts", Arrays.<Type>asList(ivHash), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setInvSts(Utf8String ivHash, TransactionSucCallback callback) {
        Function function = new Function("setInvSts", Arrays.<Type>asList(ivHash), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> getCQMapCenterQuotaByKey(Utf8String key) {
        Function function = new Function("getCQMapCenterQuotaByKey", 
                Arrays.<Type>asList(key), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<StaticArray<Bytes1>> getCOUInfoMapOwnerByKey(Utf8String COUHash) {
        Function function = new Function("getCOUInfoMapOwnerByKey", 
                Arrays.<Type>asList(COUHash), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray<Bytes1>>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getCOUInfoMapAmountByKey(Utf8String COUHash) {
        Function function = new Function("getCOUInfoMapAmountByKey", 
                Arrays.<Type>asList(COUHash), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<List<Type>> getCQInfoListByIndex(Uint256 i) {
        Function function = new Function("getCQInfoListByIndex", 
                Arrays.<Type>asList(i), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray<Bytes1>>() {}, new TypeReference<StaticArray<Bytes1>>() {}, new TypeReference<StaticArray<Bytes1>>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> getCQMapfiBnByKey(Utf8String key) {
        Function function = new Function("getCQMapfiBnByKey", Arrays.<Type>asList(key), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void getCQMapfiBnByKey(Utf8String key, TransactionSucCallback callback) {
        Function function = new Function("getCQMapfiBnByKey", Arrays.<Type>asList(key), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> getInvSts(Utf8String ivHash) {
        Function function = new Function("getInvSts", 
                Arrays.<Type>asList(ivHash), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setCQMapfIPubkeyByKey(Utf8String key, Utf8String fibln) {
        Function function = new Function("setCQMapfIPubkeyByKey", Arrays.<Type>asList(key, fibln), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCQMapfIPubkeyByKey(Utf8String key, Utf8String fibln, TransactionSucCallback callback) {
        Function function = new Function("setCQMapfIPubkeyByKey", Arrays.<Type>asList(key, fibln), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> setCQInfoIntoList(Utf8String fibln, Utf8String cbln, Utf8String setCQTimeHash) {
        Function function = new Function("setCQInfoIntoList", Arrays.<Type>asList(fibln, cbln, setCQTimeHash), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCQInfoIntoList(Utf8String fibln, Utf8String cbln, Utf8String setCQTimeHash, TransactionSucCallback callback) {
        Function function = new Function("setCQInfoIntoList", Arrays.<Type>asList(fibln, cbln, setCQTimeHash), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> setCOUInfoMapStatusByKey(Utf8String COUHash, Uint256 status) {
        Function function = new Function("setCOUInfoMapStatusByKey", Arrays.<Type>asList(COUHash, status), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCOUInfoMapStatusByKey(Utf8String COUHash, Uint256 status, TransactionSucCallback callback) {
        Function function = new Function("setCOUInfoMapStatusByKey", Arrays.<Type>asList(COUHash, status), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> setCQMapfiBnByKey(Utf8String key, Utf8String fibln) {
        Function function = new Function("setCQMapfiBnByKey", Arrays.<Type>asList(key, fibln), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCQMapfiBnByKey(Utf8String key, Utf8String fibln, TransactionSucCallback callback) {
        Function function = new Function("setCQMapfiBnByKey", Arrays.<Type>asList(key, fibln), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> getCQInfoListLength() {
        Function function = new Function("getCQInfoListLength", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setCQMapCenterQuotaByKey(Utf8String key, Uint256 amount) {
        Function function = new Function("setCQMapCenterQuotaByKey", Arrays.<Type>asList(key, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setCQMapCenterQuotaByKey(Utf8String key, Uint256 amount, TransactionSucCallback callback) {
        Function function = new Function("setCQMapCenterQuotaByKey", Arrays.<Type>asList(key, amount), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> getCQMapCenterIssuedByKey(Utf8String key) {
        Function function = new Function("getCQMapCenterIssuedByKey", 
                Arrays.<Type>asList(key), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<COUData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(COUData.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<COUData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(COUData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static COUData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new COUData(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static COUData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new COUData(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static COUData loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new COUData(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static COUData loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new COUData(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }
}

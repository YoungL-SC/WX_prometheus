package com.wxbc.bcos.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Bool;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
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
public final class SystemProxy extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b61078c8061001e6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631b5f03a61461005e578063d1c4c2061461010d578063d5aa1a2614610194578063e3e1dcb3146101bd57600080fd5b341561006957600080fd5b6100b9600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610259565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183151515158152602001828152602001935050505060405180910390f35b341561011857600080fd5b610192600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803515159060200190919050506103e4565b005b341561019f57600080fd5b6101a7610538565b6040518082815260200191505060405180910390f35b34156101c857600080fd5b6101de6004808035906020019091905050610545565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561021e578082015181840152602081019050610203565b50505050905090810190601f16801561024b5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b600080600080846040518082805190602001908083835b6020831015156102955780518252602082019150602081019050602083039250610270565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000856040518082805190602001908083835b60208310151561032457805182526020820191506020810190506020830392506102ff565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060000160149054906101000a900460ff166000866040518082805190602001908083835b6020831015156103a0578051825260208201915060208101905060208303925061037b565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600101549250925092509193909250565b6060604051908101604052808373ffffffffffffffffffffffffffffffffffffffff1681526020018215158152602001438152506000846040518082805190602001908083835b602083101515610450578051825260208201915060208101905060208303925061042b565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160000160146101000a81548160ff021916908315150217905550604082015181600101559050506001805480600101828161050b9190610607565b916000526020600020900160008590919091509080519060200190610531929190610633565b5050505050565b6000600180549050905090565b61054d6106b3565b60018281548110151561055c57fe5b90600052602060002090018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105fb5780601f106105d0576101008083540402835291602001916105fb565b820191906000526020600020905b8154815290600101906020018083116105de57829003601f168201915b50505050509050919050565b81548183558181151161062e5781836000526020600020918201910161062d91906106c7565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061067457805160ff19168380011785556106a2565b828001600101855582156106a2579182015b828111156106a1578251825591602001919060010190610686565b5b5090506106af91906106f3565b5090565b602060405190810160405280600081525090565b6106f091905b808211156106ec57600081816106e39190610718565b506001016106cd565b5090565b90565b61071591905b808211156107115760008160009055506001016106f9565b5090565b90565b50805460018160011615610100020316600290046000825580601f1061073e575061075d565b601f01602090049060005260206000209081019061075c91906106f3565b5b505600a165627a7a723058208e9eaebb21ef34f3ead584e5f4b84d157c057dedae4a8cf41930f25192b9f8e50029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"}],\"name\":\"getRoute\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"addr\",\"type\":\"address\"},{\"name\":\"cache\",\"type\":\"bool\"}],\"name\":\"setRoute\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getRouteSize\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"getRouteNameByIndex\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]";

    private SystemProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private SystemProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private SystemProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private SystemProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public Future<List<Type>> getRoute(Utf8String key) {
        Function function = new Function("getRoute", 
                Arrays.<Type>asList(key), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setRoute(Utf8String key, Address addr, Bool cache) {
        Function function = new Function("setRoute", Arrays.<Type>asList(key, addr, cache), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setRoute(Utf8String key, Address addr, Bool cache, TransactionSucCallback callback) {
        Function function = new Function("setRoute", Arrays.<Type>asList(key, addr, cache), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> getRouteSize() {
        Function function = new Function("getRouteSize", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> getRouteNameByIndex(Uint256 index) {
        Function function = new Function("getRouteNameByIndex", 
                Arrays.<Type>asList(index), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<SystemProxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(SystemProxy.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<SystemProxy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(SystemProxy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static SystemProxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SystemProxy(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static SystemProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SystemProxy(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static SystemProxy loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SystemProxy(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static SystemProxy loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SystemProxy(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }
}

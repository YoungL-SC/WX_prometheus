package com.wxbc.bcos.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Int256;
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
public final class OwnerNamed extends Contract {
    private static final String BINARY = "60606040526000600155341561001457600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555061143a806100636000396000f300606060405236156100b8576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063180db1b4146100bd5780631bd95155146100e65780632ced7cef14610157578063319af3331461024e5780633ca6268e146102de5780633ffbd47f1461035857806341304fac146103f857806341c0e1b5146104695780634b5c42771461047e5780635e01eb5a14610532578063893d20e8146105c0578063b60e72cc1461064e575b600080fd5b34156100c857600080fd5b6100d06106c8565b6040518082815260200191505060405180910390f35b34156100f157600080fd5b610141600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506106d2565b6040518082815260200191505060405180910390f35b341561016257600080fd5b610238600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506107a9565b6040518082815260200191505060405180910390f35b341561025957600080fd5b6102c8600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061081e565b6040518082815260200191505060405180910390f35b34156102e957600080fd5b610342600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919080359060200190919050506108a4565b6040518082815260200191505060405180910390f35b341561036357600080fd5b6103f6600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610914565b005b341561040357600080fd5b610453600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610918565b6040518082815260200191505060405180910390f35b341561047457600080fd5b61047c61094c565b005b341561048957600080fd5b61051c600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506109aa565b6040518082815260200191505060405180910390f35b341561053d57600080fd5b6105456109ef565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561058557808201518184015260208101905061056a565b50505050905090810190601f1680156105b25780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156105cb57600080fd5b6105d3610a1b565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156106135780820151818401526020810190506105f8565b50505050905090810190601f1680156106405780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561065957600080fd5b6106b2600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091908035906020019091905050610a68565b6040518082815260200191505060405180910390f35b6000600154905090565b60008060008351915060208211156106e957602091505b60009250600090505b60208110156107a2578181101561078f57838181518110151561071157fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027f0100000000000000000000000000000000000000000000000000000000000000900460ff166101008402019250610797565b610100830292505b8060010190506106f2565b5050919050565b60006107b36113e6565b602060405190810160405280600081525090506107db858583610ad49092919063ffffffff16565b90506107e6836106d2565b600102600019166107f6826106d2565b60010260405180826000191660001916815260200191505060405180910390a1509392505050565b60006108286113e6565b6020604051908101604052806000815250905061086e8461085e8573ffffffffffffffffffffffffffffffffffffffff16610b70565b83610ad49092919063ffffffff16565b9050610879816106d2565b60010260405180826000191660001916815260200191505060405180910390a0600091505092915050565b60006108ae6113e6565b602060405190810160405280600081525090506108de846108ce85610d7a565b83610ad49092919063ffffffff16565b90506108e9816106d2565b60010260405180826000191660001916815260200191505060405180910390a0600091505092915050565b5050565b6000610923826106d2565b60010260405180826000191660001916815260200191505060405180910390a060009050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156109a7576109a8565b5b565b60006109b5826106d2565b600102600019166109c5846106d2565b60010260405180826000191660001916815260200191505060405180910390a16000905092915050565b6109f76113e6565b610a163373ffffffffffffffffffffffffffffffffffffffff16610f54565b905090565b610a236113e6565b610a636000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16610f54565b905090565b6000610a726113e6565b60206040519081016040528060008152509050610aa284610a9285611161565b83610ad49092919063ffffffff16565b9050610aad816106d2565b60010260405180826000191660001916815260200191505060405180910390a05092915050565b610adc6113e6565b6000806000806000865188518a510101604051805910610af95750595b9080825280602002602001820160405250955060208901945060208801935060208701925060208601915060009050610b36818301868b516112ab565b885181019050610b4a818301858a516112ab565b875181019050610b5e8183018489516112ab565b86518101905050505050509392505050565b610b786113e6565b600080602a604051805910610b8a5750595b908082528060200260200182016040525092507f3000000000000000000000000000000000000000000000000000000000000000836000815181101515610bcd57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053507f7800000000000000000000000000000000000000000000000000000000000000836001815181101515610c2d57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350602991505b60028260ff16101515610d7357600f84169050601084811515610c8157fe5b049350600a8160ff161015610cfc57603081017f010000000000000000000000000000000000000000000000000000000000000002838360ff16815181101515610cc757fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350610d67565b6061600a8203017f010000000000000000000000000000000000000000000000000000000000000002838360ff16815181101515610d3657fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b81600190039150610c62565b5050919050565b610d826113e6565b600080600080600080871415610dcf576040805190810160405280600181526020017f30000000000000000000000000000000000000000000000000000000000000008152509550610f4a565b86945060019350600092506000871215610df6578660000394506000935082806001019350505b8491505b6000821115610e1f57600a82811515610e0f57fe5b0491508280600101935050610dfa565b8260ff16604051805910610e305750595b90808252806020026020018201604052509550831515610eab577f2d00000000000000000000000000000000000000000000000000000000000000866000815181101515610e7a57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b6001830390505b6000851115610f49576030600a86811515610ec957fe5b06017f01000000000000000000000000000000000000000000000000000000000000000286828060019003935060ff16815181101515610f0557fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350600a85811515610f4157fe5b049450610eb2565b5b5050505050919050565b610f5c6113e6565b610f646113fa565b6000806000806028604051805910610f795750595b90808252806020026020018201604052509450600093505b6014841015611154578360130360080260020a8773ffffffffffffffffffffffffffffffffffffffff16811515610fc457fe5b047f01000000000000000000000000000000000000000000000000000000000000000292506010837f0100000000000000000000000000000000000000000000000000000000000000900460ff1681151561101b57fe5b047f0100000000000000000000000000000000000000000000000000000000000000029150817f01000000000000000000000000000000000000000000000000000000000000009004601002837f01000000000000000000000000000000000000000000000000000000000000009004037f01000000000000000000000000000000000000000000000000000000000000000290506110b9826112f6565b85856002028151811015156110ca57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350611103816112f6565b856001866002020181518110151561111757fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053508380600101945050610f91565b8495505050505050919050565b6111696113e6565b6000806000808514156111b3576040805190810160405280600181526020017f300000000000000000000000000000000000000000000000000000000000000081525093506112a3565b600092508491505b60008211156111e057600a828115156111d057fe5b04915082806001019350506111bb565b8260ff166040518059106111f15750595b908082528060200260200182016040525093506001830390505b60008511156112a2576030600a8681151561122257fe5b06017f01000000000000000000000000000000000000000000000000000000000000000284828060019003935060ff1681518110151561125e57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350600a8581151561129a57fe5b04945061120b565b5b505050919050565b60005b6020821015156112d357825184526020840193506020830192506020820391506112ae565b6001826020036101000a0390508019835116818551168181178652505050505050565b6000600a7f010000000000000000000000000000000000000000000000000000000000000002827effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161015611395576030827f01000000000000000000000000000000000000000000000000000000000000009004017f01000000000000000000000000000000000000000000000000000000000000000290506113e1565b6057827f01000000000000000000000000000000000000000000000000000000000000009004017f01000000000000000000000000000000000000000000000000000000000000000290505b919050565b602060405190810160405280600081525090565b6020604051908101604052806000815250905600a165627a7a723058205293c518113cef2d7001111411e069bbfe2ed5d054ae442f34d81cafa7c3b7de0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"getErrno\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_str\",\"type\":\"string\"}],\"name\":\"stringToUint\",\"outputs\":[{\"name\":\"_ret\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_str\",\"type\":\"string\"},{\"name\":\"_str2\",\"type\":\"string\"},{\"name\":\"_topic\",\"type\":\"string\"}],\"name\":\"log\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_str\",\"type\":\"string\"},{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"log\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_str\",\"type\":\"string\"},{\"name\":\"_i\",\"type\":\"int256\"}],\"name\":\"log\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_version\",\"type\":\"string\"}],\"name\":\"register\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_str\",\"type\":\"string\"}],\"name\":\"log\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"kill\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_str\",\"type\":\"string\"},{\"name\":\"_topic\",\"type\":\"string\"}],\"name\":\"log\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getSender\",\"outputs\":[{\"name\":\"_ret\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"_ret\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_str\",\"type\":\"string\"},{\"name\":\"_ui\",\"type\":\"uint256\"}],\"name\":\"log\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    private OwnerNamed(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private OwnerNamed(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private OwnerNamed(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private OwnerNamed(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public Future<Uint256> getErrno() {
        Function function = new Function("getErrno", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> stringToUint(Utf8String _str) {
        Function function = new Function("stringToUint", 
                Arrays.<Type>asList(_str), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> log(Utf8String _str, Utf8String _str2, Utf8String _topic) {
        Function function = new Function("log", 
                Arrays.<Type>asList(_str, _str2, _topic), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> log(Utf8String _str, Address _addr) {
        Function function = new Function("log", 
                Arrays.<Type>asList(_str, _addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> log(Utf8String _str, Int256 _i) {
        Function function = new Function("log", 
                Arrays.<Type>asList(_str, _i), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> register(Utf8String _name, Utf8String _version) {
        Function function = new Function("register", Arrays.<Type>asList(_name, _version), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void register(Utf8String _name, Utf8String _version, TransactionSucCallback callback) {
        Function function = new Function("register", Arrays.<Type>asList(_name, _version), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> log(Utf8String _str) {
        Function function = new Function("log", 
                Arrays.<Type>asList(_str), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> kill() {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void kill(TransactionSucCallback callback) {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> log(Utf8String _str, Utf8String _topic) {
        Function function = new Function("log", 
                Arrays.<Type>asList(_str, _topic), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> getSender() {
        Function function = new Function("getSender", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> getOwner() {
        Function function = new Function("getOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> log(Utf8String _str, Uint256 _ui) {
        Function function = new Function("log", 
                Arrays.<Type>asList(_str, _ui), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<OwnerNamed> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(OwnerNamed.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<OwnerNamed> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(OwnerNamed.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static OwnerNamed load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new OwnerNamed(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static OwnerNamed load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new OwnerNamed(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static OwnerNamed loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new OwnerNamed(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static OwnerNamed loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new OwnerNamed(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }
}

/**
 * 
 */
package com.wxbc.bcos.web3j.tx;

import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.DefaultBlockParameterName;
import org.bcos.web3j.protocol.core.Request;
import org.bcos.web3j.protocol.core.methods.request.RawTransaction;
import org.bcos.web3j.protocol.core.methods.response.EthBlockNumber;
import org.bcos.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.bcos.web3j.protocol.core.methods.response.EthSendTransaction;
import org.bcos.web3j.tx.ChainId;
import org.bcos.web3j.tx.TransactionManager;
import org.bcos.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

/*import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.RawTransaction;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.tx.ChainId;
import org.web3j.tx.TransactionManager;
import org.web3j.utils.Numeric;*/

/**
 * @author Administrator
 *
 */
public class DfsRawTransactionManager extends TransactionManager {

	private final Web3j web3j;
    final Credentials credentials;

    private final byte chainId;
    private com.wxbc.bcos.web3j.tx.DfsTransactionEncoder juTransactionEncoder;

    public DfsRawTransactionManager(Web3j web3j, Credentials credentials, byte chainId) {
        super(web3j);
        this.web3j = web3j;
        this.credentials = credentials;

        this.chainId = chainId;
        this.juTransactionEncoder = new com.wxbc.bcos.web3j.tx.DfsTransactionEncoder();
    }

    public DfsRawTransactionManager(
            Web3j web3j, Credentials credentials, byte chainId, int attempts, int sleepDuration) {
        super(web3j, attempts, sleepDuration);
        this.web3j = web3j;
        this.credentials = credentials;

        this.chainId = chainId;
        this.juTransactionEncoder = new DfsTransactionEncoder();
    }

    public DfsRawTransactionManager(Web3j web3j, Credentials credentials) {
        this(web3j, credentials, ChainId.NONE);
    }

    public DfsRawTransactionManager(
            Web3j web3j, Credentials credentials, int attempts, int sleepDuration) {
        this(web3j, credentials, ChainId.NONE, attempts, sleepDuration);
    }

    BigInteger getNonce() throws ExecutionException, InterruptedException {
        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                credentials.getAddress(), DefaultBlockParameterName.LATEST).sendAsync().get();

        return ethGetTransactionCount.getTransactionCount();
    }
    
/*
    public EthSendTransaction sendTransaction(
            BigInteger gasPrice, BigInteger gasLimit, String to,
            String data, BigInteger value) {

        BigInteger nonce = null;
		try {
			nonce = getNonce();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
        BigInteger blockLimit = new BigInteger("1000");

        BigInteger type = new BigInteger("1");
        RawTransaction rawTransaction = RawTransaction.createTransaction(
                nonce,
                gasPrice,
                gasLimit,
                blockLimit,
                to,
                value,
                data,
                type,
                true);

        try {
			return signAndSend(rawTransaction);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
*/
    
    public EthSendTransaction signAndSend(RawTransaction rawTransaction)
            throws ExecutionException, InterruptedException {

        byte[] signedMessage;

        //retrieve the blockNumber
        Request<?,EthBlockNumber> blockNumber = web3j.ethBlockNumber();
        EthBlockNumber blockNumber2 = new EthBlockNumber();
        BigInteger blockLimited = null;
        try {
			blockNumber2 = blockNumber.send();
			blockLimited = blockNumber2.getBlockNumber();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        blockLimited = blockLimited.add(new BigInteger("100", 10));
        juTransactionEncoder.setBlockLimited(blockLimited);
        if (chainId > ChainId.NONE) {
            signedMessage = juTransactionEncoder.signMessage(rawTransaction, chainId, credentials);
        } else {
            signedMessage = juTransactionEncoder.signMessage(rawTransaction, credentials);
        }

        String hexValue = Numeric.toHexString(signedMessage);

        return web3j.ethSendRawTransaction(hexValue).sendAsync().get();
    }

    @Override
    public String getFromAddress() {
        return credentials.getAddress();
    }

	@Override
	public EthSendTransaction sendTransaction(BigInteger gasPrice, BigInteger gasLimit, String to,
            String data, BigInteger value, BigInteger type, boolean isInitByName) throws IOException {
		
		BigInteger nonce = null;
		try {
			nonce = getNonce();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
        BigInteger blockLimit = new BigInteger("1000");

        //BigInteger type = new BigInteger("1");
        RawTransaction rawTransaction = RawTransaction.createTransaction(
                nonce,
                gasPrice,
                gasLimit,
                blockLimit,
                to,
                value,
                data,
                type,
                isInitByName);

        try {
			return signAndSend(rawTransaction);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EthSendTransaction sendTransaction(BigInteger arg0, BigInteger arg1, String arg2, String arg3,
			BigInteger arg4, BigInteger arg5, boolean arg6, TransactionSucCallback arg7) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}

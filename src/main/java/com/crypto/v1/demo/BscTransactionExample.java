package com.crypto.v1.demo;


//import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;

public class BscTransactionExample {
    // BSC节点的RPC地址
    private static String nodeUrl = "https://rpc.ankr.com/bsc";

    private static  Web3j web3j = Web3j.build(new HttpService(nodeUrl));

    // 设定您的私钥和钱包地址
    private static String privateKey = "Your_Private_Key";
    private static String tokenContractAddress = "";
    private static String accountAddress = "";

    public static void main(String[] args) {
//        Credentials credentials = Credentials.create(privateKey); // 将 "YOUR_PRIVATE_KEY" 替换为你的钱包私钥
//        ECKeyPair keyPair = credentials.getEcKeyPair();
    }

    private void transaction(ECKeyPair keyPair){

    }
}

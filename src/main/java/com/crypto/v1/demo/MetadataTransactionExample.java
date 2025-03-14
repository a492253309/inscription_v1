package com.crypto.v1.demo;

import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;

public class MetadataTransactionExample {


    // BSC节点的RPC地址
//    private static String nodeUrl = "https://go.getblock.io/82ff1012ec8f43fc887331eb129a614b";
//    private static String nodeUrl = "https://bscrpc.com";
//    private static String nodeUrl = "https://rpc.ankr.com/bsc";


    private static String nodeUrl = "https://data-seed-prebsc-1-s1.bnbchain.org:8545";


    private static Web3j web3j = Web3j.build(new HttpService(nodeUrl));

    // 设定您的私钥和钱包地址
    private static String privateKey = "";
    private static String tokenContractAddress = "";
    private static String accountAddress = "";
    private static String toAddress = "";

    private static String ID = "getblock.io";


    public static void main(String[] args) throws IOException {


        // 设置自定义数据
        String data = "Your custom data";
        // 十六进制数据（示例）
        String hexData = "0123456789ABCDEF";

        // 将十六进制数据转换为字节数组
        byte[] inputData = Numeric.hexStringToByteArray(hexData);

        // 将字节数组转换为十六进制字符串
        String hexInputData = Numeric.toHexString(inputData);

        // 设置发送交易的账户凭据
        Credentials credentials = Credentials.create(privateKey);

        // 创建交易管理器
        TransactionManager transactionManager = new RawTransactionManager(web3j, credentials);

        // 构建函数对象
        Function function = new Function(
                "setData",
                Collections.singletonList(new Utf8String(data)),
                Collections.emptyList()
        );

//        // 创建交易对象
//        String encodedFunction = FunctionEncoder.encode(function);
//        Transaction transaction = Transaction.createEtherTransaction(
//                accountAddress,
//                null,
//                BigInteger.valueOf(3),
//                BigInteger.valueOf(20),
//                accountAddress,
//                BigInteger.ZERO
//        );
        // 获取发送方地址的 nonce 值
        BigInteger nonce = web3j.ethGetTransactionCount(
                accountAddress,
                DefaultBlockParameterName.LATEST).send().getTransactionCount();

        System.out.println("nonce: " + nonce);

        String contractData = "0x646174613a2c7b2270223a226273632d3230222c226f70223a226d696e74222c227469636b223a2262736369222c22616d74223a2231303030227d";

        //        RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
//                nonce, BigInteger.valueOf(1748271872),
//                BigInteger.valueOf(21000), accountAddress,
//                BigInteger.ZERO);
        for (int i =0;i<10;i++) {
            RawTransaction rawTransaction = RawTransaction.createTransaction(
                    nonce, BigInteger.valueOf(1748271872),
                    BigInteger.valueOf(24874), accountAddress,
                    contractData);
            byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, 97, credentials);
//        Sign.SignatureData signatureData = TransactionEncoder.extractSignature(signedMessage);


            EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(
                    Numeric.toHexString(signedMessage)).send();
            String transactionHash = ethSendTransaction.getTransactionHash();
            System.out.println("Transaction sent successfully. Transaction hash: " + transactionHash);
            nonce = nonce.add(BigInteger.valueOf(1));



        }



//        String transactionHash = web3j.ethSendRawTransaction(
//                Numeric.toHexString(signedMessage)).getParams().toString();
//        System.out.println("Transaction sent successfully. Transaction hash: " + transactionHash);
//        System.out.println( credentials.getAddress());

    }

    String getAddress(String privateKey){
        ECKeyPair keyPair = ECKeyPair.create(Numeric.toBigInt(privateKey));
        Credentials credentials = Credentials.create(keyPair);

        String address = credentials.getAddress();
        return address;

    }
}

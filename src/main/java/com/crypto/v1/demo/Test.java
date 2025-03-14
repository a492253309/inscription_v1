package com.crypto.v1.demo;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crypto.v1.enums.AnkrNode;
import com.crypto.v1.enums.GetBlockNode;
import com.crypto.v1.enums.TestNode;
import com.crypto.v1.service.EvmScriberService;
import com.crypto.v1.service.Web3Service;
import com.crypto.v1.utils.Web3Until;
import okhttp3.*;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
//    private static String nodeUrl = "https://data-seed-prebsc-1-s1.bnbchain.org:8545";
//
//    private static String tokenContractAddress = " ";
//    private static String accountAddress = " ";
//
//
//    // 设定您的私钥和钱包地址
//    private static String privateKey = " ";
    private static String f70privateKey = " ";
//
//
//    private static Web3j web3j = Web3j.build(new HttpService(nodeUrl));


//    public static void main(String[] args) throws IOException {
//        String string = Web3Until.hexToString("0xd9b3d6d0");
//        System.out.println(""+string);
//        String contractAddress = "0x123..."; // 替换为你所使用的合约地址
//        String contractABI = "[{\"constant\":false, \"inputs\":[{\"name\":\"_param1\",\"type\":\"address\"}, {\"name\":\"_param2\",\"type\":\"uint256\"}], \"name\":\"yourContractMethod\",\"outputs\":[], \"payable\":false, \"stateMutability\":\"nonpayable\", \"type\":\"function\"}]"; // 替换为你所使用的合约ABI
//
//}
    public static void main(String[] args) throws IOException {
        String contractData = "0x646174613a2c7b2270223a226173632d3230222c226f70223a226d696e74222c227469636b223a2253545243222c22616d74223a2231227d";


//        String nodeUrl = "https://oktc-mainnet.public.blastapi.io";
//        String nodeUrl = "https://go.getblock.io/515e23058ec84919a899bca2f159d3f5";
//        String nodeUrl = "https://rpc.ankr.com/arbitrum";
        String nodeUrl = AnkrNode.AVAX.getUrl();
//        String nodeUrl ="https://avalanche.blockpi.network/v1/rpc/public";

//        String nodeUrl = GetBlockNode.AVAX.getUrl();

//        String nodeUrl = "https://go.getblock.io/9f20d28e7d0b4bc6a99ffd0099cb912b/mainnet";
//        String nodeUrl = "https://mainnet.helius-rpc.com/?api-key=55bf84b3-47c5-40aa-bc41-ff683addc106";
        // 创建自定义的 OkHttpClient 对象
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(60, TimeUnit.SECONDS) // 设置连接超时时间为60秒
//                .readTimeout(60, TimeUnit.SECONDS) // 设置读取超时时间为60秒
//                .build();
//        Web3j web3j = Web3j.build(new HttpService(nodeUrl,okHttpClient));
//
//        // 定义要查询签名的地址
//        String address = "FH5BodivMFR3RQPdtJwaXGiqUynkDm4F4VHZ3XP2pyAd";

//        URL url = new URL(nodeUrl);
//// 创建 HttpURLConnection
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setDoOutput(true);
//
//        // 构建请求体
//        String requestBody = "{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"getSignaturesForAddress\",\"params\":[\"FH5BodivMFR3RQPdtJwaXGiqUynkDm4F4VHZ3XP2pyAd\",{\"limit\":3}]}";
//
//        // 发送请求
//        OutputStream outputStream = connection.getOutputStream();
//        outputStream.write(requestBody.getBytes());
//        outputStream.flush();
//
//        // 获取响应
//        int responseCode = connection.getResponseCode();
//        BufferedReader reader;
//        if (responseCode >= 200 && responseCode < 300) {
//            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        } else {
//            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//        }
//        String line;
//        StringBuilder response = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            response.append(line);
//        }
//        reader.close();
//
//        // 打印响应
//        System.out.println(response.toString());
//
//        // 关闭连接
//        connection.disconnect();


//        String nodeUrl =  "ava-mainnet.public.blastapi.io/ext/bc/C/rpc";

//        // 获取发送方地址的 nonce 值
//        final BigInteger[] nonce = {Web3Until.getNonce(web3j, "0x740f60dB5168e9Fd44B1bC0A75101A6Ca90a2F70")};
//        System.out.println("nonce: " + nonce[0]);
        EvmScriberService service = new EvmScriberService();
        service.batchScriber(nodeUrl, contractData, f70privateKey, "-1");
//        service.batchScriber(nodeUrl, dino, f70privateKey, "-1");


//        service.batchScriber(nodeUrl,vim,privateKey,"-1");

//        Web3Service service = new Web3Service();
//        // 设置发送交易的账户凭据
//        Credentials credentials = Credentials.create(privateKey);
        // 获取发送方地址
//        String accountAddress = credentials.getAddress();
//        service.getAccountBalance(web3j,accountAddress,tokenContractAddress);

        // 获取发送方地址的 nonce 值
//        BigInteger nonce = Web3Until.getNonce(web3j,"0x740f60dB5168e9Fd44B1bC0A75101A6Ca90a2F70");
//        System.out.println("nonce: " + nonce);


//        System.out.println(Web3Until.getTransaction(web3j,"0x65c20e1bd91ce3bdafe9cc52fdb217876488070461ad9e7d9dea0977f03ef56a"));

    }




}

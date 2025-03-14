package com.crypto.v1.dto;

import lombok.Data;

import java.util.List;

@Data
public class LandDTO {


    /**
     * harvest_at
     */
    private String rpcNode;

    /**
     * harvest_at
     */
    private Integer chainId;

    /**
     * \n
     */
    private String privateKey;
    /**
     * harvest_at
     */
    private String toAddress;


    /**
     * harvest_at
     */
    private Integer amount;


    /**
     * harvest_at
     */
    private Integer gasType;


    /**
     * harvest_at
     */
    private String gasPrice;


    /**
     * harvest_at
     */
    private String gasRate;
    /**
     * harvest_at
     */
    private String gasLimit;

    /**
     * harvest_at
     */
    private Integer inputType;
    /**
     * harvest_at
     */
    private String inputData;


    /**
     * harvest_at
     */
    private Integer taskNum;

    /**
     * harvest_at
     */
    private Integer sleepTime;
}

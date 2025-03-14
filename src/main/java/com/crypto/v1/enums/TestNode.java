package com.crypto.v1.enums;

public enum TestNode {

    BSC("https://data-seed-prebsc-1-s1.bnbchain.org:8545");


    private String url;

    TestNode( String url) {
        this.url = url;
    }


    public String getUrl() {
        return url;
    }
}

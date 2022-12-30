package com.daelim.icc.vctserver.constdata;


public enum CoinList {
    WCU("백다다기오이"),
    PTT("감자"),
    ONI("양파"),
    CBB("배추"),
    CORN("옥수수"),
    GPP("풋고추"),
    CRR("당근"),
    GONI("대파"),
    SQS("조선 애호박"),
    TMT("토마토");

    private String name;

    CoinList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

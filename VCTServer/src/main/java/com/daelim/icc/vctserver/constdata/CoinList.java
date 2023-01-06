package com.daelim.icc.vctserver.constdata;


import lombok.Getter;
import lombok.Setter;

public enum CoinList {
    WCU("백다다기오이"),
    PTT("감자"),
    ONI("양파"),
    CBB("배추"),
    GPP("풋고추(일반)"),
    CRR("당근"),
    SCA("대파(일반)"),
    TMT("토마토");

    private String name;
    private double initRate;

    CoinList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getInitRate() {
        return initRate;
    }

    public void setInitRate(double initRate) {
        this.initRate = initRate;
    }
}

package com.daelimicc.server.vct.mg.chart.dto;

import lombok.Data;

import java.util.List;

@Data
public class RealTimeChartDTO {
    private String coinName;
    private float currentCoinPrice;
    private List<Float> preCoinList;
}

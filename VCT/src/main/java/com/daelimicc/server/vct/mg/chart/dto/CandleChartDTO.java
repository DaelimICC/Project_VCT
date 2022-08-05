package com.daelimicc.server.vct.mg.chart.dto;

import lombok.Data;

@Data
public class CandleChartDTO {

    private String coinName;
    private float coinPrice;
    private float open;
    private float high;
    private float low;
    private float close;
    private float volume;
    private float rate;
}

package com.daelimicc.server.vct.mg.chart.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RealTimeChart {
    private String coinName;
    private float currentCoinPrice;
    private List<Float> preCoinList;
}

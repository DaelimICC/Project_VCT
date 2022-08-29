package com.daelimicc.server.vct.mg.chart.dto;

import com.daelimicc.server.vct.mg.chart.domain.CandleChart;
import com.daelimicc.server.vct.mg.common.utility.CoinGenerateUtil;
import lombok.Data;

@Data
public class CandleChartDTO {

    private String coinName;
    private float coinPrice;
    private float volume;
    private float rate;

    public CandleChart toEntity() {
        CandleChart candleChart = new CandleChart();
        CoinGenerateUtil util = new CoinGenerateUtil();

        float exPrice = util.getExDatePrice(coinName);

        candleChart.setCoinName(coinName);
        candleChart.setCoinPrice(coinPrice);
        candleChart.setVolume(volume);

        candleChart.setRate((exPrice / coinPrice) * 100);

        return candleChart;
    }
}

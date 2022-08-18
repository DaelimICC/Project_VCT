package com.daelimicc.server.vct.mg.common.utility;

import com.daelimicc.server.vct.coin.domain.CoinHistory;
import com.daelimicc.server.vct.coin.repository.CoinHistoryRepository;
import com.daelimicc.server.vct.mg.chart.repository.CandleChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinGenerateUtil {

    @Autowired
    private CoinHistoryRepository coinHistoryRepository;

    @Autowired
    private CandleChartRepository candleChartRepository;

    public float getExDatePrice(String coinName) {
        CoinHistory ex = coinHistoryRepository.findTop1ByCoinNameOrderByCrtDttmDesc(coinName);
        return ex.getCoinPrice();
    }

//    public float openPrice(String coinName) {
//        // TODO: 오픈 가격을 가져오는 로직을 추가해야함.
//        return 0;
//    }
//
//    public float closePrice(String coinName) {
//        // TODO : 종가 가격을 가져오는 로직 추가
//        return 0;
//    }

}

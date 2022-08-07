package com.daelimicc.server.vct.mg.common.utility;

import com.daelimicc.server.vct.coin.domain.CoinHistory;
import com.daelimicc.server.vct.coin.repository.CoinHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinGenerateUtil {

    @Autowired
    private CoinHistoryRepository coinHistoryRepository;

    public float getExDatePrice(String coinName) {
        CoinHistory ex = coinHistoryRepository.findTop1ByCoinNameOrderByCrtDttmDesc(coinName);
        return ex.getCoinPrice();
    }

}

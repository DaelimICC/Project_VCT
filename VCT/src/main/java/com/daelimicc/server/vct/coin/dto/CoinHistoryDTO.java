package com.daelimicc.server.vct.coin.dto;

import com.daelimicc.server.vct.coin.domain.CoinHistory;
import lombok.Data;

@Data
public class CoinHistoryDTO {
    private String coinName;
    private float coinPrice;
    private String crtDttm;

    public CoinHistory onEntity() {
        CoinHistory coinHistory = new CoinHistory();
        coinHistory.setCoinName(coinName);
        coinHistory.setCoinPrice(coinPrice);
        coinHistory.setCrtDttm(crtDttm);
        return coinHistory;
    }
}

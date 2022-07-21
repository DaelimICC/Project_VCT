package com.daelimicc.server.vct.coin.dto;

import com.daelimicc.server.vct.coin.domain.CoinHistory;
import com.daelimicc.server.vct.mg.common.utility.DateTimeMethod;
import lombok.Data;

@Data
public class CoinHistoryDTO {
    private String coinName;
    private float coinPrice;

    public CoinHistory onEntity() {
        CoinHistory coinHistory = new CoinHistory();
        coinHistory.setCoinName(coinName);
        coinHistory.setCoinPrice(coinPrice);
        coinHistory.setCrtDttm(DateTimeMethod.getCurrentDateTimeBySting());
        return coinHistory;
    }
}

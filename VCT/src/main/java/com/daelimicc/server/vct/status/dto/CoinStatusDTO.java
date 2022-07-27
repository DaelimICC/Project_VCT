package com.daelimicc.server.vct.status.dto;

import com.daelimicc.server.vct.coin.domain.Coin;
import com.daelimicc.server.vct.coin.repository.CoinRepository;
import com.daelimicc.server.vct.status.domain.CoinStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class CoinStatusDTO {
    private String coinId;
    private String coinName;
    private String coinCurrPrice;
    private String coinPrevPrice;
    private String coinRate;

    public CoinStatus toEntity() {
        CoinStatus coinStatus = new CoinStatus();
        coinStatus.setCoinId(coinId);
        coinStatus.setCoinName(coinName);
        coinStatus.setCoinCurrPrice(coinCurrPrice);
        coinStatus.setCoinPrevPrice(coinPrevPrice);
        coinStatus.setCoinRate(coinRate);
        return coinStatus;
    }

}

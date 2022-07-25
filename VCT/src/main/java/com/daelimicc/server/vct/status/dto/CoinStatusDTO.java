package com.daelimicc.server.vct.status.dto;

import com.daelimicc.server.vct.status.domain.CoinStatus;
import lombok.Data;

@Data
public class CoinStatusDTO {
    private String coinId;
    private String coinName;
    private String coinCurrPrice;
    private String coinPrevPrice;
    private String coinRate;

    public CoinStatus toEntity() {
        return CoinStatus.builder()
                .coinId(coinId)
                .coinName(coinName)
                .coinCurrPrice(coinCurrPrice)
                .coinPrevPrice(coinPrevPrice)
                .coinRate(coinRate)
                .build();
    }

}

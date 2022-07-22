package com.daelimicc.server.vct.coin.dto;

import com.daelimicc.server.vct.coin.domain.Coin;
import lombok.Data;

import java.util.UUID;

@Data
public class CoinDTO {
    private String coinName;
    private float coinPrice;
    private float coinVolume;

    public Coin toEntity() {
        Coin coin = new Coin();
        coin.set_id(UUID.randomUUID().toString());
        coin.setCoinName(coinName);
        coin.setCoinPrice(coinPrice);
        coin.setCoinVolume(coinVolume);
        return coin;
    }

}

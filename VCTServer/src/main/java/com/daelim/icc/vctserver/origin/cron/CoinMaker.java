package com.daelim.icc.vctserver.origin.cron;

import com.daelim.icc.vctserver.coin.entity.Coin;
import com.daelim.icc.vctserver.coin.repository.CoinRepository;
import com.daelim.icc.vctserver.constdata.CoinList;
import com.daelim.icc.vctserver.constdata.DateFormatter;
import com.daelim.icc.vctserver.origin.response.Vegetable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class CoinMaker {
    private final CoinRepository repository;
    private final DateFormatter formatter;

    @Transactional
    public void convertAndSaveVegetableToCoinData(CoinList coin, Vegetable vegetable){
        repository.save(convertVegetableToCoin(coin, vegetable));
    }

    private Coin convertVegetableToCoin(CoinList coin, Vegetable vegetable){
        Double rate = Math.abs(vegetable.fluctuationRate - 100) * -1;
        coin.setInitRate(rate);

        return Coin.builder()
                .id(coin)
                .name(coin.getName())
                .price(vegetable.avgPrice)
                .unit(vegetable.tradeUnitQuantity.trim())
                .crtDttm(formatter.format(new Date()))
                .rate(rate)
                .incrementValue((int)(vegetable.avgPrice - vegetable.preAvgPrice))
                .initPrice(vegetable.avgPrice)
                .build();
    }
}

package com.daelim.icc.vctserver.coin.service;

import com.daelim.icc.vctserver.coin.entity.Coin;
import com.daelim.icc.vctserver.coin.repository.CoinRepository;
import com.daelim.icc.vctserver.constdata.CoinList;
import com.daelim.icc.vctserver.constdata.DateFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CoinService {
    private final CoinRepository coinRepository;
    private final DateFormatter formatter;
    private Random random;

    @PostConstruct
    private void init(){
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    @Transactional
    @Scheduled(cron = "0 0 */12 * * *")
    public void updatePriceCoin(){
        for (CoinList coin: CoinList.values()){
            updatePrice(coin);
        }
    }

    private void updatePrice(CoinList coinList){
        Coin coin = coinRepository.findById(coinList)
                .orElseThrow(() -> new NoSuchElementException(coinList.getName()  + "NOT FOUND"));

        coin.updatePriceAndRate(getFluctuationRate(coinList.getInitRate()));
        coin.setCrtDttm(formatter.format(new Date()));

        coinRepository.save(coin);
    }

    private Double getFluctuationRate(double rate){
        double rangeMax = Math.abs(rate);
        double rangeMin = rangeMax * -1;

        return (rangeMin + (rangeMax - rangeMin) * random.nextDouble()) / 100;
    }

    public String getCoinData(){
        return coinRepository.findAll().toString();
    }
}

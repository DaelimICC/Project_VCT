package com.daelim.icc.vctserver;

import com.daelim.icc.vctserver.coin.service.CoinService;
import com.daelim.icc.vctserver.origin.cron.OriginCronJob;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;

public class CoinTest extends BasicTestClass{
    @Autowired
    OriginCronJob originCronJob;

    @Autowired
    CoinService coinService;

    @Test
    @Order(1)
    public void makeCoin() throws JAXBException {
        originCronJob.cronUpdateOriginDate();

    }

    @Test
    @Order(2)
    public void getCoinData(){
        System.out.println(coinService.getCoinData());
    }

    @Test
    @Order(3)
    public void updateCoin(){
        for (int i = 0; i < 10; i++){
            coinService.updatePriceCoin();
        }
    }

    @Test
    @Order(4)
    public void checkCoin(){
        System.out.println(coinService.getCoinData());
    }
}

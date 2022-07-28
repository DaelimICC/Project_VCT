package com.daelimicc.server.vct.mg.common.utility;

import com.daelimicc.server.vct.coin.repository.CoinHistoryRepository;
import com.daelimicc.server.vct.coin.repository.CoinRepository;
import com.daelimicc.server.vct.coin.repository.RealPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
public class CoinGenerator {
    private CoinRepository coinRepository;
    private CoinHistoryRepository coinHistoryRepository;
    private RealPriceRepository realPriceRepository;

    // 5분 간격 코인 간격 대량 증감 (의도한 코인)
    // @Scheduled(cron = "0 0/5 * * * *")
    public void GenerateMainCoin() {
        coinRepository.findAll().forEach(coin -> {

        });
    }


    // 2초마다 코인 가격 소량 증감 (캔들 차트 구현을 위한 코인)
    // @Scheduled(cron = "0/10 * * * * *")
    public void SemiIntervalCoin() {

    }
}

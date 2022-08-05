package com.daelimicc.server.vct.mg.common.utility;

import com.daelimicc.server.vct.coin.domain.Coin;
import com.daelimicc.server.vct.coin.dto.CoinDTO;
import com.daelimicc.server.vct.coin.dto.CoinHistoryDTO;
import com.daelimicc.server.vct.coin.repository.CoinHistoryRepository;
import com.daelimicc.server.vct.coin.repository.CoinRepository;
import com.daelimicc.server.vct.coin.repository.RealPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class CoinGenerator {
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private CoinHistoryRepository coinHistoryRepository;
    @Autowired
    private RealPriceRepository realPriceRepository;

    // 5분 간격 코인 간격 대량 증감 (의도한 코인)
    @Scheduled(cron = "0 0/5 * * * *")
    public void GenerateMainCoin() {
        coinRepository.findAll().forEach(coin -> {
            CoinDTO coinDTO = new CoinDTO();
            coinDTO.setCoinName(coin.getCoinName());
            coinDTO.setCoinPrice(coin.getCoinPrice());
            coinDTO.setCoinVolume(coin.getCoinVolume());
            coinRepository.deleteByCoinName(coin.getCoinName());
            coinRepository.save(coinDTO.toEntity());

            CoinHistoryDTO coinHistoryDTO = new CoinHistoryDTO();
            coinHistoryDTO.setCoinName(coinDTO.getCoinName());
            coinHistoryDTO.setCoinPrice(coinDTO.getCoinPrice());
            coinHistoryRepository.save(coinHistoryDTO.onEntity());
        });
    }

    // @Scheduled(cron = "15 06 * * * *")
    public void SetInitPrice() {

    }
}

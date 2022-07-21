package com.daelimicc.server.vct.coin.controller;

import com.daelimicc.server.vct.coin.dto.CoinHistoryDTO;
import com.daelimicc.server.vct.coin.repository.CoinHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coin/hist")
@RequiredArgsConstructor
public class CoinHistoryController {

    private final CoinHistoryRepository coinHistoryRepository;

    @PostMapping("")
    public void recordCoinHistory(@RequestBody CoinHistoryDTO coinHistoryDTO) {
        coinHistoryRepository.save(coinHistoryDTO.onEntity());
    }
}

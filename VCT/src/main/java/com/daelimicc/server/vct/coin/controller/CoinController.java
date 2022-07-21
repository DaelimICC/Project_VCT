package com.daelimicc.server.vct.coin.controller;

import com.daelimicc.server.vct.coin.domain.Coin;
import com.daelimicc.server.vct.coin.dto.CoinDTO;
import com.daelimicc.server.vct.coin.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/coin")
@RequiredArgsConstructor
public class CoinController {

    private final CoinRepository coinRepository;

    /**
     * 코인 정보 불러오기
     * @return
     */
    @GetMapping("/all")
    public List<Coin> getCoinList() {
        return coinRepository.findAll();
    }

    @GetMapping("")
    public Coin getCoin(@RequestParam(value="cn") String coinName) {
        return coinRepository.findByCoinName(coinName);
    }

    // 임시 사용
    @PostMapping("")
    public Coin recordCoin(@RequestBody CoinDTO coinDTO) {

        return coinRepository.save(coinDTO.toEntity());
    }
}

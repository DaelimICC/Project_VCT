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
     * 모든 코인 정보 불러오기
     * @return
     */
    @GetMapping("/all")
    public List<Coin> getCoinList() {
        return coinRepository.findAll();
    }

    /**
     * 특정 코인 정보 불러오기
     * @param coinName
     * @return
     */
    @GetMapping("")
    public Coin getCoin(@RequestParam(value="cn") String coinName) {
        return coinRepository.findByCoinName(coinName);
    }

    @PutMapping("")
    public void updateCoin(@RequestBody CoinDTO coinDTO, @RequestParam(value="cn") String coinId) {
        Coin coin = coinDTO.toEntity();
        coin.set_id(coinId);
        coinRepository.save(coin);
    }
}

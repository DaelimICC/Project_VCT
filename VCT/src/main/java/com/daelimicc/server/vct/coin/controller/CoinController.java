package com.daelimicc.server.vct.coin.controller;

import com.daelimicc.server.vct.coin.domain.Coin;
import com.daelimicc.server.vct.coin.dto.CoinDTO;
import com.daelimicc.server.vct.coin.repository.CoinRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/coin")
@RequiredArgsConstructor
@Api(tags = "상장 코인 정보 API")
public class CoinController {

    private final CoinRepository coinRepository;

    /**
     * 모든 코인 정보 불러오기
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "모든 코인 정보 조회")
    public List<Coin> getCoinList() {
        return coinRepository.findAll();
    }

    /**
     * 특정 코인 정보 불러오기
     * @param coinName
     * @return
     */
    @GetMapping("")
    @ApiOperation(value = "특정 코인 데이터 조회")
    public Coin getCoin(@RequestParam(value="cn") String coinName) {
        return coinRepository.findByCoinName(coinName);
    }

    /**
     * 코인 정보 수정
     * @param coinDTO
     * @param coinId
     */
    @PutMapping("")
    @ApiOperation(value = "코인 데이터 변동 조회")
    public void updateCoin(@RequestBody CoinDTO coinDTO, @RequestParam(value="cn") String coinId) {
        Coin coin = coinDTO.toEntity();
        coin.set_id(coinId);
        coinRepository.save(coin);
    }
}

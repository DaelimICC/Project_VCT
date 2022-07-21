package com.daelimicc.server.vct.coin.controller;

import com.daelimicc.server.vct.coin.domain.CoinHistory;
import com.daelimicc.server.vct.coin.dto.CoinHistoryDTO;
import com.daelimicc.server.vct.coin.repository.CoinHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coin/hist")
@RequiredArgsConstructor
public class CoinHistoryController {

    private final CoinHistoryRepository coinHistoryRepository;

    // 임시 메서드
    @PostMapping("")
    public void recordCoinHistory(@RequestBody CoinHistoryDTO coinHistoryDTO) {
        coinHistoryRepository.save(coinHistoryDTO.onEntity());
    }

    /**
     * 코인 이력 조회
     * @param coinName
     * @param crtDt
     * @return
     */
    @GetMapping("")
    public List<CoinHistory> getCoinHistory(@RequestParam(value = "cn", required = false) String coinName,
                                            @RequestParam(value = "crtDttm", required = false) String crtDt) {
        if(coinName == null && crtDt == null) {
            return coinHistoryRepository.findAll();
        } else if(coinName != null && crtDt == null) {
            return coinHistoryRepository.findByCoinName(coinName);
        } else if(coinName == null && crtDt != null) {
            return coinHistoryRepository.findByCrtDttmLike(crtDt);
        } else {
            return coinHistoryRepository.findByCoinNameAndCrtDttmLike(coinName, crtDt);
        }
    }
}

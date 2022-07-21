package com.daelimicc.server.vct.trade.controller;

import com.daelimicc.server.vct.trade.domain.TradeHistory;
import com.daelimicc.server.vct.trade.dto.TradeHistoryDTO;
import com.daelimicc.server.vct.trade.repository.TradeHistoryRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trade")
@RequiredArgsConstructor
public class TradeController {
    // DI Repository
    private final TradeHistoryRepository tradeHistoryRepository;

    /**
     * Trade History 저장
     * @param tradeHistoryDTO
     * @return
     */
    @ApiOperation(value = "Trade History 저장")
    @PostMapping("")
    public TradeHistory recordTradeHistory(@RequestBody TradeHistoryDTO tradeHistoryDTO) {
        return tradeHistoryRepository.save(tradeHistoryDTO.toEntity());
    }

    /**
     * Trade History 조회
     * @param userId
     * @param coinName
     * @return
     */
    @ApiOperation(value = "Trade History 조회")
    @GetMapping("")
    public List<TradeHistory> getTradeHistoryByUserAndCoin(@RequestParam(value = "id", required = false) String userId, @RequestParam(value = "cn", required = false) String coinName) {
        if(userId != null && coinName != null) {
            return tradeHistoryRepository.findByTradeUserIdAndTradeCoinName(userId, coinName);
        }

        if(userId != null) {
            return tradeHistoryRepository.findByTradeUserId(userId);
        } else if(coinName != null) {
            return tradeHistoryRepository.findByTradeCoinName(coinName);
        } else {
            return tradeHistoryRepository.findAll();
        }
    }

}

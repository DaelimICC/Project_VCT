package com.daelimicc.server.vct.trade.controller;

import com.daelimicc.server.vct.trade.domain.TradeHistory;
import com.daelimicc.server.vct.trade.dto.TradeHistoryDTO;
import com.daelimicc.server.vct.trade.repository.TradeHistoryRepository;
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
    @PostMapping("")
    public TradeHistory recordTradeHistory(@RequestBody TradeHistoryDTO tradeHistoryDTO) {
        return tradeHistoryRepository.save(tradeHistoryDTO.toEntity());
    }

    @GetMapping("")
    public List<TradeHistory> getTradeHistoryByUser(@RequestParam String userId) {
        return tradeHistoryRepository.findByTradeUserId(userId);
    }
}

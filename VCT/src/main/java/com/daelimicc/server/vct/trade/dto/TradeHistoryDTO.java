package com.daelimicc.server.vct.trade.dto;

import com.daelimicc.server.vct.trade.domain.TradeHistory;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
public class TradeHistoryDTO {
    private String tradeUserId;
    private float tradePrice;
    private float tradeVolume;
    private String tradeCoinName;

    public TradeHistory toEntity() {
        TradeHistory tradeHistory = new TradeHistory();

        tradeHistory.set_id(UUID.randomUUID().toString());
        tradeHistory.setTradeUserId(this.tradeUserId);
        tradeHistory.setTradePrice(this.tradePrice);
        tradeHistory.setTradeVolume(this.tradeVolume);
        tradeHistory.setTradeCoinName(this.tradeCoinName);

        LocalDateTime now = LocalDateTime.now();
        String convertedDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss"));

        tradeHistory.setTradeCreatedAt(convertedDate);
        return tradeHistory;
    }
}

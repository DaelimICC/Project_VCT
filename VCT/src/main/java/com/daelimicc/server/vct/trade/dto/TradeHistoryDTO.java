package com.daelimicc.server.vct.trade.dto;

import com.daelimicc.server.vct.trade.domain.TradeHistory;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.daelimicc.server.vct.mg.common.utility.DateTimeMethod;

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

        tradeHistory.setTradeCreatedAt(DateTimeMethod.getCurrentDateTimeBySting());
        return tradeHistory;
    }
}

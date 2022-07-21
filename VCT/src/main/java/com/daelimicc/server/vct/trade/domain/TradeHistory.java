package com.daelimicc.server.vct.trade.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "vct_trade_history")
@Data
public class TradeHistory {
    @Id
    private String _id;
    private String tradeUserId;
    private float tradePrice;
    private float tradeVolume;
    private String tradeCoinName;
    private String tradeCreatedAt;
}

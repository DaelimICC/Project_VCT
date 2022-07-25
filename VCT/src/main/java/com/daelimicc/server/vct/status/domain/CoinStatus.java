package com.daelimicc.server.vct.status.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vct_coin_status")
@Data
@Builder
public class CoinStatus {
    private String _id;
    private String coinId;
    private String coinName;
    private String coinCurrPrice;
    private String coinPrevPrice;
    private String coinRate;
}

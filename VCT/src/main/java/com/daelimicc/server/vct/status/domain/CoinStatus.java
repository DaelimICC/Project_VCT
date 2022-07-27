package com.daelimicc.server.vct.status.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vct_coin_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoinStatus {
    @Id
    private String _id;
    private String coinId;
    private String coinName;
    private String coinCurrPrice;
    private String coinPrevPrice;
    private String coinRate;

    public String toString() {
        return "{" +
                "}";
    }
}

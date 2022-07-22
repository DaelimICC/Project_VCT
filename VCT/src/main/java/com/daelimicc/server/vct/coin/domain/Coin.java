package com.daelimicc.server.vct.coin.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vct_coin")
public class Coin {
    @Id
    private String _id;

    private String coinName;

    private float coinPrice;

    private float coinVolume;
}

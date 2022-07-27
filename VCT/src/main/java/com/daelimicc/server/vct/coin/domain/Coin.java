package com.daelimicc.server.vct.coin.domain;

import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "vct_coin")
public class Coin {
    @Id
    private String _id;

    private String coinName;

    private float coinPrice;

    private float coinVolume;

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

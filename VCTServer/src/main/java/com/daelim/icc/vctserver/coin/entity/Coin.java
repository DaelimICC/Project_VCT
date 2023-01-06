package com.daelim.icc.vctserver.coin.entity;

import com.daelim.icc.vctserver.constdata.CoinList;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.PostConstruct;

@Document("coin")
@Builder
@Data
public class Coin {
    @Id
    private CoinList id;
    private String name;
    private Double price;
    private String unit;
    private String crtDttm;
    private Double rate;
    private Integer incrementValue;
    private Double initPrice;

    public void updatePriceAndRate(Double fluctuationRate){
        this.price *= (1.0 + fluctuationRate); //복리
        this.rate = (price - initPrice) / initPrice * 100;
        this.incrementValue = (int)(initPrice - this.price) * -1;
    }

}

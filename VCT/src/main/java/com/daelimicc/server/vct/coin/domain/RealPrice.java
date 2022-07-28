package com.daelimicc.server.vct.coin.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "vegetablePrice")
public class RealPrice {
    @Id
    private String _id;
    private String vegetable_name;
    private String vegetable_price;
    private String vegetable_unit;
}

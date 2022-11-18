package com.daelimicc.server.vct.coin.dto;

import com.daelimicc.server.vct.coin.domain.RealPrice;
import lombok.Data;

@Data
public class RealPriceDTO {
    private String _id;
    private String vegetable_name;
    private String vegetable_price;
    private String vegetable_unit;

    public RealPrice toEntity() {
        return RealPrice.builder()
                ._id(this._id)
                .vegetable_name(this.vegetable_name)
                .vegetable_price(this.vegetable_price)
                .vegetable_unit(this.vegetable_unit)
                .build();
    }
}

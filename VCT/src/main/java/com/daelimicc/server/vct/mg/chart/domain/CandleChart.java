package com.daelimicc.server.vct.mg.chart.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vct_mg_chart")
public class CandleChart {
    @Id
    private String _id;
    private String coinName;
    private float coinPrice;
    private String crtDttm;

    private float open;
    private float high;
    private float low;
    private float close;
    private float volume;
    private float rate;
}

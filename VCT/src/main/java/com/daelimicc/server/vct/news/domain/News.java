package com.daelimicc.server.vct.news.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vct_news")
@Data
public class News {
    @Id
    private String _id;
    private String newsTitle;
    private String newsUrl;
    private String newsSummary;
    private String newsCrtDttm;

}

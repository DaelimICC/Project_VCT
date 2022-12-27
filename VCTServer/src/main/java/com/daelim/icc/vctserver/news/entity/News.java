package com.daelim.icc.vctserver.news.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document("news")
public class News {
    @Id
    private String newsId;
    private String newsTitle;
    private String newsLink;
    private String newsThumb;
    private Date newsDt;
}

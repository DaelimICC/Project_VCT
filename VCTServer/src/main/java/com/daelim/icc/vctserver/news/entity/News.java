package com.daelim.icc.vctserver.news.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

@Data
@Builder
@Document("news")
public class News {
    @Id
    private String id;
    private String title;
    private String link;
    private String thumb;
    private String dttm;
}

package com.daelimicc.server.vct.news.dto;

import com.daelimicc.server.vct.mg.common.utility.DateTimeMethod;
import com.daelimicc.server.vct.news.domain.News;
import lombok.Data;

import java.util.UUID;

@Data
public class NewsDTO {

    private String newsTitle;
    private String newsUrl;
    private String newsSummary;

    public News toEntity(){
        News news = new News();

        news.set_id(UUID.randomUUID().toString());
        news.setNewsTitle(this.newsTitle);
        news.setNewsUrl(this.newsUrl);
        news.setNewsSummary(this.newsSummary);

        news.setNewsCrtDttm(DateTimeMethod.getCurrentDateTimeBySting());
        return news;

    }
}

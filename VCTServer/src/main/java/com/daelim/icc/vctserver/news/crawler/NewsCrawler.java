package com.daelim.icc.vctserver.news.crawler;

import com.daelim.icc.vctserver.news.entity.News;
import lombok.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Component
public class NewsCrawler {
    @Value("${spring.jsoup.url}")
    private String siteDomain;

    @Value("${spring.jsoup.url}" + "${spring.news.url}")
    private String newsUrl;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public List<News> crawl() throws IOException {
        List<Element> newsCards = Jsoup.connect(newsUrl)
                .get().select("div[class=\"card_frame\"]")
                .stream().limit(5).toList();

        return newsCards.stream().map(this::makeNewsEntity).toList();
    }
    private News makeNewsEntity(Element newsCard){
        String title,link, thumbnail;
        Date dttm;

        link = newsCard.select("a").attr("href");
        thumbnail = newsCard.select("img").attr("src");
        title = newsCard.select("span[class=\"txt\"]").text();

        try {
            dttm = dateFormat.parse(newsCard.select("span[class=\"date\"]").text());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return News.builder()
                .newsId(UUID.randomUUID().toString())
                .newsTitle(title)
                .newsLink(siteDomain + link)
                .newsThumb(siteDomain + thumbnail)
                .newsDttm(dttm)
                .build();
    }
}

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Component
public class NewsCrawler {
    @Value("${spring.jsoup.url}")
    private String siteDomain;

    @Value("${spring.jsoup.url}" + "${spring.jsoup.news.url}")
    private String newsUrl;

    @Value("${spring.jsoup.url}" + "${spring.jsoup.thumbnail.url}")
    private String thumbnailUrl;


    public List<News> crawl() throws IOException {
        Stream<Element> newsCards = Jsoup.connect(newsUrl)
                .get().select("ul[class=\"common_list\"] a")
                .stream().limit(5);

        return newsCards.map(this::makeNewsEntity).toList();
    }
    private News makeNewsEntity(Element newsCard){
        String title,link, thumbnail, dttm;

        link = newsCard.select("a").attr("href");
        thumbnail = newsCard.select("div[class=\"img_wrap thumbnail_img\"]").attr("style")
                .replace("background-image:url(" + thumbnailUrl, "")
                .replace(")", "");
        title = newsCard.select("pre[class=\"tit\"]").text();
        dttm = newsCard.select("pre[class=\"data\"]").text();

        return News.builder()
                .id(UUID.randomUUID().toString())
                .title(title)
                .link(siteDomain + link)
                .thumb(thumbnailUrl + thumbnail)
                .dttm(dttm)
                .build();
    }
}
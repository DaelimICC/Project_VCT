package com.daelim.icc.vctserver.news.controller;

import com.daelim.icc.vctserver.news.crawler.NewsCrawler;
import com.daelim.icc.vctserver.news.entity.News;
import com.daelim.icc.vctserver.news.service.NewsDBService;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("news")
@RequiredArgsConstructor
@Slf4j
public class NewsController {
    private final NewsDBService dbService;
    private final NewsCrawler crawler;

    @GetMapping("")
    public List<News> getNews() throws IOException {
        log.info("getNewsData");
        return dbService.getAllNews();
    }

    @GetMapping("crawl")
    public List<News> getCrawl() throws IOException {
        return crawler.crawl();
    }

    @GetMapping("/makedata")
    public void makeData() throws IOException {
        log.info("insertNewsData");
        dbService.saveAllNews(crawler.crawl());
    }
}

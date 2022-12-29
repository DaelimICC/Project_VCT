package com.daelim.icc.vctserver.news.controller;

import com.daelim.icc.vctserver.news.crawler.NewsCrawler;
import com.daelim.icc.vctserver.news.entity.News;
import com.daelim.icc.vctserver.news.service.NewsDBService;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("")
    public ResponseEntity<String> getNews() {
        return dbService.getNewses();
    }

    @GetMapping("/update")
    public ResponseEntity<String> updateNews() throws IOException {
        return dbService.updateNews();
    }
}

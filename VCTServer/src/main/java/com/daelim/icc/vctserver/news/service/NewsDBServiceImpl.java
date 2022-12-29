package com.daelim.icc.vctserver.news.service;

import com.daelim.icc.vctserver.auth.jwt.dto.JsonMessage;
import com.daelim.icc.vctserver.constdata.ObjectMapping;
import com.daelim.icc.vctserver.news.crawler.NewsCrawler;
import com.daelim.icc.vctserver.news.entity.News;
import com.daelim.icc.vctserver.news.repository.NewsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsDBServiceImpl extends ObjectMapping implements NewsDBService {
    private final NewsRepository newsRepository;
    private final NewsCrawler crawler;

    @Override
    public ResponseEntity<String> getNewses(){
        try {
            List<News> newsList = newsRepository.findAll();

            httpStatus = HttpStatus.OK;
            msg = newsList;

        }catch (Exception e){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = e.getMessage();
        }finally {
            return makeResponse();
        }
    }

    @Override
    public ResponseEntity<String> updateNews() throws IOException {
            try {
                newsRepository.saveAll(crawler.crawl());

                return getNewses();
            } catch (IOException e) {
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                msg = e.getMessage();

                return makeResponse();
            }
    }
}

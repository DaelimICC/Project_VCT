package com.daelim.icc.vctserver.news.cron;

import com.daelim.icc.vctserver.news.crawler.NewsCrawler;
import com.daelim.icc.vctserver.news.service.NewsDBService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class NewsCron {
    private final NewsDBService service;

    @Scheduled(cron = "0 0 */12 * * *")
    public void cron(){
        try{
            service.updateNews();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

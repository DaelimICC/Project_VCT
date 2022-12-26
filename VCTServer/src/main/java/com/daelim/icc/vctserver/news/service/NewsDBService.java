package com.daelim.icc.vctserver.news.service;

import com.daelim.icc.vctserver.news.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewsDBService {
    List<News> getAllNews();

    void saveAllNews(Iterable<News> newses);
}

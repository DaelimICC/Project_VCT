package com.daelim.icc.vctserver.news.service;

import com.daelim.icc.vctserver.news.entity.News;
import com.daelim.icc.vctserver.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsDBServiceImpl implements NewsDBService {
    private final NewsRepository newsRepository;

    @Override
    public List<News> getAllNews(){
        return newsRepository.findAll();
    }

    @Override
    public void saveAllNews(Iterable<News> newses){
        newsRepository.saveAll(newses);
        log.info("뉴스 리스트 저장 완료");
    }
}

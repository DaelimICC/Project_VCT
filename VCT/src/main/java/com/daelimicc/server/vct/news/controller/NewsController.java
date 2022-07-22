package com.daelimicc.server.vct.news.controller;

import com.daelimicc.server.vct.news.domain.News;
import com.daelimicc.server.vct.news.dto.NewsDTO;
import com.daelimicc.server.vct.news.repository.NewsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@Api(tags = "뉴스 정보 API")
public class NewsController {
    private final NewsRepository newsRepository;

    /**
     * 모든 뉴스 정보 불러오기
     * @return
     */

    @ApiOperation(value = "뉴스 전체")
    @GetMapping("/all")
    public List<News> findNewsAll() {
        return newsRepository.findAll(Sort.by(Sort.Direction.DESC,"newsCrtDttm"));
    }

    /**
     * 최근 5개 뉴스 정보 불러오기
     * @return
     */
    @ApiOperation(value = "최근 뉴스")
    @GetMapping("")
    public List<News> findTop5News(){
        return newsRepository.findTop5ByOrderByNewsCrtDttmDesc();
    }
}

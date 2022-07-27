package com.daelimicc.server.vct.news.repository;

import com.daelimicc.server.vct.news.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NewsRepository extends MongoRepository<News, String> {
    List<News> findTop5ByOrderByNewsCrtDttmDesc();

}

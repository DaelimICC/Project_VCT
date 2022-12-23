package com.daelim.icc.vctserver.news.repository;

import com.daelim.icc.vctserver.news.entity.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface NewsRepository extends MongoRepository<News, String>{
}

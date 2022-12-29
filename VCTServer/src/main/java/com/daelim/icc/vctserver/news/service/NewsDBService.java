package com.daelim.icc.vctserver.news.service;

import com.daelim.icc.vctserver.news.entity.News;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface NewsDBService {
    ResponseEntity<String> getNewses();

    ResponseEntity<String> updateNews() throws IOException;
}

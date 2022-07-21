package com.daelimicc.server.vct.notice.repository;

import com.daelimicc.server.vct.notice.domain.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoticeRepository extends MongoRepository<Notice, String> {

}

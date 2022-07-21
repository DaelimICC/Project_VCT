package com.daelimicc.server.vct.notice.repository;

import com.daelimicc.server.vct.notice.domain.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoticeRepository extends MongoRepository<Notice, String> {

    List<Notice> findByNoticeTitle(String noticeTitle);

    List<Notice> findByNoticeTitleOrNoticeContents(String noticeTitle, String noticeContents);

    List<Notice> findByNoticeTitleAndNoticeCrtDttm(String noticeTitle, String noticeCrtDttm);
    List<Notice> deleteNoticeBy_id(String _id);


}

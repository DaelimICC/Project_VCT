package com.daelimicc.server.vct.notice.dto;

import com.daelimicc.server.vct.notice.domain.Notice;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
public class NoticeDTO {
    private String noticeTitle;
    private String noticeContents;

    public Notice toEntity(){
        Notice notice = new Notice();

        notice.set_id(UUID.randomUUID().toString());
        notice.setNoticeTitle(this.noticeTitle);
        notice.setNoticeContents(this.noticeContents);

        LocalDateTime now = LocalDateTime.now();
        String convertedDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss"));

        notice.setNoticeCrtDttm(convertedDate);
        return notice;

    }
}

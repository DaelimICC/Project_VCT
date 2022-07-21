package com.daelimicc.server.vct.notice.dto;

import com.daelimicc.server.vct.mg.common.utility.DateTimeMethod;
import com.daelimicc.server.vct.notice.domain.Notice;
import lombok.Data;

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

        notice.setNoticeCrtDttm(DateTimeMethod.getCurrentDateTimeBySting());
        return notice;

    }
}

package com.daelimicc.server.vct.notice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vct_notice")
@Data
public class Notice {

    @Id
    private String _id;
    private String noticeTitle;
    private String noticeContents;
    private String noticeCrtDttm;

}

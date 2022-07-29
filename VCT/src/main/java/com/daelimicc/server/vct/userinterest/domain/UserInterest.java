package com.daelimicc.server.vct.userinterest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vct_user_interest")
public class UserInterest {
    @Id
    private String _id;
    @Builder.Default
    private String WCU = "false"; //백다다가오이
    private Boolean PTT; //감자
    private Boolean ONI; //양파
    private Boolean CBB; //배추
    private Boolean CORN; //옥수수
    private Boolean GPP; //풋고추
    private Boolean GRR; //당근
    private Boolean GONI; //대파
    private Boolean SQS; //조선 애호박
    private Boolean TMT; //토마토

}

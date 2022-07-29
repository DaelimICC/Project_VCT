package com.daelimicc.server.vct.userinterest.dto;

import lombok.Data;
import com.daelimicc.server.vct.userinterest.domain.UserInterest;

@Data
public class UserInterestDTO {

    private String _id;
    private String WCU; //백다다가오이
    private Boolean PTT; //감자
    private Boolean ONI; //양파
    private Boolean CBB; //배추
    private Boolean CORN; //옥수수
    private Boolean GPP; //풋고추
    private Boolean GRR; //당근
    private Boolean GONI; //대파
    private Boolean SQS; //조선 애호박
    private Boolean TMT; //토마토

    public UserInterest toEntity() {
        return UserInterest.builder()
                ._id(this._id)
                .WCU("false")
                .PTT(this.PTT)
                .ONI(this.ONI)
                .CBB(this.CBB)
                .CORN(this.CORN)
                .GPP(this.GPP)
                .GRR(this.GRR)
                .GONI(this.GONI)
                .SQS(this.SQS)
                .TMT(this.TMT)
                .build();
    }
}

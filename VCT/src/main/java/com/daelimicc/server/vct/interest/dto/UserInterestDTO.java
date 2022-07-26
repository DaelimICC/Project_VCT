package com.daelimicc.server.vct.interest.dto;

import com.daelimicc.server.vct.interest.domain.UserInterest;
import lombok.Data;

@Data
public class UserInterestDTO {
    private String userId;
    private String interestCoinId;

    public UserInterest toEntity() {
        UserInterest userInterest = new UserInterest();

        userInterest.setUserId(userId);
        userInterest.setInterestCoinId(interestCoinId);
        return userInterest;
    }
}

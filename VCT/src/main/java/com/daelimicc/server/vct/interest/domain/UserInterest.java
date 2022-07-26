package com.daelimicc.server.vct.interest.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vct_user_interest")
public class UserInterest {
    private String _id;
    private String userId;
    private String interestCoinId;
}

package com.daelimicc.server.vct.user.domain;

import com.daelimicc.server.vct.userinterest.domain.UserInterest;
import com.daelimicc.server.vct.wallet.domain.Wallet;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "vct_user")
public class User {
    @Id
    private String _id;
    private String name;
    private String email;
    private String createdAt;
    private String updatedAt;
}

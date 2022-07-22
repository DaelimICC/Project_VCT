package com.daelimicc.server.vct.user.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

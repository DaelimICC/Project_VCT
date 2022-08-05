package com.daelimicc.server.vct.user.dto;

import com.daelimicc.server.vct.user.domain.User;
import com.daelimicc.server.vct.userinterest.domain.UserInterest;
import com.daelimicc.server.vct.wallet.domain.Wallet;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String _id;
    private String name;
    private String email;
    private String createdAt;
    private String updatedAt;

    public User toEntity() {
        User user = new User();
        user.set_id(_id);
        user.setName(name);
        user.setEmail(email);
        user.setCreatedAt(createdAt);
        user.setUpdatedAt(updatedAt);
        return user;
    }
}
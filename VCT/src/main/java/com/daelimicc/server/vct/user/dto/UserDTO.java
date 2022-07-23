package com.daelimicc.server.vct.user.dto;

import com.daelimicc.server.vct.user.domain.User;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String createdAt;
    private String updatedAt;

    public User toEntity() {
        User user = new User();
        user.set_id(UUID.randomUUID().toString());
        user.setName(name);
        user.setEmail(email);
        user.setCreatedAt(createdAt);
        user.setUpdatedAt(updatedAt);
        return user;
    }
}

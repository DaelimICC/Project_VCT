package com.daelim.icc.vctserver.auth.service;

import com.daelim.icc.vctserver.auth.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    ResponseEntity<String> userRegistration(UserDTO userdto);

    @Transactional
    ResponseEntity<String> login(String userId, String userPwd);

    ResponseEntity<String> deleteUser(String userId);
}

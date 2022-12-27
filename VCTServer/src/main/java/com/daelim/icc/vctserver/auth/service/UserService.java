package com.daelim.icc.vctserver.auth.service;

import com.daelim.icc.vctserver.auth.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserService {
    @Transactional
    ResponseEntity<String> userRegistration(UserDTO userdto) throws JsonProcessingException;

    @Transactional
    ResponseEntity<String> login(String userId, String userPwd);

    @Transactional
    ResponseEntity<String> deleteUser(String userId);
}

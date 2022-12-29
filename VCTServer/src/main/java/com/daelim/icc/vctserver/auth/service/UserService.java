package com.daelim.icc.vctserver.auth.service;

import com.daelim.icc.vctserver.auth.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserService {
    @Transactional
    ResponseEntity<String> registration(UserDTO userdto);

    @Transactional
    ResponseEntity<String> signup(String userId, String userPwd);

    @Transactional
    ResponseEntity<String> delete(String userId);
}

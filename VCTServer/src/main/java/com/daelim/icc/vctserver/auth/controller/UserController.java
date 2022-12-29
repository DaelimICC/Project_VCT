package com.daelim.icc.vctserver.auth.controller;

import com.daelim.icc.vctserver.auth.dto.UserDTO;
import com.daelim.icc.vctserver.auth.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("registration")
    public ResponseEntity<String> registration(@RequestBody @NotNull UserDTO userDTO){
        return service.registration(userDTO);
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestParam(value = "id") String userId,
                                         @RequestParam(value = "pwd") String userPwd){
        return service.signup(userId, userPwd);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestHeader(value = "targetId") String userId){
        return service.delete(userId);
    }
}


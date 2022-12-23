package com.daelim.icc.vctserver.auth.controller;

import com.daelim.icc.vctserver.auth.dto.UserDTO;
import com.daelim.icc.vctserver.auth.repository.UserRepository;
import com.daelim.icc.vctserver.auth.service.UserService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("registration")
    public ResponseEntity<String> registration(@RequestBody @NotNull UserDTO userDTO){
        return service.userRegistration(userDTO);
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestParam(value = "id") String userId,
                                         @RequestParam(value = "password") String userPwd){
        return service.login(userId, userPwd);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestParam(value = "id") String userId){
        return service.deleteUser(userId);
    }
}


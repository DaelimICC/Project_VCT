package com.daelim.icc.vctserver.auth.service;

import com.daelim.icc.vctserver.auth.dao.User;
import com.daelim.icc.vctserver.auth.dto.UserDTO;
import com.daelim.icc.vctserver.auth.jwt.provider.JwtProvider;
import com.daelim.icc.vctserver.auth.repository.UserRepository;
import com.daelim.icc.vctserver.auth.jwt.dto.JsonMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private AuthenticationManager authenticationManager;
    private final JwtProvider provider;
    private final PasswordEncoder encoder;
    private final ObjectMapper objectMapper;
    private HttpStatus httpStatus;
    private String msg;
    private Base64.Decoder decoder;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        authenticationManager = authenticationManagerBuilder.getObject();
        httpStatus = null;
        msg = null;
        decoder = Base64.getDecoder();
    }

    @Override
    public ResponseEntity<String> registration(UserDTO userdto){
        userdto.setUserPwd(encoder.encode(userdto.getUserPwd()));

        Optional<User> temp = repository.findById(userdto.getUserId());

        if(temp.isPresent()) {
            httpStatus = HttpStatus.FORBIDDEN;
            msg = "DUPLICATE USER";

            return makeResponse();
        }

        try{
            User user = userdto.initUserRegistration();
            user.addRole("USER");

            repository.save(user);

            httpStatus = HttpStatus.CREATED;
            msg = user.getUserNickName() + " USER CREATED";

        }catch (Exception e){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = e.getMessage();

        }finally {
            return makeResponse();
        }
    }

    @Override
    public ResponseEntity<String> signup(String userId, String userPwd){
        System.out.println("userId = " + userId);
        System.out.println("userPwd = " + userPwd);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, userPwd);
        Authentication authentication;

        try{
            authentication = authenticationManager.authenticate(authenticationToken);

            httpStatus = HttpStatus.OK;
            msg = provider.generateToken(authentication).toString();
        }catch (Exception exception){
            httpStatus=HttpStatus.UNAUTHORIZED;
            msg = exception.toString();
        }finally {
            return makeResponse();
        }
    }

    @Override
    public ResponseEntity<String> delete(String userId){
        try {
                repository.deleteById(getDecoding(userId));
                log.info("User Deleted : " + userId);

                httpStatus = HttpStatus.OK;
                msg = "DELETE USER";
            } catch (Exception exception) {
                httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
                msg = exception.getMessage();
            }finally {
            return makeResponse();
        }
    }

    private String getDecoding(String target){
        return new String(decoder.decode(target));
    }

    private ResponseEntity<String> makeResponse(){
        try{
            return ResponseEntity.status(httpStatus).body(objectMapper.writeValueAsString(new JsonMessage(msg)));
        }catch (JsonProcessingException exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }
    }
}


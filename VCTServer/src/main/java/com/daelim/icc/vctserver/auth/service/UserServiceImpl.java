package com.daelim.icc.vctserver.auth.service;

import com.daelim.icc.vctserver.auth.dao.User;
import com.daelim.icc.vctserver.auth.dto.UserDTO;
import com.daelim.icc.vctserver.auth.jwt.provider.JwtProvider;
import com.daelim.icc.vctserver.auth.repository.UserRepository;
import com.daelim.icc.vctserver.constdata.JsonMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.Pair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtProvider provider;
    private final PasswordEncoder encoder;
    private final ObjectMapper objectMapper;

    /*private AuthenticationManager authenticationManager;

    @PostConstruct
    public void postConstruct(){
        this.authenticationManager = authenticationManagerBuilder.getObject();
    }*/

    @Override
    public ResponseEntity<String> userRegistration(UserDTO userdto) throws JsonProcessingException {
        userdto.setUserPwd(encoder.encode(userdto.getUserPwd()));

        Optional<User> temp = repository.findById(userdto.getUserId());

        if(temp.isPresent()) return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(objectMapper.writeValueAsString(new JsonMessage("duplicate User")));

        HttpStatus httpStatus = null;
        String msg = null;
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
            return ResponseEntity.status(httpStatus).body(objectMapper.writeValueAsString(new JsonMessage(msg)));
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> login(String userId, String userPwd){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, userPwd);
        Authentication authentication;

        try{
            authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        }catch (UsernameNotFoundException exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.toString());
        }

        return ResponseEntity.ok(provider.generateToken(authentication).toString());
    }

    @Override
    public ResponseEntity<String> deleteUser(String userId){
        repository.deleteById(userId);
        try {
                repository.deleteById(userId);
                log.info("User Deleted : " + userId);

                return ResponseEntity.ok(new Pair<>("msg", "Delete User").toString());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(new Pair<>("msg", e.getMessage()).toString());
            }
    }
}


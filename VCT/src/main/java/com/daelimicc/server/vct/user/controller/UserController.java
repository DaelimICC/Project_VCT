package com.daelimicc.server.vct.user.controller;

import com.daelimicc.server.vct.user.domain.User;
import com.daelimicc.server.vct.user.dto.UserDTO;
import com.daelimicc.server.vct.user.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(tags = "사용자 관리 API")
public class UserController {

    private final UserRepository userRepository;

    /**
     * 사용자 생성
     * @param userDTO
     * @return
     */
    @ApiOperation(value = "사용자 생성")
    @PostMapping("")
    public User registerUser(@RequestBody UserDTO userDTO) {
        return userRepository.save(userDTO.toEntity());
    }
}

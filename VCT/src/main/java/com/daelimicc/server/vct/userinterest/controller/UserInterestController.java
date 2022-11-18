package com.daelimicc.server.vct.userinterest.controller;

import com.daelimicc.server.vct.userinterest.domain.UserInterest;
import com.daelimicc.server.vct.userinterest.dto.UserInterestDTO;
import com.daelimicc.server.vct.userinterest.repository.UserInterestRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userInterest")
@RequiredArgsConstructor
@Api(tags = "사용자 관심 코인 API")
public class UserInterestController {
    private final UserInterestRepository userInterestRepository;
    @ApiOperation(value = "사용자 관심 코인 리스트 불러오기")
    @GetMapping("/list")
    public Iterable<UserInterest> getUserInterestList() {
        return userInterestRepository.findAll();
    }
    @ApiOperation(value = "사용자 관심 코인 수정")
    @PutMapping("")
    public UserInterest updateUser(@RequestBody UserInterestDTO userInterestDTO) {
        return userInterestRepository.save(userInterestDTO.toEntity());
    }


}

package com.daelimicc.server.vct.user.controller;

import com.daelimicc.server.vct.user.domain.User;
import com.daelimicc.server.vct.user.dto.UserDTO;
import com.daelimicc.server.vct.user.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(tags = "사용자 관리 API")
public class UserController {

    private final UserRepository userRepository;

    /**
     * 사용자 생성
     * @param userDTO 사용자 정보
     * @return 생성된 사용자 정보
     */
    @ApiOperation(value = "사용자 생성")
    @PostMapping("")
    public User registerUser(@RequestBody UserDTO userDTO) {
        return userRepository.save(userDTO.toEntity());
    }

    /**
     * 사용자 조회
     * @param id 사용자 아이디
     * @return 사용자 정보
     */
    @ApiOperation(value = "사용자 정보 불러오기")
    @GetMapping("")
    public User getUser(@RequestParam String id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
    }

    /**
     * 사용자 리스트 호출
     * @return 사용자 리스트
     */
    @ApiOperation(value = "사용자 리스트 불러오기")
    @GetMapping("/list")
    public Iterable<User> getUserList() {
        return userRepository.findAll();
    }

    /**
     * 사용자 정보 삭제
     * @param id 사용자 아이디
     */
    @ApiOperation(value = "사용자 삭제")
    @DeleteMapping("")
    public void deleteUser(@RequestParam String id) {
        userRepository.deleteById(id);
    }

    /**
     * 사용자 정보 수정
     * @param userDTO 사용자 정보
     * @return 수정된 사용자 정보
     */
    @ApiOperation(value = "사용자 정보 수정")
    @PutMapping("")
    public User updateUser(@RequestBody UserDTO userDTO) {
        return userRepository.save(userDTO.toEntity());
    }
}

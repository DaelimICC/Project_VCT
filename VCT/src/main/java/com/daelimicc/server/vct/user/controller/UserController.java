package com.daelimicc.server.vct.user.controller;

import com.daelimicc.server.vct.user.domain.User;
import com.daelimicc.server.vct.user.dto.UserDTO;
import com.daelimicc.server.vct.user.repository.UserRepository;
import com.daelimicc.server.vct.userinterest.domain.UserInterest;
import com.daelimicc.server.vct.userinterest.dto.UserInterestDTO;
import com.daelimicc.server.vct.userinterest.repository.UserInterestRepository;
import com.daelimicc.server.vct.wallet.dto.WalletDTO;
import com.daelimicc.server.vct.wallet.repository.WalletRepository;
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
    private final WalletRepository walletRepository;
    private final UserInterestRepository userInterestRepository;

    /**
     * 사용자 생성
     * @param userDTO 사용자 정보
     * @return 생성된 사용자 정보
     */
    @ApiOperation(value = "사용자 생성")
    @PostMapping("")
    public User registerUser(@RequestBody UserDTO userDTO) {

        WalletDTO walletDTO = new WalletDTO();
        walletDTO.set_id(userDTO.get_id());
        walletDTO.setName(userDTO.getName());
        walletRepository.save(walletDTO.toEntity());

        UserInterestDTO userInterestDTO = new UserInterestDTO();
        userInterestDTO.set_id(userDTO.get_id());
        userInterestDTO.setWCU(false);
        userInterestDTO.setPTT(false);
        userInterestDTO.setONI(false);
        userInterestDTO.setCBB(false);
        userInterestDTO.setCORN(false);
        userInterestDTO.setGPP(false);
        userInterestDTO.setGRR(false);
        userInterestDTO.setGONI(false);
        userInterestDTO.setSQS(false);
        userInterestDTO.setTMT(false);
        userInterestRepository.save(userInterestDTO.toEntity());

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
        walletRepository.deleteById(id);
        userInterestRepository.deleteById(id);
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

        WalletDTO walletDTO = new WalletDTO();
        walletDTO.set_id(userDTO.get_id());
        walletDTO.setName(userDTO.getName());
        walletRepository.save(walletDTO.toEntity());

        return userRepository.save(userDTO.toEntity());
    }
}

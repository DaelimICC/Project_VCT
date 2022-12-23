package com.daelim.icc.vctserver.auth.dto;

import com.daelim.icc.vctserver.auth.dao.User;
import com.daelim.icc.vctserver.constdata.CoinList;
import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
@Data
public class UserDTO {
    private String userId;
    private String userPwd;
    private String userName;

    private HashMap<CoinList, Integer> createNewWallet() {
        HashMap<CoinList, Integer> wallet = new HashMap<>();

        Arrays.stream(CoinList.values()).forEach(coin -> wallet.put(coin, 0));

        return wallet;
    }

    public User initUserRegistration() {
        User user = User.builder()
                .userId(this.userId)
                .userPwd(this.userPwd)
                .userName(this.userName)
                .userPoint(0.0F)
                .userWallet(createNewWallet())
                .build();

        return user;
    }
}

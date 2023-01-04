package com.daelim.icc.vctserver.auth.dto;

import com.daelim.icc.vctserver.auth.dao.User;
import com.daelim.icc.vctserver.constdata.CoinList;
import lombok.*;

import java.util.Arrays;
import java.util.HashMap;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String userPwd;
    private String userNickName;

    private HashMap<CoinList, Integer> createNewWallet() {
        HashMap<CoinList, Integer> wallet = new HashMap<>();

        Arrays.stream(CoinList.values()).forEach(coin -> wallet.put(coin, 0));

        return wallet;
    }

    private HashMap<CoinList, Boolean> createUserFavorite() {
        HashMap<CoinList, Boolean> favorite = new HashMap<>();
        Arrays.stream(CoinList.values()).forEach(coin -> favorite.put(coin, false));

        return favorite;
    }

    public User initUserRegistration() {
        User user = User.builder()
                .userId(this.userId)
                .userPwd(this.userPwd)
                .userNickName(this.userNickName)
                .userPoint(0.0F)
                .userWallet(createNewWallet())
                .userFavorite(createUserFavorite())
                .build();

        return user;
    }
}

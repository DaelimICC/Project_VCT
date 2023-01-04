package com.daelim.icc.vctserver.auth.dao;

import com.daelim.icc.vctserver.constdata.CoinList;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
@Document(collection = "User_INFO")
public class User implements UserDetails {
    @Id
    private String userId;
    private String userPwd;
    private String userNickName;
    private Float userPoint;
    private HashMap<CoinList, Integer> userWallet;
    private HashMap<CoinList, Boolean> userFavorite;

    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public void addRole(String... role){
        for (int i = 0; i < role.length; i++) {
            roles.add(role[i]);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return userPwd;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

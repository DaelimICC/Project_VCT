package com.daelim.icc.vctserver.auth.jwt.provider;

import com.daelim.icc.vctserver.auth.jwt.dto.TokenDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtProvider {
    private final Key key;
    private final long expiresTime;
    private Date expires;

    public JwtProvider(@Value("${spring.jwt.secret.key}") String secretKey) {
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
        expiresTime = 60 * 60 * 1000; // 1H
    }

    public TokenDTO generateToken(Authentication authentication){
        expires = new Date(new Date().getTime() + expiresTime);

        return TokenDTO.builder()
                .type("Bearer")
                .access(buildToken(authentication))
                .refresh(buildToken())
                .build();
    }

    private String buildToken(Authentication authentication){
        return buildBasicJWT()
                .setSubject(authentication.getName())
                .claim("auth", parseAuthorities(authentication))
                .compact();
    }

    private String buildToken(){
        return buildBasicJWT().compact();
    }

    private JwtBuilder buildBasicJWT(){
        return Jwts.builder().setExpiration(expires).signWith(key, SignatureAlgorithm.HS256);
    }

    private String parseAuthorities(Authentication authentication){
        return authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    public Authentication getAuthentication(String accessToken) throws AuthenticationException {
        Claims claims = parseClaims(accessToken);

        if (claims.get("auth").equals(null)) throw new AuthenticationException("권한 없음");

        List<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new).toList();

        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;
    }
}

package com.daelim.icc.vctserver.auth.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenDTO {
    private String type;
    private String access;
    private String refresh;

    public static String getFormat(){
        return """
                TokenDTO{
                          type='Bearer',
                          access='(accessToken)',
                          refresh='(refreshToken)'}
                """;
    }


}

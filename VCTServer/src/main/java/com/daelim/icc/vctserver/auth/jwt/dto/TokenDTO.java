package com.daelim.icc.vctserver.auth.jwt.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class TokenDTO {
    private String type;
    private String access;
    private String refresh;
}

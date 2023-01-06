package com.daelim.icc.vctserver;

import com.daelim.icc.vctserver.auth.dto.UserDTO;
import org.junit.jupiter.api.*;
import org.springframework.http.MediaType;

import java.util.Base64;

import static com.daelim.icc.vctserver.config.RestDocsConfig.field;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuthTest extends BasicTestClass{

    @Test
    @Order(1)
    public void registrationUser() throws Exception {
        UserDTO userDTO = new UserDTO("testId", "testPwd", "Test1");

        mockMvc.perform(
                post("/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(createJson(userDTO))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("msg").value("Test1 USER CREATED"))
                .andDo(restDocs.document(
                            requestFields(
                                    fieldWithPath("userId").description("유저 ID"),
                                    fieldWithPath("userPwd").description("유저 비밀번호"),
                                    fieldWithPath("userNickName").description("유저 닉네임")
                            ),
                            responseFields(
                                    fieldWithPath("msg").description("처리 결과")
                                            .attributes(field("success", "[CREATED] (user.nickname) USER CREATED"))
                                            .attributes(field("fail", "[FORBIDDEN] DUPLICATE USER \n " +
                                                    "[INTERNAL_SERVER_ERROR] EXCEPTION MESSAGE"))
                            )
                        )
                );
    }

    @Test
    @Order(2)
    public void signInUser() throws Exception {
        addParam("id", "testId");
        addParam("pwd", "testPwd");

        mockMvc.perform(
                post("/user/signin")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .accept("*/*")
                        .params(params)

                )
                .andExpect(status().isOk())
                .andDo(restDocs.document(
                        requestParameters(
                                parameterWithName("id").description("로그인할 계정의 ID"),
                                parameterWithName("pwd").description("로그인할 계정의 비밀번호")
                        ),
                        responseFields(
                                fieldWithPath("msg").description("처리 결과 반환")
                                        .attributes(field("success", "[OK]"))
                                        .attributes(field("fail", "[UNAUTHORIZED] EXCEPTION MESSAGE")),
                                fieldWithPath("msg.type").description("토큰 타입")
                                        .attributes(field("success", "Bearer")),

                                fieldWithPath("msg.access").description("엑세스 토큰"),
                                fieldWithPath("msg.refresh").description("리프레쉬 토큰")
                        )
                ));

    }

    @Test
    @Order(3)
    public void deleteUser() throws Exception {
        String param = Base64.getEncoder().encodeToString("testId".getBytes());

        mockMvc.perform(
                delete("/user/delete")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .accept("*/*")
                        .header("targetId", param)
                )
                .andExpect(status().isOk())
                .andDo(restDocs.document(
                        requestHeaders(
                                headerWithName("targetId").attributes(field("etc", "Base64Encode"))
                                        .description("삭제할 사용자 ID")

                        ),
                        responseFields(
                                fieldWithPath("msg").description("처리 결과 반환")
                                        .attributes(field("success", "[OK] DELETE USER"))
                                        .attributes(field("fail", "[INTERNAL_SERVER_ERROR] EXCEPTION MESSAGE"))

                        )
                ));
    }
}

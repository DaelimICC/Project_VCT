package com.daelim.icc.vctserver;

import org.junit.jupiter.api.*;

import static com.daelim.icc.vctserver.config.RestDocsConfig.field;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class NewsTest extends BasicTestClass{
    @Test
    @Order(1)
    public void updateNews() throws Exception {
        mockMvc.perform(get("/news/update"))
                //.andExpect(status().isOk())
                .andDo(restDocs.document(
                            responseFields(
                                    fieldWithPath("msg").description("처리 결과 반환")
                                            .attributes(field("success", "[OK] 뉴스 리스트 반환"))
                                            .attributes(field("fail", "[INTERNAL_SERVER_ERROR] EXCEPTION MESSAGE")),
                                    fieldWithPath("msg[].id").description("뉴스의 UUID"),
                                    fieldWithPath("msg[].title").description("뉴스 제목"),
                                    fieldWithPath("msg[].link").description("뉴스 링크"),
                                    fieldWithPath("msg[].thumb").description("뉴스 썸네일 링크"),
                                    fieldWithPath("msg[].dttm").description("뉴스 작성 일자")
                            )
                        )
                );
    }


    @Test
    @Order(2)
    public void getNews() throws Exception {
        mockMvc.perform(get("/news"))
                .andExpect(status().isOk())
                .andDo(restDocs.document(
                                responseFields(
                                        fieldWithPath("msg").description("처리 결과 반환")
                                                .attributes(field("success", "[OK] 뉴스 리스트 반환"))
                                                .attributes(field("fail", "[INTERNAL_SERVER_ERROR] EXCEPTION MESSAGE")),
                                        fieldWithPath("msg[].id").description("뉴스의 UUID"),
                                        fieldWithPath("msg[].title").description("뉴스 제목"),
                                        fieldWithPath("msg[].link").description("뉴스 링크"),
                                        fieldWithPath("msg[].thumb").description("뉴스 썸네일 링크"),
                                        fieldWithPath("msg[].dttm").description("뉴스 작성 일자")
                                )
                        )
                );

    }
}

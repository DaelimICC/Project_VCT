package com.daelim.icc.vctserver.config;

import org.springframework.asm.Attribute;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.snippet.Attributes;
import org.xml.sax.ext.Attributes2;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

@TestConfiguration
public class RestDocsConfig {
    @Bean
    public RestDocumentationResultHandler write(){
        return MockMvcRestDocumentation.document(
                "{ClassName}/{methodName}",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint())
        );
    }

    public static final Attributes.Attribute field(String key, String value){
        return new Attributes.Attribute(key, value);
    }
}

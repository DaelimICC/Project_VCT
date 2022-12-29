package com.daelim.icc.vctserver;

import com.daelim.icc.vctserver.config.RestDocsConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.util.Pair;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Disabled
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(RestDocumentationExtension.class)
@Import({ObjectMapper.class, RestDocsConfig.class})
@WebAppConfiguration
@Testcontainers
@SpringBootTest
public abstract class BasicTestClass {

    private static final MongoDBContainer mongo;

    static{
        mongo = new MongoDBContainer("mongo").withReuse(true);
        mongo.start();
    }


    @Autowired
    ObjectMapper objectMapper;

    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

    @Autowired
    RestDocumentationResultHandler restDocs;

    MockMvc mockMvc;

    @DynamicPropertySource
    static void setProperty(DynamicPropertyRegistry registry){
        registry.add("spring.data.mongodb.uri", mongo::getReplicaSetUrl);

        try {
            Files.readAllLines(
                            Paths.get(
                                    System.getProperty("user.dir").replace("VCTServer", ".env")
                            )
                    ).stream()
                    .filter(line -> !(line.startsWith("#") || line.isBlank()))
                    .map(BasicTestClass::changeProperty)
                    .forEach(propertyPair -> registry.add(propertyPair.getFirst(), propertyPair::getSecond));

        }catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }

    private static Pair<String, String> changeProperty(String line){
        String[] property = line.replaceAll("_", ".").split(" = ");
        return Pair.of(property[0].toLowerCase(), property[1]);
    }

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(restDocs)
                .alwaysDo(print())
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    String createJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    @BeforeEach
    void clearParams(){
        params.clear();
    }
    void addParam(String name, String value){
        params.add(name, value);
    }
}

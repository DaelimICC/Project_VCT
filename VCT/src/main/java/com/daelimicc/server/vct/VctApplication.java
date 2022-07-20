package com.daelimicc.server.vct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class VctApplication {

    public static void main(String[] args) {
        SpringApplication.run(VctApplication.class, args);
    }

}

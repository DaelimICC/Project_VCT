package com.daelim.icc.vctserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
@SpringBootApplication
public class VctServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VctServerApplication.class, args);
	}

	@GetMapping("")
	public String hello() {
		return "Hello";
	}

}

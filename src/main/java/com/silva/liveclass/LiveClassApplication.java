package com.silva.liveclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class LiveClassApplication /*extends SpringBootServletInitializer*/{

	public static void main(String[] args) {
		SpringApplication.run(LiveClassApplication.class, args);
	}
}

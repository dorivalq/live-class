package com.silva.liveclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class LiveClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveClassApplication.class, args);
	}


	@GetMapping("/hello/{name}")
	public ResponseEntity<String> sayHello(@PathVariable String name){
		return ResponseEntity.ok("Hello: " + name);
	}
}

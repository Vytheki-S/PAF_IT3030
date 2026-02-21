package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
@GetMapping("/")
public String rootEnding() {
	String message ="Hello word";
    return message;
}
// 1. Basic greet endpoint
	@GetMapping("/greet")
	public String greet() {
		return "Welcome to Spring Boot!";
	}
// 2 & 3. Path variable + optional query param
	@GetMapping("/greet/{name}")
	public String greetUser(
			@PathVariable String name,
			@RequestParam(required = false) String message) {

		if (message != null && !message.isEmpty()) {
			return "Hello " + name + "! " + message;
		}

		return "Hello " + name + "! Welcome to Spring Boot!";
}
}

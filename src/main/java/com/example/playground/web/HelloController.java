package com.example.playground.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	public record Greeting(String message) {
	}

	@GetMapping("/hello")
	public Greeting hello(@RequestParam(defaultValue = "World") String name) {
		return new Greeting("Hello, %s!".formatted(name));
	}

}

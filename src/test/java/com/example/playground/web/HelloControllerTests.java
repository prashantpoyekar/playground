package com.example.playground.web;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void helloDefault() throws Exception {
		this.mvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.message").value("Hello, World!"));
	}

	@Test
	void helloWithName() throws Exception {
		this.mvc.perform(get("/hello").param("name", "Java 25"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.message").value("Hello, Java 25!"));
	}

}

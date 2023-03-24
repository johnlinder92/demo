package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private JsonHandler jsonHandler;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/data/{id}")
	public String postData(@PathVariable Long id, @RequestParam(value = "name", defaultValue = "World") String name) throws IOException {

		jsonHandler.updateJsonById(id, name);

		return "created element with ID: "+ id + " and value: " + name;
	}
	@GetMapping("/data")
	public ResponseEntity<HashMap<Long, String >> GetAllData() throws IOException {

		ResponseEntity<HashMap<Long, String>> test = jsonHandler.getWholeJson();


		return test;
	}



}

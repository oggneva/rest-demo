package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping
public class GreetingController {

	private static final String template = "Hello, %s! - some say: %s";
	private final AtomicLong counter = new AtomicLong();

	private SomeService someService;

	public GreetingController(SomeService someService) {
		this.someService = someService;
	}

	@RequestMapping("/greeting")
	public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		if ("die".equalsIgnoreCase(name)) {
			throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "bad things happened");
		}
		String messageFromSome = someService.doSomeThing();
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name, messageFromSome));
		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}
}

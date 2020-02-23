package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler(ResponseStatusException.class)
	public final ResponseEntity<Object> handleException(ResponseStatusException ex, WebRequest request) {
		System.out.println("RestResponseEntityExceptionHandler.handleException() " + ex.getStatus() + " " + ex.getReason());
		throw ex;
	}
}

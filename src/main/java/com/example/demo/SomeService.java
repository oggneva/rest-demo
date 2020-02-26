package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
	public String doSomeThing() {
		System.out.println("SomeService.doSomeThing() - doin' very important stuff...");
		return "live long and prosper";
	}
}

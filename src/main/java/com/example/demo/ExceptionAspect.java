package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @see <a href=
 *      "https://www.baeldung.com/spring-aop-pointcut-tutorial">spring-aop-pointcut-tutorial</a>
 */
@Component
@Aspect
public class ExceptionAspect {

	@Pointcut("execution(* com.example.demo.GreetingController.*(..))")
	public void controllerMethods() {
	}

	@AfterReturning(value = "controllerMethods()", returning = "responseEntity")
	public void controlMethodExecuted(JoinPoint jp, ResponseEntity<?> responseEntity) throws Throwable {
		System.out.println("ExceptionAspect.controlMethodExecuted() " + responseEntity);
	}

	@AfterThrowing(value = "controllerMethods()", throwing = "e")
	public void controlMethodExeptionalExit(Exception e) throws Throwable {
		System.out.println("ExceptionAspect.controlMethodExeptionalExit() " + e.getMessage());
	}

}

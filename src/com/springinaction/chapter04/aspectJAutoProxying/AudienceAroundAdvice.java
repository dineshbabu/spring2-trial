package com.springinaction.chapter04.aspectJAutoProxying;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.springinaction.springidol.DIConstructorProperty.PerformanceException;
@Aspect
public class AudienceAroundAdvice{
	
	@Pointcut("execution(* *.perform(..))")
	public void performance() {}
	
	@Around("performance()") 
	public void watchPerformance (ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("Using around advice.");
	  System.out.println("The audience is taking their seats.");
	  System.out.println("The audience is turning off " +
	      "their cellphones");
	  try {
	    joinpoint.proceed();
	    System.out.println("CLAP CLAP CLAP CLAP CLAP");
	  } catch (PerformanceException throwable) {
	    System.out.println("Boo! We want our money back!");
	  }
	}
}

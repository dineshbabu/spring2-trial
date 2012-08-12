package com.springinaction.chapter04.classicAspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.springidol.DIConstructorProperty.PerformanceException;
import com.springinaction.springidol.DIConstructorProperty.Performer;

public class TestClassicAspect {
	public static void main(String[] args) throws PerformanceException{
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/chapter04/classicAspect/spring-idol.xml");
		Performer performer = (Performer)context.getBean("duke");// Note that this is the proxy interface bean and not the actual bean.
		performer.perform();
  } 
}
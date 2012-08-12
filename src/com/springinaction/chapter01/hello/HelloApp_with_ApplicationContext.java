// Dependency injection of string property and String constructor args with ApplicationContext.


package com.springinaction.chapter01.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp_with_ApplicationContext {
	  public static void main(String[] args) throws Exception {
		//ApplicationContext context = new FileSystemXmlApplicationContext("C:\\eclipseWorkspace\\zSpring\\src\\com\\springinaction\\chapter01\\hello\\hello.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("hello1.xml");// hello1.xml should be in the class path , including in jars
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/chapter01/hello/hello.xml");// hello.xml should be in the class path , including in jars
		
		GreetingService greetingService = (GreetingService) context.getBean("greetingService");
	    greetingService.sayGreeting();
	  }
}

class GreetingServiceImpl implements GreetingService {
	private String greeting;
	public GreetingServiceImpl() {}
	public GreetingServiceImpl(String greeting) {
	  this.greeting = greeting;
	}
	public void sayGreeting() {
	   System.out.println(greeting);
	}
	public void setGreeting(String greeting) {
	  this.greeting = greeting;
	}
}

interface GreetingService {
	  void sayGreeting();
}


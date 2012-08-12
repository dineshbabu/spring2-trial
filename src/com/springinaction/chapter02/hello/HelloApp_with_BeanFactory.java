// Dependency injection of string property and String constructor args using ApplicationContext


package com.springinaction.chapter02.hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp_with_BeanFactory {
	  public static void main(String[] args) throws Exception {
	    BeanFactory factory = new XmlBeanFactory(new FileSystemResource("C:\\eclipseWorkspace\\zSpring\\src\\com\\springinaction\\chapter02\\hello\\hello.xml"));
	    																 
	    GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
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


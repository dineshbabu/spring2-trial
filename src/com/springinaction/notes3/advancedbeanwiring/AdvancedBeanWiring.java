
package com.springinaction.notes3.advancedbeanwiring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvancedBeanWiring {
	  public static void main(String[] args) throws Exception {
		//ApplicationContext context = new FileSystemXmlApplicationContext("C:\\eclipseWorkspace\\zSpring\\src\\com\\springinaction\\chapter01\\hello\\hello.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("hello1.xml");// hello1.xml should be in the class path , including in jars
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/notes3/advancedbeanwiring/hello.xml");// hello.xml should be in the class path , including in jars
		
		GreetingService greetingService = (GreetingService) context.getBean("greetingService");
	    greetingService.sayGreeting();
	    greetingService.replaceThisMethodBasic();
	  }
}

class GreetingServiceImpl extends GreetingService {

	public GreetingServiceImpl() {}
	
	private String propertyFromParentAbstractBean;

	public void setPropertyFromParentAbstractBean(String propertyFromParentAbstractBean) {
		this.propertyFromParentAbstractBean = propertyFromParentAbstractBean;
	}

	public void setGreeting(String greeting){
		this.greeting = greeting;
	}

	public void sayGreeting() {
	   System.out.println(greeting);
	   System.out.println(propertyFromParentAbstractBean);
	}
	
	public void replaceThisMethodBasic(){
		System.out.println("replaceThisMethodBasic called");
	}
}

abstract class GreetingService {
	public String greeting = "Greetings from Greeting Service";
	  abstract void sayGreeting();
	  abstract void replaceThisMethodBasic();
}

class AnotherBean implements InitializingBean, DisposableBean{
	
	static AnotherBean init(){
		return new AnotherBean();
	}

	public void destroy() throws Exception {
		System.out.println("AnotherBean destroy called");
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("AnotherBean After property set called");
	}
	
	
}


package com.springinaction.springidol.DIConstructorProperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Juggler implements Performer{
	
	int beanBags = 3;
	
	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}
	
	public Juggler() {}

	public void perform() throws PerformanceException {
	   System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}
	
	public static void main(String[] args) throws PerformanceException{
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/springidol/DIConstructorProperty/spring-idol.xml");
		Performer performer = (Performer)context.getBean("duke");
		performer.perform();
	}
}

package com.springinaction.springidol.autowiringconstructor;

/**
 * Note: The constructor argument order can be specified by index/type attribute in the application context xml. The value of type
 * should be the object mentioned in the contructor, not its subclass. 
 * refer C:\apache-tomcat-6.0.33\webapps\spring\WEB-INF\classes\com\springinaction\springidol\DIConstructorObjectRefspring\spring-idol.xml 
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.springidol.DIConstructorProperty.Juggler;
import com.springinaction.springidol.DIConstructorProperty.PerformanceException;
import com.springinaction.springidol.DIConstructorProperty.Performer;

public class PoeticJuggler extends Juggler {
	
	  public static void main(String[] args) throws PerformanceException{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/springidol/autowiringconstructor/spring-idol.xml");
			Performer performer = (Performer)context.getBean("duke");
			performer.perform();
	  }
	  
	private Poem poem;
	public PoeticJuggler(Poem poem) {//poem argument in constructor autowired.
	    super();
	    this.poem = poem;
	}
	public PoeticJuggler(int beanBags, Poem poem) { //poem argument in constructor autowired.
	    super(beanBags);
	    this.poem = poem;
	}
	public void perform() throws PerformanceException {
	    super.perform();
	    System.out.println("WHILE RECITING...");
	    poem.recite();
	}
}
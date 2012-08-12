package com.springinaction.springidol.MethodInjectionBasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.springidol.DIConstructorProperty.PerformanceException;
import com.springinaction.springidol.DIConstructorProperty.Performer;
import com.springinaction.springidol.MethodInjectionBasic.MagicBox;

public class Magician implements Performer {
	public static void main(String[] args) throws PerformanceException{
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/springidol/MethodInjectionBasic/spring-idol.xml");
		Performer performer = (Performer)context.getBean("harry");
		performer.perform();
	}
	
	public Magician() {} 
	public void perform() throws PerformanceException {
	    System.out.println(magicWords);
	    System.out.println("The magic box contains...");
	    System.out.println(magicBox.getContents());// this method call is replaced at run time.
	}
	// injected
	private MagicBox magicBox;
	public void setMagicBox(MagicBox magicBox) {
	    this.magicBox = magicBox; 
	} 
	private String magicWords;
	public void setMagicWords(String magicWords) {
	    this.magicWords = magicWords;
	}
}
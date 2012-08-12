package com.springinaction.springidol.DIBeanProperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.springidol.DIConstructorProperty.PerformanceException;
import com.springinaction.springidol.DIConstructorProperty.Performer;

public class Instrumentalist implements Performer {
	
	public static void main(String[] args) throws PerformanceException{
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\springinaction\\springidol\\DIBeanProperty\\spring-idol.xml");
		Performer perform = (Performer)context.getBean("kenny");
		perform.perform();
	}
	
	private String song;

	private Instrument instrument;
	
	public Instrumentalist() {}
	
	public void perform() throws PerformanceException {
		 System.out.print("Playing " + song + " : ");
		    instrument.play();
	}
	
	public void setSong(String song) {
	    this.song = song;
	}
	
	public void setInstrument(Instrument instrument) {
	    this.instrument = instrument;
	}
}
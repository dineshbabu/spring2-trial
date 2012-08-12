package com.springinaction.springidol.DICollection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.springidol.DIBeanProperty.Instrument;
import com.springinaction.springidol.DIConstructorProperty.PerformanceException;
import com.springinaction.springidol.DIConstructorProperty.Performer;

public class OneManBand implements Performer {

	public static void main(String[] args) throws PerformanceException{
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/springidol/DICollection/spring-idol.xml");
		Performer perfromer = (Performer)context.getBean("hank");
		perfromer.perform();
	}
	public OneManBand() {}
	public void perform() throws PerformanceException {
		
		//With non object List
	    for(Integer integer : instrumentsNonObject) {
	      System.out.println("integer : " + integer);
	    }
	    
		//With Object List
	    for(Instrument instrument : instruments) {
	      instrument.play();
	    }
	    
	    //With Map
	    for (String key : instrumentsMap.keySet()) {
	        System.out.print(key + " : ");
	        Instrument instrument = instrumentsMap.get(key);
	        instrument.play(); 
	    }
	    
	    //With Properties
	    for (Iterator iter = instrumentsProperties.keySet().iterator();iter.hasNext();) {
	          String key = (String) iter.next();
	          System.out.println(key + " : " + instrumentsProperties.getProperty(key));
	        }
	}
	
	private Collection<Integer> instrumentsNonObject;
	
	public void setInstrumentsNonObject(Collection<Integer> instrumentsNonObject) {
		this.instrumentsNonObject = instrumentsNonObject;
	}

	private Collection<Instrument> instruments;
	
	public void setInstruments(Collection<Instrument> instruments) {
	    this.instruments = instruments;
	}
	
	private Map<String,Instrument> instrumentsMap;
	
	public void setinstrumentsMap(Map<String,Instrument> instrumentsMap) {
	    this.instrumentsMap = instrumentsMap;
	}
	
	private Properties instrumentsProperties;
	
	public void setinstrumentsProperties(Properties instrumentsProperties) {
	    this.instrumentsProperties = instrumentsProperties;
	}
	  
}

package com.springinaction.chapter04.POJOaspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class Audience { 
	
	  public Audience() {}
	  
	  public void performance() {}
	  
	  public void takeSeats() {
	    System.out.println("The audience is taking their seats.");
	  }
	  
	  public void turnOffCellPhones() {
	    System.out.println("The audience is turning off " +
	        "their cellphones");
	  }
	  
	  public void applaud() {
	    System.out.println("CLAP CLAP CLAP CLAP CLAP");
	  }
	  
	  public void demandRefund() {
	    System.out.println("Boo! We want our money back!");
	  }
}
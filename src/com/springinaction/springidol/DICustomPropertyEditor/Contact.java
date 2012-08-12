package com.springinaction.springidol.DICustomPropertyEditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Contact {
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/springidol/DICustomPropertyEditor/spring-idol.xml");
		
		System.out.println(((Contact)context.getBean("contact")).phoneNumber);
	}
	private PhoneNumber phoneNumber;
	public void setPhoneNumber(PhoneNumber phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}
}

class PhoneNumber {
	private String areaCode;
	private String prefix;
	private String number;
	public PhoneNumber() { }
	public PhoneNumber(String areaCode, String prefix, String number) {
	    this.areaCode = areaCode;
	    this.prefix = prefix;
	    this.number = number;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Area Code: " + areaCode + " Prefix: "+ prefix + " number : " + number;
	}
}
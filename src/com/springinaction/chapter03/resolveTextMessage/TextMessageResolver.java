package com.springinaction.chapter03.resolveTextMessage;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextMessageResolver {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/chapter03/resolveTextMessage/spring-idol.xml");
		System.out.println(context.getMessage("computer", new Object[0], Locale.FRENCH));
	}

}

package com.springinaction.chapter03.publishEvents;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Publisher class
public class CourseFullEvent extends ApplicationEvent implements ApplicationContextAware{
	
	public CourseFullEvent(Object source) {
		super(source);
	}

	public static void main(String[] args){
		context = new ClassPathXmlApplicationContext("com/springinaction/chapter03/publishEvents/spring-idol.xml");
		context.publishEvent(new CourseFullEvent(new Course()));
	}
	
	static ApplicationContext context;

	public void setApplicationContext(ApplicationContext applicationcontext) throws BeansException {
	 //context = applicationcontext;
	}
}

class Course {	
}

//Listener class
class CourseFullEventListener implements ApplicationListener {
	public void onApplicationEvent(ApplicationEvent event) {
	    System.out.println("Listening to event");
	}
}
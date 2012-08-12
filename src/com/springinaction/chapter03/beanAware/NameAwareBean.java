//name aware not working. Others not sure how to use
package com.springinaction.chapter03.beanAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NameAwareBean implements BeanNameAware, ApplicationContextAware/*, BeanFactoryAware*/{

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/chapter03/beanAware/spring-idol.xml");
		NameAwareBean nameAwareBean = (NameAwareBean)context.getBean("NameAwareBean");
		System.out.println(nameAwareBean.toString());
	}
	
	String beanName;
	ApplicationContext context;
	BeanFactory beanfactory;
	
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	/*public void setBeanFactory(BeanFactory beanfactory) throws BeansException {
		this.beanfactory = beanfactory;		
	}*/
	
	public String toString(){
		return "beanName : "+ beanName + " context: " + context + " beanfactory: "+ beanfactory;
	}

	
}

class Test{
	public static void main(String[] args){
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/chapter03/beanAware/spring-idol.xml");
		System.out.println(new NameAwareBean().toString());
	}
}

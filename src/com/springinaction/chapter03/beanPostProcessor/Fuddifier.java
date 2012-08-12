//Both BeanPostProcessor and BeanFactoryPostProcessor.

package com.springinaction.chapter03.beanPostProcessor;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Fuddifier implements BeanPostProcessor {
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/chapter03/beanPostProcessor/spring-idol.xml");
		
		System.out.println(((Rabbit)context.getBean("bugs")).description);
	}
	
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
	    try {
	      for(int i=0; i < fields.length; i++) {
	        if(fields[i].getType().equals(
	            java.lang.String.class)) {
	          fields[i].setAccessible(true);
	          String original = (String) fields[i].get(bean);
	          fields[i].set(bean, fuddify(original));
	        }
	      }
	    System.out.println("postprocessor after bean initialisation");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return bean;
  }
	
  private String fuddify(String orig) {
    if(orig == null) return orig;
    return orig.replaceAll("(r|l)", "w")
        .replaceAll("(R|L)", "W"); 
  }
  
  public Object postProcessBeforeInitialization( Object bean, String name) throws BeansException {
	  System.out.println("Before bean initialisation");
	  return bean;
  }
  
}

// Bean Factory post processor. Only available with ApplicationCOntext not with baisc BeanFactory.
class BeanCounter implements BeanFactoryPostProcessor {
	  public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
	    System.out.println("BEAN COUNT:  " + factory.getBeanDefinitionCount());
	  }
}

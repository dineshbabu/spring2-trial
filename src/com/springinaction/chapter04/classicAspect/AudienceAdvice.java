package com.springinaction.chapter04.classicAspect;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
public class AudienceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {
  public AudienceAdvice() {}
  public void before(Method method, Object[] args, Object target) throws Throwable {
    audience.takeSeats();
    audience.turnOffCellPhones(); 
  }
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    audience.applaud();
  }
  public void afterThrowing(Throwable throwable) {
    audience.demandRefund();
  } 
  private Audience audience;
  public void setAudience(Audience audience) {
    this.audience = audience;
  }
}
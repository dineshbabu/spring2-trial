package com.springinaction.chapter04.classicAspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.springinaction.springidol.DIConstructorProperty.PerformanceException;
public class AudienceAroundAdvice implements MethodInterceptor {
  public Object invoke(MethodInvocation invocation) throws Throwable {
    try {
    	System.out.println("Using around advice");
      audience.takeSeats();
      audience.turnOffCellPhones();
      Object returnValue = invocation.proceed();
      audience.applaud();
      return returnValue;
    } catch (PerformanceException throwable) {
      audience.demandRefund();
      throw throwable;
    }
  }
  private Audience audience;
  public void setAudience(Audience audience) {
    this.audience = audience;
  }
}

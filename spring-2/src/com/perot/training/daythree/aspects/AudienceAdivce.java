/**
 * 
 */
package com.perot.training.daythree.aspects;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

/**
 * @author deepak
 *
 */
public class AudienceAdivce implements MethodBeforeAdvice,
		AfterReturningAdvice, ThrowsAdvice {
	
	private Audience audience;

	public Audience getAudience() {
		return audience;
	}

	public void setAudience(Audience audience) {
		this.audience = audience;
	}

	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		audience.takeSeats();
		audience.turnOffCellPhones();
	}

	/* (non-Javadoc)
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		audience.applaud();
	}
	
	/*
	 *  ThrowsAdvice is a marker interface
	 */
//	public void afterThrowing([method], [args], [target], throwable)
	public void afterThrowing(Throwable t) {
		audience.demandRefund();
	}

}

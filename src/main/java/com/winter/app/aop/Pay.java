package com.winter.app.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Pay {
	
	@Around("execution(* com.winter.app.aop.Transfer.*(..))")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("card check IN");
		
		Object[] args = joinPoint.getArgs();
		for(Object o : args) {
			log.info("args : {}", o);
		}
		
		Object obj = joinPoint.proceed();
		
		log.info("return : {}", obj);
		log.info("card check OUT");

		return obj;
	}
	
	@After("execution(* com.winter.app.aop.Transfer.taxi())")
	public void cash() {
		System.out.println("현금");
	}
}

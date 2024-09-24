package com.systex.demo.lab2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect

public class PrintBeforeAdvice {
	
	//@Before("execution(* com.systex.demo.model.Product.*(..))")
	//@Before("com.systex.demo.lab2.CommonPointcut.abc()")
//	@Around("com.systex.demo.lab2.CommonPointcut.abc()")
//	@Around("execution(protected com.systex.demo.lab2.CommonPointcut.abc()")
	@Around("within(com.systex.demo.Product")
	public Object before(ProceedingJoinPoint joinPoint) {
		long start = System.nanoTime();
		Object obj = null;
		System.out.println("這是PrintBeforeAdvice所加入的訊息:" +
				joinPoint.getSignature().getDeclaringTypeName()+"."+
				joinPoint.getSignature().getName());
		
		try {
			obj = joinPoint.proceed();//proceed 就是把控制權還給AOP的runtime
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.nanoTime();
		System.out.println("Total Process Time = "+(end-start)+" ns.");
		return obj;
	}
	
}

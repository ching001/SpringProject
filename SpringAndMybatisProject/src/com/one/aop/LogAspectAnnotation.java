package com.one.aop;

import java.util.Arrays;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("logAnnotation")
@Aspect
public class LogAspectAnnotation {

	//注解形式   前置通知
	@Before("execution(public void addStudent(..))")
	public void myBefore(JoinPoint jp) {
		System.out.println("---[基于注解]的前置通知。。。目标对象:"+jp.getTarget()+"，调用方法名："+jp.getSignature().getName()
				+",方法参数列表："+Arrays.toString(jp.getArgs()));
	}
	
	//注解形式   后置通知
	@AfterReturning(pointcut="execution(public void addStudent(..))",returning="returningValue")
	public void myAfter(JoinPoint jp,Object returningValue) {
		System.out.println("---[基于注解]的后置通知。。。目标对象:"+jp.getTarget()+"，调用方法名："+jp.getSignature().getName()
				+",方法参数列表："+Arrays.toString(jp.getArgs())+"，方法返回值："+returningValue);
	}
	
	//注解形式   环绕通知
	@Around("execution(public void addStudent(..))")
	public void myAround(ProceedingJoinPoint pjp){
		//方法执行前    前置通知
		System.out.println("《注解形式-环绕通知--- 前置通知》");
		try {
			//方法执行时  
			pjp.proceed();
			//方法执行后    后置通知
			System.out.println("《注解形式-环绕通知--- 后置通知》");
			
		} catch (Throwable e) {
			//方法执行异常    异常通知
			System.out.println("《注解形式-环绕通知--- 异常通知》");
			// TODO: handle exception
		}finally {
			//   最终通知
			System.out.println("《注解形式-环绕通知--- 最终通知》");
		}
	}
	
	//注解形式   异常通知
	@AfterThrowing("execution(public void addStudent(..))")
	public void myException() {
		System.out.println("《注解形式----------异常通知》");
	}
	
	
	//注解形式   最终通知
	@After("execution(public void addStudent(..))")
	public void myFinally() {
		System.out.println("《注解形式----------最终通知》");
	}
	
	
	
	
	
	
	
}

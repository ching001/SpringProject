package com.one.aop;

import org.aspectj.lang.JoinPoint;

public class LogSchema {

	public void myBefore(JoinPoint jp) {
		System.out.println("\"》》》》》》》》[Schema形式]的前置通知。。。");
	}
	
	//   后置通知
	public void myAfter(JoinPoint jp) {
		System.out.println("》》》》》》》》[Schema形式]的后置通知。。。");
	}
	
	public void myException(JoinPoint jp, NullPointerException e) {
		System.out.println("》》》》》》》》[Schema形式]的异常通知。。。"+e.getMessage());
	}
	
}

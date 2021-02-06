package com.one.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		try {
			
			System.out.println("···环绕通知的》前置通知...");
			
			//invocation.proceed();之前的代码前置通知
			result = invocation.proceed();//控制着目标方法的执行，addStudent()
			
			//invocation.proceed();之后的代码前置通知
			//System.out.println("···环绕通知的》后置通知...");
			System.out.println("···环绕通知的》后置通知,目标对象:"+invocation.getThis()+"，调用方法名："+invocation.getMethod().getName()
					+",方法参数个数："+invocation.getArguments().length+"，方法返回值："+result);
		} catch (Exception e) {
			System.out.println("···环绕通知的》异常通知...");
			// TODO: handle exception
		}
		return result;
	}

}

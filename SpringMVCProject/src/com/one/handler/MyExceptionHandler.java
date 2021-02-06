//package com.one.servlet;
//package com.one.controller;
//package com.one.action;
package com.one.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//接口/类 注解 配置
//@SessionAttributes("student")
//@SessionAttributes(types= {Student.class,Address.class})
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class})
	//该注解标识的方法参数必须在异常类型，不能包含其它参数类型
	public ModelAndView handlerArithmeticException(Exception e) {
		ModelAndView mv = new ModelAndView("error");
		System.out.println(e);
		mv.addObject("e", e);
		return mv;
	}
	
	
}

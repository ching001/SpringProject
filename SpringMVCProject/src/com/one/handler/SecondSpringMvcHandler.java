//package com.one.servlet;
//package com.one.controller;
//package com.one.action;
package com.one.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.one.exception.MyArrayIndexOutOfBoundsException;

//接口/类 注解 配置
//@SessionAttributes("student")
//@SessionAttributes(types= {Student.class,Address.class})
@Controller
public class SecondSpringMvcHandler {

	@RequestMapping("testExceptionHandler")
	public String testExceptionHandler() {
		int[] num = new int[2];
		System.out.println(num[2]);
		
		System.out.println(1/0);
		
		return "success";
	}
	
	
	@RequestMapping("testMyException")
	public String testMyException(@RequestParam("i") int i ) throws MyArrayIndexOutOfBoundsException {
		if(i==3) {
			throw new MyArrayIndexOutOfBoundsException();
		}
		return "success";
	}
	
	
	
}

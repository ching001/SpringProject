package com.one.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="数组越界异常！！！！！MyArrayIndexOutOfBoundsException")
//该注解可以加在类的前面，也可加在方法的前面
public class MyArrayIndexOutOfBoundsException extends Exception {

}

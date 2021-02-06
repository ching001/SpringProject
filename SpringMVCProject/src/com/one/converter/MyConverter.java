package com.one.converter;

import org.springframework.core.convert.converter.Converter;

import com.one.entity.Student;

//编写自定义转换器的类
public class MyConverter implements Converter<String,Student> {

	@Override
	public Student convert(String source) {
		// TODO Auto-generated method stub
		String[] stuStrArr = source.split("-");
		Student student = new Student();
		student.setId(Integer.parseInt(stuStrArr[0]));
		student.setName(stuStrArr[1]);
		student.setAge(Integer.parseInt(stuStrArr[2]));
		return student;
	}

	

}

package com.one.mapper;

import java.util.List;
import java.util.Map;

import com.one.entity.Student;

//操作Mybatis的接口

public interface StudentMapper {

	/*
	 * 二、Mapper动态代理的方式CRUD(Mybatis接口开发)
	 * 
	 * 1.方法名和mapper.xml文件中标签的id值相同
	 * 2.方法的输入参数和mapper.xmld文件中标签的parameterType类型一致
	 * 3.方法的返回值和mapper.xml文件中标签的resultType类型一致
	 * 
	 */
	
	//查询单个学生
	Student queryStudentByNo(int stuNo);
	//增加
	void addStudent(Student student);

	
}

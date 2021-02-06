package com.one.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.one.day01.Student;
import com.one.day03.CollectionType;
import com.one.day03.Course;
import com.one.service.IStudentService;

public class Test {

	public static void main(String[] args) {
//		teacherDi();
//		collectionType();
		textAop();
	}
	
	public static void textAop(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService)context.getBean("studentService");
		Student student = new Student();
		student.setName("zs");
		student.setAge(23);
		studentService.addStudent(student);
//		studentService.deleteStudentById(1);
	}
	
	public static void teacherDi(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Course course = (Course)context.getBean("course");
		System.out.println(course);
	}
	
	public static void collectionType(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionType collection = (CollectionType)context.getBean("collectionType");
		System.out.println(collection);
	}
	
	
	
	
	
	
}

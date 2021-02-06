package com.one.day01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
//		studentIoc();
		learnCourseWithIoc();
	}
	
	public static void studentIoc() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student stu = (Student)context.getBean("student");
		System.out.println(stu);
	}
	
	public static void learnCourseWithIoc() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student stu = (Student)context.getBean("student");
		stu.learn("java");
	}
	
}

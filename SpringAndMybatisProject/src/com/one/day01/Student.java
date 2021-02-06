package com.one.day01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {

	private int id;
	private String name;
	private int age;
	
	
	public Student() {
		super();
	}
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	public void learn(String name) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICourse course = (ICourse)context.getBean(name);
		course.learn();
	}
}

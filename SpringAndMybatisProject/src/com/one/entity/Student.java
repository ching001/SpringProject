package com.one.entity;

public class Student {

	private int id;
	private String name;
	private int age;
	private Boolean sex;
	private StudentCard card;
	
	public StudentCard getCard() {
		return card;
	}

	public void setCard(StudentCard card) {
		this.card = card;
	}

	public Student() {
	}
	
	public Student(int id, String name, int age, Boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
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


	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		//return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", card=" + card + "]";
	}

	
}

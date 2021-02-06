package com.one.dao.impl;

import org.springframework.stereotype.Repository;

import com.one.dao.IStudentDao;
import com.one.day01.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Override
	public void addStudent(Student student) {
		System.out.println("Dao增加学生...");
		
	}

}

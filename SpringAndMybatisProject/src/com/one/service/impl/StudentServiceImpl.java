package com.one.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.one.dao.IStudentDao;
import com.one.day01.Student;
import com.one.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao;
	
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void addStudent(Student student) {
		System.out.println("service增加学生。。。");
		studentDao = null;
		studentDao.addStudent(student);
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		System.out.println("service删除学生。。。");
		
	}

}

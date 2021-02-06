package com.one.service.impl;

import com.one.entity.Student;
import com.one.mapper.StudentMapper;
import com.one.service.StudentService;

public class StudentServiceImpl implements StudentService {

	//service依赖于dao(mapper)
	private StudentMapper studentMapper;
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}


	@Override
	public Student queryStudentByNo(int stuNo) {
		// TODO Auto-generated method stub
		return studentMapper.queryStudentByNo(stuNo);
	}

}

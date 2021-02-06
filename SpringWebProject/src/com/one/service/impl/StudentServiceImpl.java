package com.one.service.impl;

import com.one.dao.IStudentDao;
import com.one.dao.impl.StudentDaoImpl;
import com.one.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao ;
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String queryNameById() {
		// TODO Auto-generated method stub
		return studentDao.queryNameById();
	}

}

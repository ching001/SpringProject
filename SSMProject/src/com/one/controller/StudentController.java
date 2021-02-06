package com.one.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.entity.Student;
import com.one.service.StudentService;

@Controller
//@RequestMapping("controller")
public class StudentController {

	//控制器依赖于service
	@Autowired
	@Qualifier("studentService") 
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("queryStudentByNo/{stuno}")
	public String queryStudentByNo(@PathVariable("stuno") Integer stuNo,Map<String,Object> map) {
		Student student = studentService.queryStudentByNo(stuNo);
		map.put("student", student);
		return "result";
	}
}

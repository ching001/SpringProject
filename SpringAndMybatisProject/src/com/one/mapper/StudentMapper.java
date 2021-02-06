package com.one.mapper;

import java.util.List;
import java.util.Map;

import com.one.entity.Grade;
import com.one.entity.Student;
import com.one.entity.StudentBusiness;
import com.one.entity.StudentClass;

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
	Student queryStudentById(int id);
	
	Student queryStudentByIdWithConverter(int id);
	//调用存储过程
	void queryCountByAgeWithProcedure(Map<String,Object> params);
	//resultType+HashMap
	List<Map<String,Object>> queryStudentByIdWithHashMap(int id);
	//动态SQL标签 
	List<Student> queryStuByNameOrAgeWithSQLTag(Student student);
	
	//将多个元素值  放入对象的属性中
	List<Student> queryStudentsWithIdInGrade(Grade grade);
	//将多个元素值  放入数组中  int[]
	List<Student> queryStudentsWithArray(int[] stuIds);
	List<Student> queryStudentsWithList(List<Integer> stuIds);
	List<Student> queryStudentsWithObjectArray(Student[] students);
	
	//一对一
	StudentBusiness queryStudentByIdWithOTO(int id);
	Student queryStudentByIdWithOTO2(int id);
	//一对多
	StudentClass queryClassAndStudents(int classid);
	
	
	//一对一   延迟加载
	List<Student> queryStudentWithOTO2Lazyload();
	//一对多   延迟加载
	List<StudentClass> queryAllClassAndStudents();
	
	//查询全部学生
	List<Student> queryAllStudent();
	//增加
	void addStudent(Student student);
	//修改
	void updateStudentById(Student student);
	//删除
	void delStudentById(int id);
	
}

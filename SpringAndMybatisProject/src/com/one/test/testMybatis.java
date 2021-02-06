package com.one.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.one.entity.Grade;
import com.one.entity.Student;
import com.one.entity.StudentBusiness;
import com.one.entity.StudentCard;
import com.one.entity.StudentClass;
import com.one.mapper.StudentMapper;

public class testMybatis {

	public static void main(String[] args) throws IOException {

//		queryStudentById();
//		queryAllStudent();
//		queryStudentByIdWithConverter();

//		queryCountByNameProcedure();
//		queryStudentByIdWithHashMap();
//		queryStuByNameOrAgeWithSQLTag();
//		queryStudentsWithIdInGrade();
//		queryStudentsWithArray();
//		queryStudentsWithList();
//		queryStudentsWithObjectArray();
//		queryStudentByIdWithOTO();
//		queryStudentByIdWithOTO2();
//		queryClassAndStudents();
//		queryStudentWithOTO2Lazyload();
		queryAllClassAndStudents();

//		addStudent();
//		updateStudentById();
//		delStudentById();
//		queryAllStudent();

	}

	//  利用resultMap实现 一对一查询  延迟加载
	public static void queryAllClassAndStudents() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		List<StudentClass> studentClass = studentMapper.queryAllClassAndStudents();
		
		for(StudentClass stuClass:studentClass) {
			System.out.println(stuClass);
			List<Student> students = stuClass.getStudents();
			for(Student student:students) {
				System.out.println(student);
			}
		}
		session.close();
	}
	
	
	//  利用resultMap实现 一对一查询  延迟加载
	public static void queryStudentWithOTO2Lazyload() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		List<Student> students = studentMapper.queryStudentWithOTO2Lazyload();
		for(Student student:students) {
			System.out.println(student);
			StudentCard card = student.getCard();
			System.out.println(card);
		}
		
		session.close();

	}
	
	
	//一對多
	public static void queryClassAndStudents() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		StudentClass students = studentMapper.queryClassAndStudents(1);

		System.out.println(students);
		session.close();

	}
	
	
	//  利用resultMap实现 一对一查询
	public static void queryStudentByIdWithOTO2() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		Student student = studentMapper.queryStudentByIdWithOTO2(2);

		System.out.println(student);
		session.close();

	}

	// 利用业务扩展类实现 一对一查询
	public static void queryStudentByIdWithOTO() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		StudentBusiness student = studentMapper.queryStudentByIdWithOTO(2);

		System.out.println(student);
		session.close();

	}

	// 将多个元素值 放入数组中 int[]
	public static void queryStudentsWithObjectArray() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student stu1 = new Student();
		stu1.setId(1);
		Student stu3 = new Student();
		stu3.setId(3);
		Student stu4 = new Student();
		stu4.setId(4);
		Student[] stuIds = { stu1, stu3, stu4 };
		List<Student> students = studentMapper.queryStudentsWithObjectArray(stuIds);

		System.out.println(students);
		session.close();

	}

	// 将多个元素值 放入数组中 int[]
	public static void queryStudentsWithList() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Integer> stuIds = new ArrayList<>();
		stuIds.add(2);
		stuIds.add(4);
		List<Student> students = studentMapper.queryStudentsWithList(stuIds);

		System.out.println(students);
		session.close();

	}

	// 将多个元素值 放入数组中 int[]
	public static void queryStudentsWithArray() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		int[] stuIds = { 2, 4 };

		List<Student> students = studentMapper.queryStudentsWithArray(stuIds);

		System.out.println(students);
		session.close();

	}

	// 将多个元素值 放入对象的属性中
	public static void queryStudentsWithIdInGrade() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Grade grade = new Grade();
		List<Integer> stuIds = new ArrayList();
		stuIds.add(2);
//		stuIds.add(3);
		stuIds.add(4);
		grade.setStuIds(stuIds);

		List<Student> students = studentMapper.queryStudentsWithIdInGrade(grade);

		System.out.println(students);
		session.close();

	}

	// 动态SQL标签
	public static void queryStuByNameOrAgeWithSQLTag() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student stu = new Student();
//		stu.setName("zs");
		stu.setAge(23);
		List<Student> students = studentMapper.queryStuByNameOrAgeWithSQLTag(stu);

		System.out.println(students);
		session.close();

	}

	// resultType+HashMap
	public static void queryStudentByIdWithHashMap() throws IOException {
		// 加载Mybatis配置文件(为了访问数据库)
		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Map<String, Object>> students = studentMapper.queryStudentByIdWithHashMap(1);

		System.out.println(students);
		session.close();

	}

	// 调用存储过程
	public static void queryCountByNameProcedure() throws IOException {
		// 加载Mybatis配置文件(为了访问数据库)
		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		Map<String, Object> params = new HashMap();
		params.put("age", 23);

		studentMapper.queryCountByAgeWithProcedure(params);// 接口中的方法-》SQL语句
		Object count = params.get("scount");

		System.out.println(count);
		session.close();

	}

	// 查询单个学生(转换器)
	public static void queryStudentByIdWithConverter() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		// 1
//			String statement = "com.one.mapper.studentMapper.queryStudentById";
//			Student student = session.selectOne(statement, 1);

		// 2
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = studentMapper.queryStudentByIdWithConverter(1);// 接口中的方法-》SQL语句

		System.out.println(student);
		session.close();

	}

	// 查询单个学生
	public static void queryStudentById() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");
		// 可通过build的第二个参数指定数据库环境
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		// 1
//		String statement = "com.one.mapper.studentMapper.queryStudentById";
//		Student student = session.selectOne(statement, 1);

		// 2
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = studentMapper.queryStudentById(1);// 接口中的方法-》SQL语句

		System.out.println(student);
		session.close();

	}

	// 查询全部学生
	public static void queryAllStudent() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

//		String statement = "com.one.mapper.studentMapper.queryAllStudent";
//		List<Student> students = session.selectList(statement);

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.queryAllStudent();

		System.out.println(students);

		session.close();

	}

	// 增加学生
	public static void addStudent() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

//		String statement = "com.one.mapper.studentMapper.addStudent";
//		Student student = new Student(2,"ls",24);
		Student student = new Student(3, "ww", 25, true);
//		int count = session.insert(statement, student);

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.addStudent(student);

		session.commit();// 提交事务
		System.out.println("增加成功");

		session.close();

	}

	// 修改学生
	public static void updateStudentById() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

//		String statement = "com.one.mapper.studentMapper.updateStudentById";
		Student student = new Student();
		student.setId(2);
		student.setName("ls");
		student.setAge(24);
//		int count = session.update(statement, student);

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.updateStudentById(student);

		session.commit();
		System.out.println("修改成功");

		session.close();

	}

	// 删除学生
	public static void delStudentById() throws IOException {

		Reader reader = Resources.getResourceAsReader("config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

//		String statement = "com.one.mapper.studentMapper.delStudentById";
//		int count = session.delete(statement, 3);

		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.delStudentById(3);

		session.commit();
		System.out.println("删除成功");

		session.close();

	}

}

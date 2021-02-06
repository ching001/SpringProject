//package com.one.servlet;
//package com.one.controller;
//package com.one.action;
package com.one.handler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.one.entity.Address;
import com.one.entity.Student;

//接口/类 注解 配置
//@SessionAttributes("student")
//@SessionAttributes(types= {Student.class,Address.class})
@Controller
public class SpringMvcHandler {

	@RequestMapping("hello")
	public String hello() {
		return "success";
	}
	
	
	@RequestMapping(value="testPost/{id}",method=RequestMethod.POST)
	public String testPost(@PathVariable("id") Integer id) {
		System.out.println("增加  :"+id);
		return "success";
	}
	@RequestMapping(value="testDelete/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable("id") Integer id) {
		System.out.println("删除  :"+id);
		return "success";
	}
	@RequestMapping(value="testPut/{id}",method=RequestMethod.PUT)
	public String testPut(@PathVariable("id") Integer id) {
		System.out.println("修改  :"+id);
		return "success";
	}
	@RequestMapping(value="testGet/{id}",method=RequestMethod.GET)
	public String testGet(@PathVariable("id") Integer id) {
		System.out.println("查询  :"+id);
		return "success";
	}
	
	
	@RequestMapping("testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept") String a) {
		System.out.println(a);
		return "success";
	}
	@RequestMapping("testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionid) {
		System.out.println(sessionid);
		return "success";
	}
	
	
	@RequestMapping("testObjectProperties")
	public String testObjectProperties(Student student) {
		System.out.println(student);
		return "success";
	}
	
	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mv = new ModelAndView("success");
		Student student = new Student();
		student.setId(1);
		student.setName("zs");
		mv.addObject("student",student);
		return mv;
	}
	@RequestMapping("testModelMap")
	public String testModelMap(ModelMap m) {
		Student student = new Student();
		student.setId(2);
		student.setName("ls");
		m.put("student", student);//request域
		return "success";
	}
	@RequestMapping("testModel")
	public String testModel(Model m) {
		ModelAndView mv = new ModelAndView("success");
		Student student = new Student();
		student.setId(3);
		student.setName("ww");
		m.addAttribute("student", student);
		return "success";
	}
	@RequestMapping("testMap")
	public String testMap(Map<String,Object> m) {
		ModelAndView mv = new ModelAndView("success");
		Student student = new Student();
		student.setId(4);
		student.setName("zl");
		m.put("student", student);//request域
		//forward     redirect
		return "redirect:/views/success.jsp";
	}
	
	@ModelAttribute//在任何一次请求前，都会先执行@ModelAttribute修饰的方法
	public void queryStudentById(Map<String,Object> map) {
		Student student = new Student();
		student.setId(23);
		student.setName("zs");
		student.setAge(33);
//		map.put("student", student);//约定：map的key就是方法参数类型的首字母小写
		map.put("stu", student);
	}
	//修改
	@RequestMapping("testModelAttributes")
	public String testModelAttributes(@ModelAttribute("stu")Student student) {
		student.setName(student.getName());
		System.out.println(student);
		return "success";
	}
	
	@RequestMapping("testI18n")
	public String testI18n() {
		return "success";
	}
	
	@RequestMapping("testConverter")
	public String testConverter(@RequestParam("studentInfo") Student student) {
		System.out.println(student);
		return "success";
	}
	
	
	@RequestMapping("testDateTimeFormat")//如果Student格式化出错，会将错误信息传入result中
	//BindingResult必须放在校验的对象的后面，中间不能有其它参数
	public String testDateTimeFormat(@Valid Student student, BindingResult result,Map<String,Object> map) {
		System.out.println(student);
		if(result.getErrorCount()>0) {
			for(FieldError error:result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
				map.put("errors", result.getFieldErrors());
			}
		}
		return "success";
	}
	
	
	@RequestMapping("testJson")
	@ResponseBody//告诉springmvc 此时的返回 不是一个View页面，而是一个Ajax调用的返回值（json数组）
	public List<Student> testJson() {
		//controller->service->dao
		//List<Student> studnets = studentService.queryAllStudnet();
		Student stu1 = new Student(1,"zs",23);
		Student stu2 = new Student(2,"ls",24);
		Student stu3 = new Student(3,"ww",25);
		List<Student> students = new ArrayList<>();
		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		
		return students;
	}
	
	@RequestMapping("testUpload")
	public String testUpload(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file) throws Exception {
		System.out.println("描述信息："+desc);
		InputStream input = file.getInputStream();
		String filename = file.getOriginalFilename();
		OutputStream out = new FileOutputStream("d:\\"+filename);
		byte[] bs = new byte[1024];
		int len = -1;
		while((len = input.read(bs)) != -1) {
			out.write(bs, 0, len);
		}
		out.close();
		input.close();
		System.out.println("上传成功！");
		return "success";
	}
	
	@RequestMapping("testInterceptor")
	public String testInterceptor() {
		System.out.println("处理请求的方法！！！");
		return "success";
	}
	
	
	
}

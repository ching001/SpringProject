package com.one.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.one.service.IStudentService;
import com.one.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryNameByIdServlet
 */
public class QueryNameByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentService studentService ;
    public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

    //servlet初始化方法：在初始化时，获取springioc容器中的bean对象
    @Override
    public void init() throws ServletException {
//    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Service.xml");
    	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    	//当前是在servlet容器中，通过getBean获取ioc容器中的Bean
    	studentService = (IStudentService)context.getBean("studentService");
    }
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public QueryNameByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = studentService.queryNameById();
		System.out.println("------------------------"+name);
		request.setAttribute("name", name);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

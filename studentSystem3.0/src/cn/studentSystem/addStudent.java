package cn.studentSystem;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.web.db.StudentDB;
import com.ittx.web.db.bean.Student;

public class addStudent extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDB studentdb = StudentDB.getInstance();
		request.setCharacterEncoding("UTF-8");//解决post请求乱码
		response.setContentType("text/html;charset=utf-8");//设置响应编码
		System.out.println("LoginServlet 请求成功！");
		
		
		String userNumber=request.getParameter("userNumber");
		String name=request.getParameter("userName");
		String userAge=request.getParameter("userAge");
		String userSex=request.getParameter("userSex");
		
		int number=Integer.parseInt(userNumber);
		int age=Integer.parseInt(userAge);
		boolean sex=Boolean.parseBoolean(userSex);
		
		Student stu=new Student(name,number,age,sex);
		studentdb.addStudent(stu);
		response.sendRedirect("showStudent.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}




































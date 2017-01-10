package cn.studentSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.web.db.StudentDB;
import com.ittx.web.db.bean.Student;

public class updateStudent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决post请求乱码
		response.setContentType("text/html;charset=utf-8");//设置响应编码
		
		String Number=request.getParameter("userNumber");
		String userName=request.getParameter("userName");
		String Age=request.getParameter("userAge");
		String Sex=request.getParameter("userSex");
		
		int num=Integer.parseInt(Number);
		int age=Integer.parseInt(Age);
		boolean sex=Boolean.parseBoolean(Sex);
		Student student=new Student(userName,num,age,sex);
		StudentDB.getInstance().updateStudent(student);
		response.sendRedirect(request.getContextPath()+"/showStudent.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

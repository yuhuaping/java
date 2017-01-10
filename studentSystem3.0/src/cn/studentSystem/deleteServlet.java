package cn.studentSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.web.db.StudentDB;

public class deleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决post请求乱码
		response.setContentType("text/html;charset=utf-8");//设置响应编码
		String number=request.getParameter("num");
		StudentDB.getInstance().deleteStudent(Integer.parseInt(number));
		//getContextPath获取路径，sendRedirect从servlet程序中跳转到jsp页面
		response.sendRedirect(request.getContextPath()+"/showStudent.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.shinhan4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/empdelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// punlic service() => protected service() => doGet(), doPost() 순으로 실행
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET, POST 방식 둘 다 수행
		System.out.println("요청 방식 : " + request.getMethod());
		
		int emp_id = Integer.parseInt(request.getParameter("empid"));
		
		EmpService empService = new EmpService();
		int result = empService.deleteService(emp_id);
		
		if (result == 1) {
			System.out.println(emp_id + "번 직원 삭제 성공!");
		} else {		
			System.out.println(emp_id + "번 직원 삭제 실패!");
		}
		
		response.sendRedirect("jsp/emp/emplist.do");
		System.out.println("==============================");
	}

}

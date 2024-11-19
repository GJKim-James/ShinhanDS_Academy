package com.shinhan4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptService;

@WebServlet("/deptdelete.do")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_deptid = request.getParameter("deptid");
		int dept_id = 0;
		if (str_deptid != null) {
			dept_id = Integer.parseInt(str_deptid);
		}
		
		DeptService deptService = new DeptService();
		int result = deptService.delete(dept_id);
		
		if (result == 1) {
			System.out.println(dept_id + "번 부서 삭제 성공!");
		} else {		
			System.out.println(dept_id + "번 부서 삭제 실패!");
		}
		
		response.sendRedirect("deptselect.do");
	}

}

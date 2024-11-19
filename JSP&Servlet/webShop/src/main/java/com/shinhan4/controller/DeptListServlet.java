package com.shinhan4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;

@WebServlet("/deptlist.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService deptService = new DeptService();
		List<DeptDTO> deptList = deptService.selectAll();
		System.out.println(request.getRemoteAddr() + " 접속, " + deptList.size() + "건 조회됨.");
		
		request.setAttribute("deptDatas", deptList);
		request.getRequestDispatcher("jsp/dept/deptList.jsp").forward(request, response);
	}

}

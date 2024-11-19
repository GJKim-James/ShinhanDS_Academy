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

@WebServlet("/deptdetail.do")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("http://localhost:9090/webShop/deptdetail.do GET 요청");
		
		int dept_id = Integer.parseInt(request.getParameter("deptid"));
		
		DeptService deptService = new DeptService();
		DeptDTO deptDTO = deptService.selectById(dept_id);
		request.setAttribute("deptDTO", deptDTO);
		
		List<DeptDTO> deptList = deptService.selectAll();
		request.setAttribute("deptList", deptList);
		
		request.getRequestDispatcher("jsp/dept/deptDetail.jsp").forward(request, response);
		System.out.println("==================================================");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		String dept_name = request.getParameter("dept_name");
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		int location_id = Integer.parseInt(request.getParameter("location_id"));
		System.out.println("========== form 태그로부터 받은 수정된 정보 ==========");
		System.out.println("dept_id : " + dept_id);
		System.out.println("dept_name : " + dept_name);
		System.out.println("manager_id : " + manager_id);
		System.out.println("location_id : " + location_id);
		System.out.println("================================================");
		
		DeptDTO deptDTO = new DeptDTO().builder()
				.dept_id(dept_id)
				.dept_name(dept_name)
				.manager_id(manager_id)
				.location_id(location_id)
				.build();
		
		DeptService deptService = new DeptService();
		int result = deptService.update(deptDTO);
		
		System.out.println(result + "건 수정");
		
		response.sendRedirect("deptlist.do");
		System.out.println("==============================");
	}

}

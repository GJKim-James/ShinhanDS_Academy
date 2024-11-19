package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;

@WebServlet("/deptinsert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deptinsert.do GET 요청");
		
		// 위임(받은 요청을 전달)
		RequestDispatcher rd = request.getRequestDispatcher("jsp/dept/deptInsert.jsp"); // webapp/jsp/dept/deptInsert.jsp
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deptinsert.do POST 요청");
		
		// 한글 인코딩(POST 방식은 parameter가 URI로 오지 않고, 요청 문서의 body에 인코딩되지 않은 상태로 포함되어 온다.)
		request.setCharacterEncoding("UTF-8");
		
		// deptinsert.jsp에서 form 태그의 name 값 받아오기
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		String department_name = request.getParameter("department_name");
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		int location_id = Integer.parseInt(request.getParameter("location_id"));
		System.out.println("========== form 태그로부터 받은 정보 ==========");
		System.out.println("department_id : " + department_id);
		System.out.println("department_name : " + department_name);
		System.out.println("manager_id : " + manager_id);
		System.out.println("location_id : " + location_id);
		String hiddenTag = request.getParameter("phone_number");
		System.out.println("hiddenTag : " + hiddenTag); // hidden 태그 값 넘어온다.
		System.out.println("==========================================");
		
		DeptDTO deptDTO = new DeptDTO().builder()
				.dept_id(department_id)
				.dept_name(department_name)
				.manager_id(manager_id)
				.location_id(location_id)
				.build();
//		deptDTO.setDept_id(department_id);
//		deptDTO.setDept_name(department_name);
//		deptDTO.setManager_id(manager_id);
//		deptDTO.setLocation_id(location_id);
		
		DeptService deptService = new DeptService();
		int result = deptService.insert(deptDTO);
		
		String message = "";
		if (result == 1) {
			message = "부서 등록 성공";
		} else {
			message = "부서 등록 실패";
		}
		
		System.out.println("---------- jsp/dept/result.jsp로 응답 위임 ----------");
		request.setAttribute("resultMessage", message); // resultMessage는 result.jsp에서 ${resultMessage}로 사용
		RequestDispatcher rd = request.getRequestDispatcher("jsp/dept/result.jsp");
		rd.forward(request, response);
	}

}

package com.shinhan4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;

/**
 * Servlet implementation class EmpListServlet
 * Servlet : 사용자의 요청을 받아서 처리 가능한 서버에서 실행되는 자바 클래스
 */
@WebServlet("/jsp/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService empService = new EmpService();
		List<EmpDTO> empList = empService.selectAllService();
		System.out.println(empList.size() + "건");
		
		// request 영역에 empDatas 이름으로 empList 정보를 저장
		request.setAttribute("empDatas", empList);
		
		// 위임하기(Browser 요청 ==> Servlet; 로직 수행 후 ==> 응답은 JSP로 넘기기)
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("<h1>직원 목록</h1>");
//		for (EmpDTO emp : empList) {
//			out.print("<p>" + emp + "</p>");
//		}
	}

}

package com.shinhan4.controller2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bind1.go")
public class BindingTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		
		String aa = "local 변수";
		request.setAttribute("myName", "request 영역에 저장");
		session.setAttribute("myName2", "session 영역에 저장"); // 브라우저 닫을 시 사라짐
		application.setAttribute("myName3", "ServletContext 영역에 저장"); // 서버 Stop 시 사라짐
		
		// 지정한 path에 해당되는 실제 경로를 반환
		String realPath = application.getRealPath("/auth/login.jsp");
//		String realPath = application.getRealPath(".");
		System.out.println("realPath : " + realPath);
		
		// 다른 페이지로 이동
		request.getRequestDispatcher("jsp/bind/bind1.jsp").forward(request, response);
	}

}

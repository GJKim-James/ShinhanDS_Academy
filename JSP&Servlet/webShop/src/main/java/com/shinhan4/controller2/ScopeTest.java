package com.shinhan4.controller2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeTest
 */
@WebServlet("/jsp/scope")
public class ScopeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * "company"로 같은 이름일 경우 작성된 순서대로 찾는다; request 영역 > session 영역 > application(context) 영역
		 * 
		 * 특정 영역에서 찾고 싶다면 아래와 같이 접근하면 된다.
		 * 1. ${company}
		 * 2. ${requestScope.company}
		 * 3. ${sessionScope.company}
		 * 4. ${applicationScope.company}
		 */
		// 1. request가 유효한 동안 존재(request ==> response ==> 소멸)
		request.setAttribute("company", "신한DS");
		
		// 2. 브라우저 최초 접속 시 세션 생성(세션ID가 브라우저에 쿠키로 저장됨)
		// 쿠키에서 세션ID를 삭제하거나 로그아웃하면 세션 소멸
		HttpSession session = request.getSession();
		session.setAttribute("company", "기업은행");
		
		// 3. 서버 시작 시 생성, 서버 종료 시 소멸
		ServletContext context = getServletContext();
		context.setAttribute("company", "국민은행");
		
		// 요청 전달됨
		request.getRequestDispatcher("scopeTest.jsp").forward(request, response);
		
		// 요청이 전달되지 않음
		response.getWriter().append("<h1>ScopeTest setting</h1>");
	}

}

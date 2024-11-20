package com.shinhan4.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.member.MemberDTO;
import com.firstzone.member.MemberService;

/**
 * default 경로 : http://localhost:9090/webShop
 * 
 * URL 패턴 : 1. 이름까지 일치하는 경우 @WebServlet("/login.do")
 * 			 2. 디렉토리까지만 일치하는 경우 @WebServlet("/*")
 * 			 3. 확장자만 일치하는 경우 @WebServlet("*.do")
 * 			 4. 모든 요청 @WebServlet("/*")
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청");
		
		System.out.println("contextPath : " + request.getContextPath()); // /webShop
		System.out.println("URL : " + request.getRequestURL().toString()); // http://localhost:9090/webShop/login.do
		System.out.println("URI : " + request.getRequestURI()); // /webShop/login.do
		System.out.println("servletPath : " + request.getServletPath()); // /login.do
		System.out.println("URL ? 뒤 파라미터 출력 : " + request.getQueryString());
		
		// 위임(받은 요청을 전달)
		// forward() : 주소창은 http://127.0.0.1:9090/webShop/jsp/auth/login.do로 변하지 않고, 보여지는 내용만 login.jsp로 변함.
		RequestDispatcher rd = request.getRequestDispatcher("jsp/auth/login.jsp"); // webapp/jsp/auth/login.jsp
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청");
		
		// 한글 인코딩(2024. 11. 20 필터로 작성)
//		request.setCharacterEncoding("UTF-8");
		
		// login.jsp에서 form 태그의 name이 userid인 값 받아오기
		String user_id = request.getParameter("userid");
		String user_pw = request.getParameter("userpw");

		String food = request.getParameter("food"); // 값 1개; getParameter()
		System.out.println("food : " + food);
		
		String[] food2 = request.getParameterValues("food2"); // 값이 여러 개; getParameterValues()
		System.out.println("food2 : " + Arrays.toString(food2));
		System.out.println("------------------------------");
		
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			
			if (name.equals("food2")) {
				String[] arr = request.getParameterValues(name); // 값이 여러 개; getParameterValues()
				System.out.println("arr : " + Arrays.toString(arr));
			} else {
				String value = request.getParameter(name); // 값 1개; getParameter()
				System.out.println("value : " + value);
			}
		}
		System.out.println("------------------------------");
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			String[] arr2 = request.getParameterValues(key);
			System.out.println("arr2 : " + Arrays.toString(arr2));
		}
		
		MemberService memberService = new MemberService();
		MemberDTO memberDTO = memberService.loginService(user_id, user_pw);
		String message = "";
		if (memberDTO == null) {
			message = URLEncoder.encode("아이디가 존재하지 않습니다.", "UTF-8");
			response.sendRedirect("login.do?message=" + message);
			return;
		} else if (memberDTO.getMember_id().equals("-1")) {
			message = URLEncoder.encode("비밀번호가 잘못되었습니다.", "UTF-8");
			response.sendRedirect("login.do?message=" + message);
			return;
		}
		
		message = memberDTO.getMember_name() + "님 환영합니다.";
		
		// 로그인 성공 시 로그인한 Member 저장
		// 1. Context에 저장
		ServletContext app = getServletContext();
		app.setAttribute("loginMember3", memberDTO);
		
		// 2. Session에 저장
		HttpSession session = request.getSession();
		session.setAttribute("loginMember2", memberDTO);
		session.setAttribute("loginMember", memberDTO);
		
		// 3. Request에 저장
		request.setAttribute("loginMember", memberDTO);
		
		// 4. Cookie에 저장
		Cookie cookie_id = new Cookie("loginId", memberDTO.getMember_id());
		Cookie cookie_name = new Cookie("loginName", memberDTO.getMember_name());
		Cookie cookie_email = new Cookie("loginEmail", memberDTO.getMember_email());
		
		response.addCookie(cookie_id);
		response.addCookie(cookie_name);
		response.addCookie(cookie_email);
		
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().append("<h1>" + message + "</h1>");
		request.setAttribute("resultMessage", message); // resultMessage는 result.jsp에서 ${resultMessage}로 사용
		RequestDispatcher rd = request.getRequestDispatcher("jsp/auth/result.jsp"); // webapp/jsp/auth/login.jsp
		rd.forward(request, response);
	}

}

package com.shinhan4.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.member.MemberDTO;
import com.firstzone.member.MemberService;

@WebServlet("/session/set")
public class SetSessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 있으면 얻고 없으면 새로 생성
		HttpSession session = request.getSession(true);
		
		MemberService memberService = new MemberService();
		MemberDTO memberDTO = memberService.loginService("gjk0635", "1234");
		session.setAttribute("memberDTO", memberDTO);
		
		System.out.println("isNew(최초 생성된 세션인지 판별)? : " + session.isNew());
		System.out.println("id(생성된 세션 객체의 id)? : " + session.getId());
		System.out.println("CreationTime(최초 세션 객체 생성 시간)? : " + session.getCreationTime());
		System.out.println("LastAccessedTime(세션 객체에 최근에 접근한 시간)? : " + session.getLastAccessedTime());
		System.out.println("MaxInactiveInterval(세션 객체의 유효 시간)? : " + session.getMaxInactiveInterval());
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>세션 저장 완료</h1>");
	}

}

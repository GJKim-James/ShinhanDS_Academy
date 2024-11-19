package com.shinhan4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet : 사용자의 요청을 받아서 처리 가능한 서버에서 실행되는 자바 클래스
 * HttpServlet : http 프로토콜 처리 가능
 * @WebServlet : 사용자의 요청 주소 정의; 반드시 /로 시작
 * 
 * https://www.gsshop.com/shop/tv/tvProductMain.gs?lseq=426651&cate_link=900
 */
@WebServlet("/tv/tvProductMain.gs")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ReviewServlet() {
        System.out.println("ReviewServlet 생성자; 1회만 실행");
    }

	@Override
	public void init() throws ServletException {
		System.out.println("ReviewServlet init; 초기화 작업, 1회만 실행");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReviewServlet doGet() 요청 시마다 실행");
		
		// 요청 정보(request)
		System.out.println("요청 방식 : " + request.getMethod());
		System.out.println("Context Path : " + request.getContextPath());
		System.out.println("Client IP 주소 : " + request.getRemoteAddr());
		
		// 응답 정보(response)
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>환영합니다.</h1>")
							.append("<h2>당신의 IP는 " + request.getRemoteAddr() + "</h2>")
							.append("<h2>서버의 IP는 " + request.getLocalAddr() + "</h2>")
							.append("<h2>서버의 이름은 " + request.getLocalName() + "</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReviewServlet doPost() 요청 시마다 실행");
	}

}

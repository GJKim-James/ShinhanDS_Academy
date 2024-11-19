package com.shinhan4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 * Servlet : 클라이언트의 요청을 받아서 처리 가능한 자바 서버 프로그램; Java + HTML 가능(권장 안함)
 * HttpServlet : HTTP 프로토콜에서 실행 가능한 서블릿
 * 요청 : http://localhost:9090/webShop/first => @WebServlet("/first") 수행
 * 
 * Servlet의 메소드들은 callback이다. 개발자가 정의, WAS(Web Application Server)가 호출한다.
 * 최초 요청 시 생성자(), init() 실행됨.
 * 요청에 따라 get 방식이면 doGet(), post 방식이면 doPost() 실행됨.
 * 
 * Web Browswer 요청(request) ==> Web 서버 ==> WAS(Tomcat 서버) ==> response ==> Web Browser
 * 
 * 기본 경로(절대 경로) ./ => http://localhost:9090/webShop
 */
@WebServlet({"/first", "/first2"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        System.out.println("FirstServlet 생성자; 최초 요청 시 1회 생성됨.");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("FirstServlet init; 초기화, 최초 요청 시 1회 실행됨.");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("FirstServlet destroy; 서버 중지 시 실행됨.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Get 요청 시마다 발생." + request.getRemoteAddr()); // 누가 요청했는지 확인
		
		getResponse(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("Post 요청 시마다 발생." + request.getRemoteAddr());
		
		getResponse(request, response);
	}
	
	private void getResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 한글 인코딩
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		// 응답(response) 문서 만들기
		PrintWriter out = response.getWriter();
		out.print("<h1>get 요청에 대한 응답</h1>");
		out.print("<hr>");
		out.print("<p>getLocalAddr : " + request.getLocalAddr() + "</p>");
		out.print("<p>getLocalName : " + request.getLocalName() + "</p>");
		out.print("<p>RemoteAddr : " + request.getRemoteAddr() + "</p>");
		out.print("<p>getRemoteHost : " + request.getRemoteHost() + "</p>");
	}

}

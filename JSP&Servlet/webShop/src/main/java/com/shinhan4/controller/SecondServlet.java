package com.shinhan4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 * 
 * HTML, JSP에서 절대 경로? http://localhost:9090
 * Servlet에서 절대 경로? http://localhost:9090/webShop
 * 현재 경로? http://localhost:9090/webShop/jsp/second
 */
//@WebServlet("/jsp/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getContextPath() : " + request.getContextPath());
		
		// 위임하기(Browser 요청 ==> Servlet; 로직 수행 후 ==> 응답은 JSP로 넘기기)
		RequestDispatcher rd = request.getRequestDispatcher("second.jsp"); // http://localhost:9090/webShop/jsp/second
//		RequestDispatcher rd = request.getRequestDispatcher("/second.jsp"); // http://localhost:9090/webShop/second
		rd.forward(request, response);
	}

}

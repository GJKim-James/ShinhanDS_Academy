package com.shinhan4.controller2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig : Servlet 마다 존재
 */
//@WebServlet(urlPatterns = {"/ServletContextTest", "/servlet/config"},
//			initParams = {@WebInitParam(name = "email", value = "gjk@naver.com")})
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ServletContext의 매개변수 설정 기능
		ServletContext app = getServletContext(); // web.xml에 <context-param> 정보 가져올 수 있음.
		
		String id = app.getInitParameter("username");
		String pw = app.getInitParameter("userpw");
		
		System.out.println("id : " + id + ", pw : " + pw);
		
		// ServletContext의 파일 입출력 기능
		// 실행 환경 default : http://localhost:9090/webShop
		// 개발 환경 default : src/webapp
		InputStream is = app.getResourceAsStream("/WEB-INF/resource/menu.txt");
		
		// InputStream은 1byte 단위 처리, InputStreamReader는 2byte 단위 처리
		// BufferedReader는 한 줄(line) 읽기 가능
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		// Servlet 접근
		String email = getInitParameter("email");
		System.out.println("email : " + email);
	}

}

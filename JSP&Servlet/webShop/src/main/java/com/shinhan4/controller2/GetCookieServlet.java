package com.shinhan4.controller2;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/get")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] arrCookie = request.getCookies();
		
		for (Cookie cookie : arrCookie) {
			String cookieName = cookie.getName();
			String cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
			System.out.println(cookieName + " : " + cookieValue);
			System.out.println("------------------------------");
		}
	}

}

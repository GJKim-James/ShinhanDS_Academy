package com.shinhan4.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class TimerFilter extends HttpFilter implements Filter {

    public TimerFilter() {
    	System.out.println("서버 시작; TimerFilter 생성");
    }

	public void destroy() {
		System.out.println("서버 종료; TimerFilter 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		long start = System.currentTimeMillis();
		long start = System.nanoTime();
		// 요청 필터
		chain.doFilter(request, response);
		// 응답 필터
		long end = System.nanoTime();
		
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.print(req.getRequestURI() + " 요청");
		System.out.println(" 작업 시간 : " + (end - start) + "ns");
	}

}

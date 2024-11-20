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

@WebFilter("*.do")
public class EncodingFilter extends HttpFilter implements Filter {
	
    public EncodingFilter() {
    	System.out.println("서버 시작; EncodingFilter 생성");
    }
    
	public void destroy() {
		System.out.println("서버 종료; EncodingFilter 소멸");
	}

	/**
	 * *.do 요청 시마다 수행
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ----- 서블릿 요청 전
		System.out.println("==================== 서블릿 요청 전 ====================");
		
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response); // 다른 필터를 수행하거나 서블릿을 수행하러 간다.
		
		// ----- 서블릿 수행 후 응답하러 가기 전
		System.out.println("=============== 서블릿 요청 후 응답하기 전 ===============");
	}

}

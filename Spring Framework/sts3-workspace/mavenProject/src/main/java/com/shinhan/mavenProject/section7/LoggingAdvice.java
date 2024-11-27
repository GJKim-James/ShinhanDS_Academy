package com.shinhan.mavenProject.section7;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 보조업무(로그 남기기)
public class LoggingAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 주업무 수행 전
		System.out.println("[메서드 호출 전 : LogginAdvice]");
		System.out.println(invocation.getMethod() + "메서드 호출 전");

		// 주업무를 수행한다.
		Object object = invocation.proceed();

		// 주업무 수행 후 돌아와서 수행한다.
		System.out.println("[메서드 호출 후 : loggingAdvice]");
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		
		// 주업무 수행 결과 리턴(필수)
		return object;
	}
}

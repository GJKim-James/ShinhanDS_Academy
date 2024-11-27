package com.shinhan.mavenProject.section7;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

// 보조업무(시간 계산)
public class StopWatchAdvice implements MethodInterceptor {
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 보조업무(주업무 전)
		System.out.println("******" + invocation.getMethod() + "메서드 호출 전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();
		
		// 주업무를 수행한다.
		Object object = invocation.proceed();
		
		// 보조업무(주업무 후)
		System.out.println("*****" + invocation.getMethod() + "메서드 호출 후");
		watch.stop();
		System.out.println("주업무 수행 시간:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		
		// 주업무 수행 결과 리턴(필수)
		return object;
	}

}

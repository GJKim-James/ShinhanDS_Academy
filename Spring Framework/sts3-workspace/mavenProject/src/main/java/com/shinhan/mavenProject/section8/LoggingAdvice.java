package com.shinhan.mavenProject.section8;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// @Aspect : PointCut + Advice; 보조업무(로그 남기기)
@Component // <bean id="LoggingAdvice" class="com.shinhan.mavenProject.section7.LoggingAdvice" />
@Aspect
public class LoggingAdvice {
	@Pointcut("execution(* add*(int)) || execution(* add(int, int))")
	public void targetMethod2() {
		// 로직 없음
	}
	
	// DeptService의 모든 메소드 실행 시 로그가 보여지도록 Pointcut 작성
	@Pointcut("within(com.shinhan.mavenProject.section8.DeptService)")
	public void deptServiceLogging() {}
	
	@Before("targetMethod2()")
	public void beforeMethod() {
		System.out.println("---------- @Before LoggingAdvice ----------");
	}
	
	@After("targetMethod2()")
	public void afterMethod() {
		System.out.println("---------- @After LoggingAdvice ----------");
	}
	
	@AfterReturning("targetMethod2()")
	public void afterReturningMethod() {
		System.out.println("---------- @AfterReturning LoggingAdvice ----------");
	}
	
	@AfterThrowing("targetMethod2()")
	public void afterThrowing() {
		System.out.println("---------- @AfterThrowing LoggingAdvice ----------");
	}
	
	
	@Around("targetMethod2()") // 주로 사용
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("[메서드 호출 전 : LogginAdvice]");
		System.out.println(jp.getSignature().getName() + "메서드 호출 전");

		// 주업무를 수행한다.
		Object object = jp.proceed();

		// 주업무 수행 후 돌아와서 수행한다.
		System.out.println("[메서드 호출 후 : loggingAdvice]");
		System.out.println(jp.getSignature().getName() + "메서드 호출 후");
		
		// 주업무 수행 결과 리턴(필수)
		return object;
	}
	
	@Around("deptServiceLogging()")
	public Object aroundDeptService(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("[Before] 호출된 함수 이름 : " + jp.getSignature().getName());

		// 주업무를 수행한다.
		Object object = jp.proceed();

		// 주업무 수행 후 돌아와서 수행한다.
		System.out.println("[After] 호출된 함수 이름 : " + jp.getSignature().getName());
		
		// 주업무 수행 결과 리턴(필수)
		return object;
	}
}

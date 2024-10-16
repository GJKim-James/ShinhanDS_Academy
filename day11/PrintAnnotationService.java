package com.shinhan.day11;

public class PrintAnnotationService {
	@PrintAnnotation
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	// value 속성은 생략 가능
	@PrintAnnotation("#")
	public void method2() {
		System.out.println("실행 내용2");
	}
	
	@PrintAnnotation(value = "@", number = 10)
	public void method3() {
		System.out.println("실행 내용3");
	}
}

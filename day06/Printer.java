package com.shinhan.day06;

public class Printer {
	
	// method : 행위, 기능; 필수 구성 요소 : ReturnType, 함수이름() { }
	// { } : 구현됨
	// non-static : instance method, 객체 생성 후 호출 가능
	void println(int param) {
		System.out.println(param);
	}
	
	void println(String param) {
		System.out.println(param);
	}
	
	void println(boolean param) {
		System.out.println(param);
	}
	
	// static : class method, 객체 생성 불필요
	static void println2(int param) {
		System.out.println(param);
	}
	
	static void println2(String param) {
		System.out.println(param);
	}
	
	static void println2(boolean param) {
		System.out.println(param);
	}

}

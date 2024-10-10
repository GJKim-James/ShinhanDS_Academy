package com.shinhan.day08.exercise;

// 8장 확인문제 8번
public class ABCExample {

	public static void main(String[] args) {
		action(new B());
		action(new C());
	}

	private static void action(A a) {
		a.method1();
		
		// 매개값이 C 객체일 경우에만 method2() 호출
		if (a instanceof C c) {
			c.method2();
		}
	}

}

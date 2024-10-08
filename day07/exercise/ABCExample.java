package com.shinhan.day07.exercise;

// 7장 확인문제 12번
public class ABCExample {
	
	public static void main(String[] args) {
		action(new A());
		action(new B());
		action(new C());
	}
	
	public static void action(A a) {
		// 메서드는 Override 된 것이 수행된다. (C 클래스의 method1() 실행)
		a.method1();
		
		if (a instanceof C c) {
//			C c = (C) a;
			c.method2();
		}
	}

}

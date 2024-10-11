package com.shinhan.day09.inner;

public class A2 {

	// 1. field
	B field1 = new B();

	// 2. 생성자
	A2() {
		System.out.println(B.field2);
		B.method2();

		B field2 = new B();
		System.out.println(field2.field);
		field2.method1();
	}

	// 3. instance method
	void method1() {
		System.out.println(B.field2);
		B.method2();

		B field3 = new B();
	}

	// 4. static method
	static void method2() {
		System.out.println(B.field2);
		B.method2();
		B field4 = new B();
	}

	void useB() {
		// A class 내의 B class 사용하기
		// 1) static 사용
		System.out.println(B.field2);
		B.method2();
		// 2) instance 사용
		B b = new B();
		System.out.println(b.field);
		b.method1();
	}

	// 2) static inner class(static 멤버 클래스)
	static class B {
		// 1. field
		int field = 1;
		static int field2 = 2;

		// 2. constructor
		B() {
			System.out.println("B-생성자");
		}

		// 3. 일반메서드
		void method1() {
			System.out.println("B-method1실행(instance method)");
		}

		static void method2() {
			System.out.println("B-method2실행(static method)");
		}
	}

}

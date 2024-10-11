package com.shinhan.day09.inner;

public class InnerClassExample {

	public static void main(String[] args) {

		System.out.println(A2.B.field2);
		A2.B.method2();

		A2.B aa = new A2.B();
		System.out.println(aa.field);
		aa.method1();
	}

	public static void f3(String[] args) {
		// 내부에서 inner class 사용한 기능을 호출
		A2 a = new A2();
		a.useB();

		// static 사용법
		System.out.println(A.B.field2);
		A.B.method2();
		// instance 사용법
		A.B aa = new A().new B();
		System.out.println(aa.field1);
		aa.method1();
	}

	public static void f(String[] args) {
		// 내부에서 inner class 사용한 기능을 호출
		A a = new A();
		a.useB();

		// static 사용법
		System.out.println(A.B.field2);
		A.B.method2();
		// instance 사용법
		A.B aa = new A().new B();
		System.out.println(aa.field1);
		aa.method1();
	}

}

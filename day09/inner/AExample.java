package com.shinhan.day09.inner;

public class AExample {

	public static void main(String[] args) {
		// A 객체 생성(내부에서 inner class 사용한 기능을 호출)
		A a = new A();
		// A 인스턴스 메소드 호출
		a.useB();
		
		
		// static 사용법
		System.out.println(A.B.field2);
		A.B.method2();
		
		// B 객체 생성(instance 사용법)
		A.B b = a.new B();
		System.out.println(b.field1);
		System.out.println(A.B.field2);
		b.method1();
	}

}

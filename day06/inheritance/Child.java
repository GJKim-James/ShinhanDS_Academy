package com.shinhan.day06.inheritance;

public class Child extends Parent {
	
	// field
	String myname = "자바";
	
	// 상속 후 변경하기
	String a = "상속 후 변경하기";
	// Override(덮어쓰기)
	void f1() {
		System.out.println("f1() => Override");
	}
	
	// method
	void f2() {
		System.out.println("자식 클래스에서 정의한 함수 f2()");
		System.out.println("a = " + a); // 부모 클래스의 a 접근
		f1();
		System.out.println(myname);
	}

}

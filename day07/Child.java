package com.shinhan.day07;

public class Child extends Parent {
	boolean a = true;
	String b = "자바...child";
	
	Child() {
//		super();
		System.out.println("자식의 생성자");
	}
	
	// Override(덮어쓰기) : 이름 같고, 매개변수 같고, Return 같고, Modifier 같다.
	void method1() {
		System.out.println("자식의 method1()");
	}
	
	// Overloading(추가) : 이름 같고, 매개변수 다름.
	void method1(String a) {
		
	}
	
	void method2() {
		method1(); // 부모의 메서드 사용 가능
		System.out.println("a + b : " + (a + b)); // 부모의 field 사용 가능
	}
}

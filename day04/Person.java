package com.shinhan.day04;

// class : 설계도, 구성요소 => field + method
// object : 실체(instance), class를 이용해서 생성(new)한다.
public class Person {
	// 1. field : 속성, 변수 선언, object들의 공통 특성
	String name;
	int age;
	
	// 2. constructor(생성자) : new 수행 시 자동으로 호출되는 함수
	// 정의하지 않으면 컴파일 시 자동으로 만들어진다.
	// class 이름과 같아야 한다. return을 가질 수 없다.
	Person() {
		System.out.println("$$$$$$$$$$ 우선순위 3번 $$$$$$$$$$");
		System.out.println("Person 클래스의 생성자이다. new 시 마다 실행");
	}
	
	// 3. method : 문장들의 묶음, 반드시 return 타입을 정의해야 한다.
	void study() {
		System.out.println("---------- 함수 호출 시 수행 ----------");
		System.out.println(name + " 공부한다.");
	}
	
	void useCalculator() {
		// 객체 참조 변수 선언 + 객체 생성
		Calculator cal = new Calculator();
		// 객체 사용
		cal.model = "ABC 모델";
		cal.color = "black";
		cal.price = 20000;
		// 계산기 정보 출력(기능 사용)
		cal.print();
		System.out.println(cal.plus(10, 20));
		System.out.println(cal.minus(10, 5));
	}
	
	// 4. block
	{
		System.out.println("@@@@@@@@@@ 우선순위 2번 @@@@@@@@@@");
		System.out.println("Object block..객체 생성 시마다 실행");
	}
	static {
		System.out.println("########## 우선순위 1번 ##########");
		System.out.println("static block..class가 load 시 1회");
	}
	
	// 5. inner class
	class InnerClass {
		
	}
	
}

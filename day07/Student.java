package com.shinhan.day07;

// class : object를 만들기 위한 틀, object들의 공통 속성 및 메서드 정의
// object : class를 이용해서 생성된(new) 독립된 개체 = instance

// Modifier
// 1) 접근 권한 : public > protected > 생략(default) > private
// 2) 활용 방법 : final, static, ...
// final : 마지막(변경 불가); 선언 시, 생성 시 1회만 할당
// JAVA Beans(Object) 기술에서는 private 사용
public class Student {
	// 1. field(공통 속성, 변수) : instance 변수(non-static), class 변수(static)
	String name;
	int age;
	
	static String company1 = "신한1"; // 모든 Student가 공유하는 company => static 붙여준다.
	static String company5;
	
	final String company2 = "신한2";
	final String company3;
	final String company4;
	
	// 상수 : 관례 상 대문자로 사용, 선언 시 or static block에서 초기화.
	static final String COMPANY6 = "신한6";
	static final String COMPANY7;
	
	// 2. constructor(생성자) : new 시에 자동으로 호출되는 함수
	// 정의 없으면 컴파일 시 default 생성자(매개변수 없음)를 자동으로 삽입한다. 초기화가 목적
	// 정의 있으면 컴파일 시 삽입 안된다.
	// instance 변수 자동 초기화됨
	// 생성자의 Overloading; 이름 같고, 매개변수 다름
	Student() {
		System.out.println("Student 생성 시 실행(생성자) -- default");
		company3 = "신한3";
	}
	Student(String name, int age) {
		System.out.println("Student 생성 시 실행(생성자) -- argument 존재");
		company3 = "신한3";
	}
	
	// 3. block : instance block(생성 시마다 수행), static block
	{
		System.out.println("Student 생성 시 실행(instance block)");
		company4 = "신한4";
	}
	static {
		System.out.println("Student load 시 실행");
		company5 = "신한5";
		COMPANY7 = "신한7";
	}
	
	// 4. 일반 메서드(기능)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// 5. inner class
	
}

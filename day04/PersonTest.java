package com.shinhan.day04;

public class PersonTest {

	public static void main(String[] args) {
		f1();
		f2();
		f3();
	}

	private static void f3() {
		Person p1 = new Person();
		
		p1.useCalculator();
	}

	private static void f2() {
		// 1. 객체 참조 변수 선언
		Person p1, p2;
		// 2. 객체 생성
		p1 = new Person(); // Person 클래스의 생성자이다. new 시 마다 실행
		p2 = new Person(); // Person 클래스의 생성자이다. new 시 마다 실행
		// 3. 객체 참조 변수 사용
		p2.name = "김광진";
		p2.age = 27;
		
		System.out.println(p1); // com.shinhan.day04.Person@24d46ca6
		System.out.println(p1.name); // null
		System.out.println(p1.age); // 0
		p1.study();
		System.out.println("----------------------------------------");
		System.out.println(p2); // com.shinhan.day04.Person@4517d9a3
		System.out.println(p2.name); // 김광진
		System.out.println(p2.age); // 27
		p2.study();
		System.out.println("----------------------------------------");
	}

	private static void f1() {
		// 기본형 타입 사용
		int a;
		a = 10;
		System.out.println(a);
		
		// 참조형
		// 1. 객체 참조 변수 선언
		String s1;
		// 2. 객체 생성
		s1 = new String("자바");
		// 3. 객체 참조 변수 사용
		System.out.println(s1);
		System.out.println("----------------------------------------");
	}

}

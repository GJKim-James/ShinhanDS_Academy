package com.shinhan.day06.inheritance;

// final
// 1) field에 쓰였을 때 : 값 할당 후 변경 불가
// 2) method에 쓰였을 때 : Override 불가
// 3) class에 쓰였을 때 : 상속 불가
public class Parent {
	
	int a = 100;
	
	void f1() {
		System.out.println("부모 클래스에서 정의한 함수 f1()");
	}

}

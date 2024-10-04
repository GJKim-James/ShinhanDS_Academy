package com.shinhan.day05;

public class Car {
	
	// field(변수) : 멤버(instance) 변수, static 변수(딱 하나 생긴다)
	
	// instance(멤버) 변수
	int gas;
	int speed;
	
	// static 변수; 클래스 변수, 객체 생성 없이 사용 가능, C언어의 Share 변수와 같다.
	static String company = "현대자동차";
	
	// instance method : static 사용 가능
	void setSpeed(int speed) {
		System.out.println("=== method 이용해서 값 변경 === " + company);
		this.speed = speed;
	}
	
	int getSpeed() {
//		return this.speed;
		return speed;
	}
	
	// static method : not-static 사용 불가
	static void print() {
		System.out.println("static method.. " + company);
	}
	
	static {
		System.out.println("static block.. class 최초 load 시 1번 실행");
	}
	
	{
		System.out.println("instance block.. 객체 생성 시마다 실행");
	}

}

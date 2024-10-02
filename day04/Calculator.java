package com.shinhan.day04;

public class Calculator {

	// 1. field : 특징, object들의 공통된 속성, 변수
	public String model;
	public String color;
	public int price;
	
	// 2. constructor(생성자) : default 생성자(매개변수가 없는 생성자)는 컴파일 시 만들어진다.
	
	// 3. method : 기능
	public int plus(int a, int b) {
		System.out.println("----- 더하기 -----");
		return a + b;
	}
	
	public int minus(int a, int b) {
		System.out.println("----- 빼기 -----");
		return a - b;
	}
	public void print() {
		System.out.println("----- 계산기 정보 -----");
		System.out.println("mdoel : " + model);
		System.out.println("color : " + color);
		System.out.println("price : " + price);
	}

}

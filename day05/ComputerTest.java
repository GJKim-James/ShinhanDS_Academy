package com.shinhan.day05;

public class ComputerTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}
	
	// 일반 메소드(함수) 사용하기
	private static void f5() {
		Computer c5 = new Computer("DESKTOP-5HKST2O", "Windows11", 500);
		c5.printInfo();
	}

	// getter, setter 사용하기
	private static void f4() {
		Computer c4 = new Computer("DESKTOP-5HKST2O", "Windows11", 100);
		System.out.println("c4 productName : " + c4.getProductName());
		System.out.println("c4 os : " + c4.getOs());
		System.out.println("c4 price : " + c4.getPrice());
	}

	private static void f3() {
		Computer c3 = new Computer("DESKTOP-5HKST2O", "Windows11");
		System.out.println("c3 productName : " + c3.productName);
		System.out.println("c3 os : " + c3.os);
		System.out.println("c3 price : " + c3.price);
	}

	private static void f2() {
		Computer c2 = new Computer("DESKTOP-5HKST2O", "Windows11", 300);
		System.out.println("c2 productName : " + c2.productName);
		System.out.println("c2 os : " + c2.os);
		System.out.println("c2 price : " + c2.price);
	}

	private static void f1() {
		// 기본형 : 선언, 초기화, 사용
		int a;
		a = 10;
		++a;
		System.out.println(a);
		System.out.println("----------------------------------------");
		
		// 1. 객체 참조 변수 선언
		Computer c1;
		
		// 2. 객체 생성
		c1 = new Computer();
		System.out.println("----------------------------------------");
		
		// 3. 객체 사용
		c1.productName = "내 컴퓨터";
		c1.os = "Windows10";
		c1.price = 200;
		System.out.println(c1); // 주소 값이 출력된다.
		System.out.println(c1.productName);
		System.out.println(c1.os);
		System.out.println(c1.price);
	}

}

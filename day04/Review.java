package com.shinhan.day04;

public class Review {

	public static void main(String[] args) {
		System.out.println("Review main 시작");
		f();
		
		Hello aa = new Hello(); // 다른 클래스를 사용하기 위해 new로 선언, Heap 영역에 만들어짐
		aa.f2();
		
		f3();
		
		f4();
		System.out.println("Review main 끝");
	}

	public static void f() {
		System.out.println("Review f");
		System.out.println("------------------------------");
	}
	
	private static void f3() {
		// data type
		// 1. 기본형 : byte(1) < short, char(2) < int(4) < long(8) < float(4) < double(8)
		// 			 boolean
		// 2. 참조형 : 배열, class, enum, interface 등
		int[] arr = { 10, 20, 30 }; // new int[] 생략 가능
//		arr = new int[4]; // 0으로 자동 초기화, Heap 영역에 생성
//		arr = new int[] { 10, 20, 30 };
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("------------------------------");
	}
	
	private static void f4() {
		boolean[] arr = new boolean[3];
//		char[] arr = new char[3];
//		String[] arr = new String[3];
		System.out.println("*" + arr[0] + "*");
		System.out.println("*" + arr[1] + "*");
		System.out.println("*" + arr[2] + "*");
		System.out.println("------------------------------");
	}

}

class Hello {
	public static void main(String[] args) {
		System.out.println("Hello main");
	}
	
	public void f2() {
		System.out.println("Hello f2");
		System.out.println("------------------------------");
	}
}

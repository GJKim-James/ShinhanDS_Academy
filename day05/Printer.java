package com.shinhan.day05;

// 6장 확인문제 16번 ~ 17번
public class Printer {
	
	// method overloading : 이름은 같고, 매개변수가 다름(개수, 타입이 다를 수 있다.), return은 무관
	// 자동 형 변환 가능(PrinterTest에서 println(10)
	static void println(int a) {
		System.out.println("int : " + a);
	}
	
	static void println(double a) {
		System.out.println("double : " + a);
	}
	
	static void println(boolean a) {
		System.out.println("boolean : " + a);
	}
	
	static void println(String a) {
		System.out.println("String : " + a);
	}
	
	static void println(Object a) {
		System.out.println("Object : " + a);
	}

}

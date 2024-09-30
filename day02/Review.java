package com.shinhan.day02;

public class Review {

	public static void main(String[] args) {
		q1();
		q2();
		q3();
		q4();
		q5();
		q6();
		q7();
	}

	private static void q1() {
		// 1. 변수 선언 : 선언 시 반드시 data의 성격을 결정한다. 변경 불가
		// 변수 이름으로 사용할 수 없는 것 : 예약어, 공백 불가, 숫자 시작 불가
		// 특수 문자는 _와 & 가능
		// 관례상 소문자로 시작, 일반적으로 카멜 표기법 사용
		int var1;
		// 2. 변수값 할당(초기화)
		var1 = 10;
		var1 = var1 + 20;
		// 3. 변수 사용(초기화 없이 사용 불가)
		System.out.println("var1 = " + var1);
		System.out.println("------------------------------");
	}
	
	private static void q2() {
		int intValue = 10;
		char charValue = 'A';
		double doubleValue = 5.7;
		String strValue = "A";
		
		double var1 = (double) intValue;
		byte var2 = (byte) intValue;
		int var3 = (int) doubleValue;
		// String은 기본형 타입이 아니고 자바의 Class이다.
		// 형 변환 불가, 기능이 있는지 찾아본다.
//		char var4 = (char) strValue
		char var4 = strValue.charAt(0);
		System.out.println("var4 : " + var4);
		System.out.println("------------------------------");
	}
	
	private static void q3() {
		int var1 = 10;
		long var2 = 10000000000L; // 정수 리터럴은 int 범위까지만 가능
		char var3 = ' '; // 빈 문자는 불가
		float var4 = 10;
		String var5 = "abc\ndef"; // \n : new line, \t : tab
		String var6 = """
				abc
				def
				"이것이 자바다" '자바' / \n // \\
				""";
		String var7 = "문자열 " + var1 + ", var2 = " + var2;
		System.out.println("var5 : " + var5);
		System.out.println("var6 : " + var6);
		System.out.println("var7 : " + var7);
		// f : format
		// var7 처럼 사용하는 것보다 format 사용하는 것이 좋다.
		System.out.printf("var1 = %d, var2 = %d\n", var1, var2);
		System.out.println("------------------------------");
	}
	
	private static void q4() {
		int a = 10, b = 20, c;
		
		c = (a + b);
		System.out.println("c = " + c);
		System.out.println("------------------------------");
	}
	
	private static void q5() {
		/*
		 * 기본 타입 + 기능 추가
		 * 
		 * byte => Byte
		 * short => Short
		 * char => Character
		 * int => Integer
		 * long => Long
		 * float => Float
		 * double => Double
		 */
		int a = 10;
		Integer b = 10;
		System.out.println(Integer.toBinaryString(b));
		
		double d = b.doubleValue();
		System.out.println("d = " + d);
		System.out.println("------------------------------");
	}
	
	private static void q6() {
		int v1 = 1;
		System.out.println("v1: " + v1);
		if(true) {
			int v2 = 2;
			if(true) {
				int v3 = 2;
				System.out.println("v1: " + v1);
				System.out.println("v2: " + v2);
				System.out.println("v3: " + v3);
			}
			System.out.println("v1: " + v1);
			System.out.println("v2: " + v2);
//			System.out.println("v3: " + v3);
		}
		System.out.println("v1: " + v1);
//		System.out.println("v2: " + v2);
		System.out.println("------------------------------");
	}
	
	private static void q7() {
		System.out.print("출력1");
		System.out.println("출력2");
		System.out.println("출력3");
		System.out.printf("정수값 = %d, 실수값 = %f\n", 10, 3.14);
		System.out.printf("정수값 = %5d, 실수값 = %f\n", 10, 3.14);
		System.out.printf("정수값 = %-5d, 실수값 = %10.2f\n", 10, 3.14);
		String str = "이것이 자바다";
		System.out.printf("문자값 = %s", str);
	}
	
}

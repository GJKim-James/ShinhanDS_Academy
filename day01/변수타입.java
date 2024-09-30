package com.shinhan.day01;

/*
 * 1. 정수 : byte, short, char, int, long
 * 2. 실수 : float, double
 * 3. 논리 : boolean
 */
public class 변수타입 {

	public static void main(String[] args) {
		System.out.println("main 시작");
		f1();
		f2();
		f3();
		f4();
		f5();
		f6();
		f7();
		System.out.println("main 끝");
	}

	private static void f1() {
		System.out.println("----------byte----------");
		// 1. 변수 선언
		byte score; // -128 ~ 127
		// 2. 변수값을 할당
		score = 127;
		score++; score++; score++;
		// 3. 변수 사용
		System.out.println("score = " + score); // 문자 + 숫자 => 문자
	}
	
	private static void f2() {
		// 변수의 범위 : 함수 내의 변수는 외부에서 접근 불가, 함수 종료 시 제거된다.
		System.out.println("----------short----------");
		// short (2byte) -32,768 ~ 32,767
		// 1. 변수 선언, 할당
		short score = Short.MAX_VALUE; // 32,767
		score++; ++score;
		// 복합 대입 연산자
		score += 2;
		System.out.println("Short = " + score);
	}
	
	private static void f3() {
		System.out.println("----------char----------");
		// char (2byte) : 단일 문자 / ' ' / 0 ~ 65,535
		char grade = 'A'; // 빈 문자(띄어쓰기 없는 것) 불가
		grade = 44032; // 가
		grade = 65; // A
		grade = 97; // a
		grade = 0x0041; // A(16진수)
		grade++; // B
		System.out.println("grade = " + grade);
	}
	
	private static void f4() {
		System.out.println("----------int----------");
		// int (4byte)
		// 기본형 타입 int + 기능 추가 => Integer Wrapper Class
		// literal(값) : 기본 타입은 int
		int score = Integer.MAX_VALUE; // 2,147,483,647
		score = score + 1;
		score += 1; // 복합 대입 연산자
		score++;
		System.out.println("score = " + score);
	}
	
	private static void f5() {
		System.out.println("----------long----------");
		// long (8byte)
		// 기본형 타입 long + 기능 추가 => Long Wrapper Class
		// literal(값) : 기본 타입은 long
		long score = 2147483648L; // 마지막에 L, l 붙이면 long으로 인식
		score = score + 1;
		score += 1; // 복합 대입 연산자
		score++;
		System.out.println("score = " + score);
	}
	
	private static void f6() {
		System.out.println("----------float----------");
		// 실수 : 소수점 있음
		// float(4byte), double(8byte)
		// literal(값) : 기본 타입은 double
		float data = 3.14f; // 마지막에 F, f 붙이면 float으로 인식
		double data2 = 3.14;
		double data3 = 3;
		float data4 = 3L; // 실수는 정수부, 가수부 나누어서 저장됨, 저장 방식이 다르므로 int, long보다 범위가 크다.
		System.out.println("data = " + data);
		System.out.println("data2 = " + data2);
		System.out.println("data3 = " + data3);
		System.out.println("data4 = " + data4);
	}
	
	private static void f7() {
		System.out.println("----------boolean----------");
		// 1. 변수 선언
		boolean flag;
		boolean flag2;
		boolean flag3;
		boolean flag4;
		boolean flag5;
		int a = 10, b = 20;
		// 2. 변수에 값 할당
		flag = true; // 자바의 예약어는 소문자이다.(파이썬에서는 True)
		flag2 = a > b;
		flag3 = a == b;
		// && : 모두 참이면 참, 앞의 값이 거짓이면 뒤의 문장은 무시
		flag4 = a > 10 && b >= 20;
		// || : 하나라도 참이면 참, 앞의 결과가 참이면 뒤의 문장은 무시
		flag5 = a < 10 || ++b >= 20;
		// 3. 변수 사용(초기화 하지 않은 변수는 사용 불가)
		System.out.println("flag = " + flag);
		System.out.println("flag2 = " + flag2);
		System.out.println("flag3 = " + flag3);
		System.out.println("flag4 = " + flag4);
		System.out.println("flag5 = " + flag5);
		System.out.println("b = " + b);
	}

}
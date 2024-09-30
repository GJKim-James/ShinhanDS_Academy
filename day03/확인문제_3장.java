package com.shinhan.day03;

//JVM
//cmd > java Review
//class load
public class 확인문제_3장 {

	public static void main(String[] args) {
		ex1();
		ex2();
		ex3();
		ex4();
		ex5();
		ex6();
		ex7();
		System.out.println("========== main END ==========");
	}
	
	private static void ex1() {
		int x = 10;
		int y = 20;
		int z = (++x) + (y--); // 31
		System.out.println(z);
		System.out.println("------------------------------");
	}
	
	private static void ex2() {
		int score = 85;
		String result = (!(score > 90)) ? "가" : "나";
		System.out.println(result);
		System.out.println("------------------------------");
	}
	
	private static void ex3() {
		int pencils = 534;
		int students = 30;
		
		// 학생 한 명이 가지는 연필 수
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		
		// 남은 연필 수
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);
		System.out.println("------------------------------");
	}
	
	private static void ex4() {
		int value = 356;
		System.out.println(value / 100 * 100); // 300
		System.out.println(value - (value % 100)); // 300
		System.out.println("------------------------------");
	}
	
	private static void ex5() {
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		// 사다리꼴 넓이
		double trapezoidArea = (lengthTop + lengthBottom) * height / 2.0;
		double trapezoidArea2 = (lengthTop + lengthBottom) * height * 1.0 / 2;
		double trapezoidArea3 = (double) (lengthTop + lengthBottom) * height / 2;
		double trapezoidArea4 = (double) ((lengthTop + lengthBottom) * height / 2);
		System.out.println(trapezoidArea); // 52.5
		System.out.println(trapezoidArea2); // 52.5
		System.out.println(trapezoidArea3); // 52.5
		System.out.println(trapezoidArea4); // 52.0
		System.out.println("------------------------------");
	}
	
	private static void ex6() {
		int x = 10;
		int y = 5;
		
		System.out.println((x > 7) && (y <= 5)); // true
		System.out.println((x % 3 == 2) || (y % 2 != 1)); // false
		System.out.println("------------------------------");
	}
	
	private static void ex7() {
		double x = 5.0;
		double y = 0.0;
		double z = 5 % y;
		
		// isNaN() : Not a Number, 숫자가 아니라서 숫자로 표현을 할 수 없는 상태
		if (Double.isNaN(z)) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		} else {
			System.out.println("z : " + z);
			double result = z + 10;
			System.out.println("결과 : " + result);
		}
	}
	
}

package com.shinhan.day01;

public class 변수의범위 {
	
	// static 변수 : class의 모든 메서드에서 공유(c언어의 share 변수)
	static int score = 300;

	public static void main(String[] args) {
		System.out.println("class 변수 접근 : " + score); // 300
		// 메서드 내의 변수는 지역 변수이다. 메서드 종료 시 제거
		int score = 100;
		method1();
		System.out.println("main에서 출력 : " + score); // 100
		System.out.println("main에서 출력 : " + 변수의범위.score); // 300
		System.out.println("----------------------------------------");
		
		method2();
	}

	private static void method1() {
		int score = 200;
		System.out.println("method1에서 출력 : " + score); // 200
		System.out.println("method1에서 출력 : " + 변수의범위.score); // 300
	}
	
	// 지역 변수는 선언 후 초기화 없고 사용하면 오류
	// 변수는 반드시 초기화 후 사용해야 한다.
	private static void method2() {
		String grade = "A학점";
		int score = 88;
		String title; // 초기화 안됨
		if (score < 90) {
			title = "!!!!!"; // 초기화함
			grade = "B학점";
		} else {
			title = "&&&&&"; // 초기화함
		}
		System.out.println(title + "당신의 점수는 " + score + ", 학점은 " + grade);
	}

}

package com.shinhan.day03;

import java.util.Scanner;

/*
 * Switch, abs(절댓값)
 */
public class LAB3 {
	static Scanner sc;

	// cmd> java LAB3 10 20 30
	// 명령행 args[0] = 10, args[1] = 20, args[2] = 30
	// Eclipse에서 설정하는 경우는 Run Configuration > Arguments > Program argument에 입력
	public static void main(String[] args) {
		sc = new Scanner(System.in);

//		ex1(args[0]);
		ex2();

		sc.close();
	}

	/*
	 * 문제1. 자신이 태어난 달을 명령행 매개변수로 받아서 어떤 계절에 태어났는지를 출력하는 printSeason() 메서드를 구현하시오.
	 * (단, 반드시 switch 문을 사용해야 하며 1~12월이 아닌 달을 입력했을 경우
	 * “1~12 사이의 숫자만 입력하셔야 합니다.” 라는 문자를 출력하도록 해야 한다.
	 * 그리고 주어진 메서드의 시그니쳐는 변경하지 않는다.)
	 * (봄: 3, 4, 5월,       여름: 6, 7, 8월,       가을: 9, 10, 11월,        겨울 12, 1, 2월)
	 * 
	 * [명령행 매개변수가 8일 경우]
	 * [실행결과]
	 * 여름에 태어나셨네요.
	 * 
	 * [명령행 매개변수가 10일 경우]
	 * [실행결과]
	 * 가을에 태어나셨네요.
	 * 
	 * [명령행 매개변수가 13일 경우]
	 * [실행결과]
	 * 1~12 사이의 숫자만 입력하셔야 합니다.
	 */
	private static void ex1(String month) {
		// String -> int
		int mon = Integer.parseInt(month);
		printSeason(mon);
	}

	private static void printSeason(int month) {
		String message = "";
		
		switch (month) {
			case 12, 1, 2 -> {
				message = "겨울";
			}
			case 3, 4, 5 -> {
				message = "봄";
			}
			case 6, 7, 8 -> {
				message = "여름";
			}
			case 9, 10, 11 -> {
				message = "가을";
			}
			default -> {
				message = "월 오류";
			}
		}
		
		System.out.println(message + "에 태어나셨네요.");
	}
	
	
	
	/*
	 * 문제2. 두 개의 숫자를 매개 변수로 받아서 두 숫자 사이의 차를 구하되,
	 * 실행 결과가 음수일 경우 양의 정수로 변경하여 리턴하는 abs() 메서드를 구현하시오.
	 * (단, 주어진 메서드의 시그니쳐는 변경하지 않는다.)
	 */
	private static void ex2() {
		System.out.println(abs(10, 20));
		System.out.println(abs(20, 10));
	}

	private static int abs(int a, int b) {
		int result = a - b;
		return result < 0 ? (result * -1) : result;
		
//		return (a > b) ? (a - b) : (b - a);
		
//		return Math.abs(result);
	}

}

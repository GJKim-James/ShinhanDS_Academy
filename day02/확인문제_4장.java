package com.shinhan.day02;

import java.util.Scanner;

public class 확인문제_4장 {

	public static void main(String[] args) {
		ex2(); // 4장 확인문제 2번
		ex2_1(); // 4장 확인문제 2번
		ex3(); // 4장 확인문제 3번
		ex4(); // 4장 확인문제 4번
		ex5(); // 4장 확인문제 5번
		ex6(); // 4장 확인문제 6번
		ex6_1(); // 4장 확인문제 6번
		ex7(); // 4장 확인문제 7번
	}
	
	private static void ex2() {
		String grade = "B";
		
		int score1 = 0;
		
		switch (grade) {
			case "A":
				score1 = 100;
				break;
			case "B":
				int result = 100 - 20;
				score1 = result;
				break;
			default:
				score1 = 60;
		}
		
		System.out.println(score1);
		System.out.println("------------------------------");
	}
	
	// Switch Expression(표현식)
	private static void ex2_1() {
		String grade = "B";
		
		int score1 = 0;
		
		switch (grade) {
			case "A" -> {
				score1 = 100;
			}
			case "B" -> {
				int result = 100 - 20;
				score1 = result;
			}
			default -> {
				score1 = 60;
			}
		}
		
		System.out.println(score1);
		System.out.println("------------------------------");
	}
	
	// 1부터 100까지 숫자 중 3의 배수 총합 구하기
	private static void ex3() {
		int sum = 0;
		
		for (int i = 0; i <= 100; i += 3) {
			sum += i;
		}
		System.out.println("sum = " + sum);
		System.out.println("------------------------------");
	}
	
	private static void ex4() {
		// Math.random() : 0보다 크거나 같고 1보다 작은 무작위 실수
		// Math.random() * i : 0보다 크거나 같고 i보다 작은 무작위 실수
		int dice1, dice2;
		
		while (true) {
			dice1 = (int) (Math.random() * 6);
			dice2 = (int) (Math.random() * 6);
			System.out.println("(" + dice1 + ", " + dice2 + ")");
			if (dice1 + dice2 == 5) {
				System.out.println("멈췄을 때의 주사위 눈 : " + "(" + dice1 + ", " + dice2 + ")");
				break;
			}
		}
		System.out.println("------------------------------");
	}
	
	// 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력하기, x와 y는 10 이하의 자연수
	private static void ex5() {
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}
		System.out.println("------------------------------");
	}
	
	// 별찍기
	/*
	 * ★
	 * ★★
	 * ★★★
	 * ★★★★
	 * ★★★★★
	 */
	private static void ex6() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}
	
	/*
	 * ★★★★★
	 * ★★★★
	 * ★★★
	 * ★★
	 * ★
	 */
	private static void ex6_1() {
		int end = 5;
		
		for (int i = 1; i <= end; i++) {
			for (int j = 1; j <= end + 1 - i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}
	
	private static void ex7() {
		Scanner sc = new Scanner(System.in);
		
		int num; // num : 1 ~ 4
		int money = 0, deposit = 0, withdraw = 0; // money : 통장 잔고, deposit : 예금액, withdraw : 출금액
		boolean isStop = false;
		
		while (!isStop) {
			menu();
			System.out.print("선택> ");
			num = sc.nextInt();
			switch (num) {
				case 1:
					System.out.print("예금액> ");
					deposit = sc.nextInt();
					money += deposit;
					System.out.println();
					System.out.println();
					break;
				case 2:
					System.out.print("출금액> ");
					withdraw = sc.nextInt();
					money -= withdraw;
					System.out.println();
					System.out.println();
					break;
				case 3:
					System.out.println("잔고> " + money);
					System.out.println();
					System.out.println();
					break;
				case 4:
					isStop = true;
					break;
				default:
					System.out.println("1 ~ 4 숫자 중 입력해주세요.");
					System.out.println();
					System.out.println();
					break;
			}
		}
		
		sc.close();
		System.out.println();
		System.out.println("프로그램 종료");
	}

	private static void menu() {
		System.out.println("------------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("------------------------------");
	}

}

package com.shinhan.day02;

import java.util.Scanner;

public class 조건문 {

	public static void main(String[] args) {
		call();
//		call2();
//		call3();
//		call4();
		call5();
	}

	private static void call() {
		// if
		int data = 10;
		if (data % 3 == 0) {
			System.out.println("3의 배수");
		} else {
			System.out.println("3의 배수 아님");
		}
		System.out.println("========== END ==========");
	}
	
	private static void call2() {
		// 사용자의 점수를 입력 받아서
		// A학점 : 90 이상, B학점 : 80 이상, C학점 : 70 이상, F학점 : 나머지
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		char grade = 'F';
		
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		}
		System.out.printf("당신의 점수는 %d이고 학점은 %s", score, grade);
		
		sc.close();
	}
	
	private static void call3() {
		// 사용자의 점수를 입력 받아서
		// A학점 : 90 이상, B학점 : 80 이상, C학점 : 70 이상, F학점 : 나머지
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		char grade = 'F';
		
		// break는 switch 문장에서 빠져나옴, 없으면 아래로 흐른다.
		switch (score / 10) {
			// case 10, 9:
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			default:
				grade = 'F';
				break;
		}
		System.out.printf("당신의 점수는 %d이고 학점은 %s", score, grade);
		
		sc.close();
	}
	
	private static void call4() {
		// 사용자의 점수를 입력 받아서
		// A학점 : 90 이상, B학점 : 80 이상, C학점 : 70 이상, F학점 : 나머지
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		char grade = 'F';
		
		// break 없는 switch 문
		switch (score / 10) {
			case 10, 9 -> {
				grade = 'A';
			}
			case 8 -> {
				grade = 'B';
			}
			case 7 -> {
				grade = 'C';
			}
			default -> {
				grade = 'F';
			}
		}
	
		System.out.printf("당신의 점수는 %d이고 학점은 %s", score, grade);
		
		sc.close();
	}
	
	private static void call5() {
		String grade = "A"; // A : 골드, B : 실버, C : 브론즈
		String result;
		switch (grade) {
		case "A" -> {result = "골드";}
		case "B" -> {result = "실버";}
		case "C" -> {result = "브론즈";}
		default -> {result = "손님";}
		}
		System.out.println("당신의 등급은 " + result);
	}


}

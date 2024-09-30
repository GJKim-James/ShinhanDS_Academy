package com.shinhan.day02;

public class 반복문 {

	public static void main(String[] args) {
		call();
		call2();
		call3();
		call4();
		call5();
		call6();
		call7();
	}

	private static void call() {
		// 1. for문 (초기값; 조건식; 증감식)
		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println("------------------------------" + i);
		}
		System.out.println("i = " + i);
		System.out.println("------------------------------");
	}
	
	private static void call2() {
		// 1 ~ 100까지 합
		int sum = 0, sum2 = 0;
		
		for (int i = 1, j = 5; i <= 100; i++, j += 5) {
			sum += i;
			sum2 += j;
		}
		System.out.println("1부터 100까지의 합 : " + sum);
		System.out.println("1부터 100까지 숫자 중 5의 배수의 합 : " + sum2);
		System.out.println("------------------------------");
	}
	
	private static void call3() {
		// 1 ~ 5 출력
		System.out.println("========== for문 ==========");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		System.out.println("------------------------------");
		
		// while문으로 바꿔보기
		System.out.println("========== while문 ==========");
		int i = 1;
		while (i <=5 ) {
			System.out.println(i);
			i++;
		}
		System.out.println("------------------------------");
	}
	
	private static void call4() {
		System.out.println("========== do while문 ==========");
		// 1 ~ 5 출력
		int i = 1;
		do {
			System.out.println(i);
			i++;
		} while (i <= 5);
		System.out.println("------------------------------");
	}
	
	private static void call5() {
		// 0부터 100까지 5의 배수만 출력
		for (int i = 0; i <= 100; i += 5) {
//			if (i == 15) break; // 반복문 빠져나가기
			if (i == 15) continue; // 아래 문장들은 무시하고 반복문은 계속
			System.out.println(i);							
		}
		System.out.println("------------------------------");
	}
	
	private static void call6() {
		// 구구단
		for (int dan = 2; dan <= 9; dan++) {
			System.out.println("===== " + dan + "단 =====");
//			if (dan == 4) break; // 4단부터 제외
			if (dan == 4) continue; // 4단만 제외
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%2d * %2d = %2d\n", dan, i, dan * i);
			}			
		}
		System.out.println("------------------------------");
	}
	
	// 4단 제외한 구구단 가로로 출력
	private static void call7() {
		aa: for (int i = 1; i <= 9; i++) {
			for (int dan = 2; dan <= 9; dan++) {
				if (dan == 4) continue;
//				if (dan == 4) break; // 4단 전까지 출력
//				if (dan == 4) continue aa; // label 사용해서 continue
//				if (dan == 4) break aa; // label 사용해서 break
				System.out.printf("%2d * %2d = %2d   ", dan , i, dan * i);
			}
			System.out.println();
		}
	}

}

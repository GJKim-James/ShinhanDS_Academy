package com.shinhan.day04;

import java.util.Scanner;

public class 확인문제_5장 {

	public static void main(String[] args) {
		ex6();
		ex7();
		ex8();
		ex9();
	}

	private static void ex6() {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		System.out.println(array.length); // 2차원 : 1차원이 1차원을 참조
		System.out.println(array[2].length);
		System.out.println("------------------------------");
		for (int[] datas : array) {
			for (int data : datas) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}

	private static void ex7() {
		// 주어진 배열 항목에서 최대값을 출력하는 코드 작성 (for 문 이용)
		int[] array = { 1, 5, 3, 8, 2 };

		int max = Integer.MIN_VALUE;

		for (int i : array) {
//			if (i > max) {
//				max = i;
//			}
			max = i > max ? i : max;
		}

		System.out.println("최대값 : " + max);
		System.out.println("------------------------------");
	}

	private static void ex8() {
		// 주어진 배열 항목의 전체 합과 평균을 구해 출력하는 코드 작성 (중첩 for 문 이용)
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		int sum = 0;
		int cnt = 0;
		double avg = 0.0;
		for (int[] datas : array) {
			for (int data : datas) {
				cnt++;
				sum += data;
			}
		}
		avg = (double) sum / cnt;

		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("------------------------------");
	}

	// java.lang 패키지가 아닌 곳에 있는 class들은 반드시 import 후 사용한다.
	private static void ex9() {
		// 학생들의 점수를 분석하는 프로그램
		// 키보드로부터 학생 수와 각 학생들의 점수를 입력받고, while 문과 Scanner의 nextLine() 메소드를 이용해서
		// 최고 점수 및 평균 점수를 출력하는 코드 작성
		Scanner sc = new Scanner(System.in);

		boolean isStop = false;
		int studentCount = 0;
		int[] scores = null; // null은 아직 결정된 값이 없음을 의미, 지역 변수는 초기화하지 않으면 사용 불가
		int maxScore = 0;
		double avg = 0.0;

		while (!isStop) {
			menuDisplay();
			int num = sc.nextInt(); // 1 ~ 5 숫자 입력 받기

			switch (num) {
				case 1 -> {
					studentCount = insertStudentCount(sc);
					scores = new int[studentCount]; // 학생 수 만큼 점수 입력할 배열 생성
				}
				case 2 -> {
					insertScores(sc, scores);
				}
				case 3 -> {
					printScores(scores);
				}
				case 4 -> {
					analyzeScores(scores);
				}
				case 5 -> {
					System.out.println("프로그램 종료");
					isStop = true;
				}
				default -> {
					System.out.println("잘못된 숫자 입력입니다. 1 ~ 5 숫자 중에서 입력해주세요.");
				}
			}
		}

		sc.close();
	}

	private static boolean countCheck(int[] scores) {
		if (scores == null) {
			System.out.println("학생수가 먼저 입력되어야 합니다. 1을 입력해주세요.");
			return false;
		}
		return true;
	}

	private static void analyzeScores(int[] scores) {
		// 학생수 입력되었는지 확인
		if ( !countCheck(scores) ) return;
		
		int sum = 0;
		int max = Integer.MAX_VALUE;
		
		for (int score : scores) {
			sum += score;
			max = score < max ? score : max;
		}
		
		double avg = (double) sum / scores.length;
		
		System.out.println("최고 점수: " + max);
		System.out.println("평균 점수: " + avg);
	}

	private static void printScores(int[] scores) {
		// 학생수 입력되었는지 확인
		if ( !countCheck(scores) ) return;
		
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("scores[%d]: %d\n", i, scores[i]);
		}
	}

	private static void insertScores(Scanner sc, int[] scores) {
		// 학생수 입력되었는지 확인
		if ( !countCheck(scores) ) return;
		
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("scores[%d]> ", i);
			scores[i] = sc.nextInt();
		}
	}

	private static int insertStudentCount(Scanner sc) {
		System.out.print("학생수> ");
		return sc.nextInt();
	}

	private static void menuDisplay() {
		System.out.println("----------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");
	}

}

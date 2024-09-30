package com.shinhan.day03;

import java.util.Scanner;

// cmd> java ReferenceTest 10 20
// new String[] { "10", "20" }
public class ReferenceTest {

	public static void main(String[] aa) {
		// 명령행 매개변수로 두 수를 받아서 사칙연산을 수행
		if (aa.length < 2) {
			System.out.println("명령행 매개변수로 두 수가 필수");
			return;
		}
		System.out.println(aa[0]); // 10
		System.out.println(aa[1]); // 20

		System.out.println(aa[0] + aa[1]); // 1020
		
		int a = Integer.parseInt(aa[0]); // 10
		int b = Integer.parseInt(aa[1]); // 20
		System.out.println(a + b); // 30
		System.out.println(a - b); // -10
		
//		f1();
//		f2();
//		f3();
//		f4("이것이 자바다");
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
	}

	private static void f1() {
		// 기본형이 아니면 참조형이다.
		int a = 10;
		// b는 객체 참조 변수이다.
//		Integer b = new Integer(20); // 참조형
		Integer b = 20; // 기본형 기능(값 할당, 연산, 비교) + 기타 기능 ..... Heap 영역에 저장된다.
		// 자동으로 AutoBoxing 된다.

		// -1, 0, 1 중 하나로 결과 나옴
		System.out.println(b.compareTo(30)); // -1
		System.out.println(b.compareTo(10)); // 1
		System.out.println(b.compareTo(20)); // 0
	}

	private static void f2() {
		Scanner a = new Scanner(System.in);
		Scanner b = new Scanner(System.in);

		System.out.println(a == b); // 주소 다름, false
		System.out.println(a != b); // 주소 다름, true

		a.close();
		b.close();
	}

	private static void f3() {
		char c1 = 'A';
		char c2 = 'A';
		// 컴파일 시에 객체 생성하고 이미 생성된 리터럴과 겉으면 재사용
		String s1 = "자바";
		String s2 = "자바";
		// 실행 시 객체 생성
		String s3 = new String("자바");
		String s4 = new String("자바");

		System.out.println(c1 == c2); // 기본형이므로 값을 비교
		System.out.println(s1 == s2); // 참조형이므로 주소를 비교
		System.out.println(s3 == s4); // 참조형이므로 주소를 비교
		System.out.println(s1 == s4); // 참조형이므로 주소를 비교
		System.out.println(s1.equals(s4));
		; // 참조형에서 값 비교는 함수 사용
		System.out.println(s3.equals(s4));
		; // 참조형에서 값 비교는 함수 사용
	}

	private static void f4(String param) {
		// 1. 객체 참조 변수 선언
		String s1 = param; // 결정된 값이 없다.
		// 2. 변수 초기화
		// 3. 변수 사용 ... 반드시 초기화 후 사용 가능
		System.out.println(s1);
		// null인 경우는 아직 참조하지 않고 있음을 의미, 기능 이용 불가
		if (s1 != null) {
			System.out.println(s1.length());
		} else {
			System.out.println("참조된 값이 없음");
		}
	}

	private static void f5() {
		// String은 고정 문자열이다. 변경 불가.
		String s1 = "신한DS 금융 소프트웨어 아카/데미";
		System.out.println("문자열의 길이 : " + s1.length());
		System.out.println("특정 위치의 문자 : " + s1.charAt(5));
		System.out.println("문자열의 일부 : " + s1.substring(7));
		System.out.println("문자열의 일부 : " + s1.substring(7, 10));
		System.out.println("문자열의 대체 : " + s1.replace("소프트웨어", "SW"));
		System.out.println("특정 문자의 위치(인덱스) : " + s1.indexOf("프"));
		System.out.println("------------------------------");
		System.out.println(s1);
		System.out.println("------------------------------");

		// 배열 : 하나의 이름으로 같은 타입의 값 여러 개를 갖는 자료구조
		String[] arr = s1.split(" ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("------------------------------");

		String[] arr2 = s1.split(",| |/"); // 정규표현식, | : or, 콤마와 공백과 /로 구분
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("------------------------------");

		// 향상 for문, 확장 for문(반복자 iterator)
		System.out.println("========== iterator ==========");
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("------------------------------");
	}

	private static void f6() {
		// 배열 : 연속된 공간에 값을 나열시키고, 각 값에 인덱스를 부여해 놓은 자료구조
		// 1. 배열 참조 변수 선언
		int[] arr;
		// 선언과 동시에 생성
		int arr2[] = new int[5];
		// 선언 + 생성 + 초기화
		int[] arr3 = new int[] { 100, 200, 300, 400, 500 }; // [] 안에 개수 사용 불가
		int[] arr4 = { 100, 200, 300, 400, 500 }; // 선언 시 초기화할 때 생성코드는 생략 가능
		int[] arr5;
		arr5 = new int[] { 10, 20, 30, 40, 50 }; // 선언과 초기화가 분리된 경우 생성코드는 생략 불가

		// 2. 배열 생성(Heap 영역에 생성된다, 갯수/크기는 필수, 값이 없어도 생성 시 0으로 자동 초기화)
		// 자동 초기화; 기본형 정수 : 0, 실수 : 0.0, 논리 : false, 참조형 : null
		arr = new int[5];

		// 3. 배열 사용
		for (int i = 0; i < arr.length; i++) {
			System.out.println(
					i + "번째 : " + arr[i] + " / " + arr2[i] + " / " + arr3[i] + " / " + arr4[i] + " / " + arr5[i]);
		}
		System.out.println("------------------------------");
		for (int data : arr) {
			System.out.println(data);
		}
	}

	private static void f7() {
		// 문자열 배열 선언
		String[] arr;
		String arr2[] = new String[3]; // { null, null, null }
		arr = new String[3];

//		String[] arr3 = new String[] { "HTML", "CSS", "JavaScript" };
//		String[] arr3 = { "HTML", "CSS", "JavaScript" };
		String[] arr3;
		arr3 = new String[] { "HTML", "CSS", "JavaScript" };

		arr[0] = "자바";
		arr[1] = new String("DB");
		arr[2] = new String("Spring");
//		arr[3] = new String("SpringJPA"); // index 범위가 벗어남(Exception 발생)

		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + "번째 : " + arr[i]);
		}
		System.out.println("------------------------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + "번째 : " + arr3[i]);
		}
	}

	private static void f8() {
		int[] scores = { 100, 90, 88, 100, 30 };
		int total = 0;
		for (int data : scores) {
			total += data;
		}
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (double) total / scores.length);
		System.out.println("배열의 마지막 값 : " + scores[scores.length - 1]);
	}

	private static void f9() {
		// 다차원 : 배열이 배열을 참조한다.
		// 1. 다차원 배열 참조 변수 선언
		int[][] arr;
		int[] arr2[];
		int arr3[][];

		// 2. 배열 객체 생성
		arr = new int[3][4]; // 3행 4열? arr은 3개 짜리 배열을 참조한다.
		arr2 = new int[3][]; // 첫 번째 []의 갯수는 필수
		arr3 = new int[][] { { 1, 2, 3 }, { 4, 5 } };

		// 3. 배열 사용
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.printf("%d행 %d열 값 : %d\t", i, j, arr3[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		
		// 향상 for문
		for (int[] aa : arr3) {
			for (int bb : aa) {
				System.out.print(bb + "\t");
			}
			System.out.println();
		}
	}

}

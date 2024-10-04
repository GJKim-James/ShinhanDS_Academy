package com.shinhan.day05;

import java.util.Arrays;
import java.util.Comparator;

// Comparator는 interface
// interface는 추상 메소드들로 이루어진다.
// 추상 메소드 : 정의는 있고 구현은 없다. 구현은 구현 class가 한다.
class MySort implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		// < = >
		// Ascending : 앞 - 뒤
//		return a - b;
		// Descending : 뒤 - 앞
		return b - a;
	}
}

public class Array {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		f7();
	}
	
	private static void f7() {
		Integer[][] arr = { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } };

		print("===== Before =====", arr);

		// Sort
		Arrays.sort(arr, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);

		print("===== After =====", arr);
	}

	private static void f6() {
		Integer[][] arr = { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } };

		print("===== Before =====", arr);

		// Sort
		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] a, Integer[] b) {
				// 회원 등급 기준으로 Ascending
				int result = a[0] - b[0];
				
				// 회원 등급이 같으면 구매하고자 하는 티켓 수를 기준으로 Descending
				if (result == 0) {
					return b[1] - a[1];
				}
				
				return result;
			}
		});

		print("===== After =====", arr);
	}

	private static void f5() {
		Integer[][] arr = { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } };

		print("===== Before =====", arr);

		// Sort
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// 회원 등급 비교 || 회원 등급이 같고 구매하고자 하는 티켓 수가 많은 것 먼저 정렬
				if (arr[i][0] > arr[j][0] || (arr[i][0] == arr[j][0] && arr[i][0] < arr[j][0])) {
					Integer[] temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		print("===== After =====", arr);
	}

	private static void print(String title, Integer[][] arr) {
		System.out.println(title);
		for (Integer[] array : arr) {
			System.out.println(Arrays.toString(array));
		}
		System.out.println();
	}

	private static void f4() {
		// 1차원 배열의 정렬
		String[] arr = { "java", "web", "sql" };

		System.out.println("Before : " + Arrays.toString(arr));

		// 기본 sort는 Ascending이다.
		Arrays.sort(arr);

		System.out.println("After : " + Arrays.toString(arr));
	}

	private static void f3() {
		// 1차원 배열의 정렬
		char[] arr = { 'a', 'A', 'z', 'c', 'f' };

		System.out.println("Before : " + Arrays.toString(arr));

		// 기본 sort는 Ascending이다.
		Arrays.sort(arr);

		System.out.println("After : " + Arrays.toString(arr));
	}

	private static void f2() {
		// 1차원 배열의 정렬
		Integer[] arr = { 10, 3, 34, 50, 5 };

		System.out.println("Before : " + Arrays.toString(arr));

		// 기본 sort는 Ascending이다.
		// 1. 구현 클래스 만들기
//		Arrays.sort(arr, new MySort());

		// 2. 익명 구현 클래스 만들기
		// < > 안에는 비교하고자 하는 것의 타입을 넣어주면 된다.(Generics라 부른다)
		/*
		 * Arrays.sort(arr, new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer a, Integer b) { return b - a; } });
		 */

		// 3. 익명 구현 클래스 만들기 ... 함수가 오직 1개인 경우; 람다 표현식 가능
		Arrays.sort(arr, (a, b) -> b - a);

		System.out.println("After : " + Arrays.toString(arr));
	}

	private static void f1() {
		// 1차원 배열의 정렬
		int[] arr = { 10, 3, 34, 50, 5 };

		System.out.println("Before : " + Arrays.toString(arr));

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// Ascending(오름차순) : 내가(i) 더 크면 다음것과 바꾼다
				// Descending(내림차순)
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println("After : " + Arrays.toString(arr));
	}

}

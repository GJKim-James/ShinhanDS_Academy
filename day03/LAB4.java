package com.shinhan.day03;

import java.util.Arrays;

/*
 * 배열
 */
public class LAB4 {

	public static void main(String[] args) {
//		ex1();
		ex2();
	}

	/*
	 * 문제1. 주어진 일차원 배열의 내용을 오름차순으로 정렬하는 로직을 작성하시오.
	 * (단, 로직은 main() 메서드에 작성하고 반드시 이중 for문을 사용하여 구현해야 한다.)
	 * 
	 * [배열의 내용]
	 * 3, 24, 1, 55, 17, 43, 5
	 * [클래스 실행결과]
	 * 1, 3, 5, 17, 24, 43, 55
	 */
	private static void ex1() {
//		int[] arr = new int[] { 3, 24, 1, 55, 17, 43, 5 };
		int[] arr = { 3, 24, 1, 55, 17, 43, 5 };
		System.out.println("Before : " + Arrays.toString(arr));
		
		// 선택 정렬(Selection Sort)
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("After : " + Arrays.toString(arr));
	}
	
	
	
	/*
	 * 문제2. 2차원 배열을 이용하여 두 행렬에 대한 차를 구할 수 있는 sub() 메소드와 결과를 출력하는
	 * prn() 메소드를 ArrayTest 클래스 내에 구현하십시오.
	 * 
	 * Class : ArrayTest
	 * Method 1 : public int[][] sub(int[][] a, int[][] b, int[][] c)
	 * -	행렬의 차를 구하기 위한 메소드. [ a – b = c ]
	 * 
	 *     배열 a    -     배열 b      =     배열 c
	 * 30 30 30 30     1  2  3  4        29 28 27 26 
	 * 40 40 40 40  -  5  6  7  8    =   35 34 33 32 
	 * 50 50 50 50     9 10  11 12       41 40 39 38
	 * 
	 * 
	 * Method 2 : public void prn(int[][] c)
	 * -	결과 배열 c 의 내용을 출력하기 위한 메소드. 
	 * -	아래 실행 결과 예시와 같이 각 행별로 줄바꿈을 하며, 각 열의 내용은 공백으로 구분.
	 * 
	 * 실행 결과 예시)
	 * 29 28 27 26 
	 * 35 34 33 32 
	 * 41 40 39 38
	 */
	private static void ex2() {
		int[][] arr1 = { { 30, 30, 30, 30 }, { 40, 40, 40, 40 }, { 50, 50, 50, 50} };
		int[][] arr2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12} };
		int[][] arr3 = new int[3][4];
		
		sub(arr1, arr2, arr3); // 행렬의 차를 구하기 위한 함수
		prn(arr3); // 행렬의 차를 구한 결과를 출력하기 위한 함수
	}
	
	public static int[][] sub(int[][] a, int[][] b, int[][] c) {
		for (int i = 0; i < a.length; i++) { // a.length : 3
			for (int j = 0; j < a[i].length; j++) { // a[i].length : 4
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		
		return null;
	}
	
	public static void prn(int[][] c) {
		for (int i = 0; i < c.length; i++) {
//			for (int j = 0; j < c[i].length; j++) {
//				System.out.print(c[i][j] + " ");
//			}
//			System.out.println();
			
			// 배열로 출력하는 방법
			System.out.println(Arrays.toString(c[i]));
		}
	}

}

package com.shinhan.day03;

import java.util.Iterator;
import java.util.Scanner;

/*
 * For, If, String, Scanner
 */
public class LAB1 {

	public static void main(String[] args) {
//		ex1();
//		ex2();
//		ex3();
//		ex4();
		ex5();
	}

	/*
	 * 문제1. 초기 값, 마지막 값, 증가분을 입력 받아서, 초기값부터 마지막 값까지,
	 * 증가분씩 값을 증가시키면서 각 값들의 총합을 구하는 프로그램을 작성하세요.
	 * 단, 합을 구한 결과가 1000을 넘으면, 결과에 2000을 한번 더 더하여 출력합니다.
	 * 
	 * 실행 예 1)
	 * 초기값을 정수로 입력하세요. : 1
	 * 마지막 값을 정수로 입력하세요. : 10
	 * 증가분을 정수로 입력하세요. : 1
	 * 총합은 55 입니다.
	 * 
	 * 실행 예 2)
	 * 초기값을 정수로 입력하세요. : 10
	 * 마지막값을 정수로 입력하세요. : 100
	 * 증가분을 정수로 입력하세요. : 5
	 * 총합은 3045 입니다.
	 */
	private static void ex1() {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("초기값을 정수로 입력하세요.: ");
		int start = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요.: ");
		int end = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요.: ");
		int step = sc.nextInt();
		
		for (int i = start; i <= end; i += step) {
			sum += i;
		}
		
		if (sum > 1000) {
			sum += 2000;
		}
		
		System.out.println("총합은 " + sum + " 입니다.");
		System.out.println("------------------------------");
		
		sc.close();
	}
	
	/*
	 * 문제2. 문자열을 입력 받아서 아래와 같은 실행결과가 나타나도록 ForTest클래스의 main 메쏘드를 완성하십시오.
	 * 입력 받은 문자열을 한 글자씩 증가시키며 출력하는 프로그램입니다.
	 * (단, 대문자로 출력해야 합니다.)
	 * 
	 * 실행 예)
	 * 문자열을 입력하세요. : Bat Man
	 * B
	 * BA
	 * BAT
	 * BAT
	 * BAT M
	 * BAT MA
	 * BAT MAN
	 */
	private static void ex2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요. : ");
		String inputString = sc.nextLine(); // 입력받는 문자열에 띄어쓰기가 있을 수 있으므로 nextLine() 사용
		
		inputString = inputString.toUpperCase(); // 대문자로 출력하기 위해 변환
		
		for (int i = 0; i < inputString.length(); i++) {
			// substring(start, end) : start 인덱스부터 end - 1 인덱스까지 추출
			System.out.println(inputString.substring(0, i + 1));
		}
		
		System.out.println("------------------------------");
		
		sc.close();
	}
	
	/*
	 * 문제3. 숫자를 입력 받아서 아래와 같은 실행결과가 나타나도록 SumTest 클래스의 main 메쏘드를 완성하십시오.
	 * a. 입력 받은 숫자가 홀수인 경우에는, 0 부터 입력 값까지 홀수의 합을 출력합니다.
	 * - 예제 : 입력이 7 이면 16을 출력 ( 1 + 3 + 5 + 7 = 16 )
	 * b. 입력 받은 숫자가 짝수인 경우에는, 0 부터 입력 값까지 짝수의 합을 출력합니다.
	 * - 예제 : 입력이 10 이면 30을 출력 ( 2 + 4 + 6 + 8 + 10 = 30 )
	 * 
	 * 숫자를 입력하세요. : 7
	 * 결과 값 : 16
	 * 
	 * 숫자를 입력하세요. : 10
	 * 결과 값 : 30
	 * 
	 * 숫자를 입력하세요. : 11
	 * 결과 값 : 36
	 */
	private static void ex3() {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("숫자를 입력하세요. : ");
		int num = sc.nextInt();
		
		int start;
		if (num % 2 ==0) {
			start = 2;
		} else {
			start = 1;
		}
		for (int i = start; i <= num; i += 2) {
			System.out.print(i + (i == num ? "=" : "+"));
			sum += i;
		}
		System.out.println(sum);
		
//		if (num % 2 != 0) {
//			for (int i = 1; i <= num; i += 2) {
//				sum += i;
//			}
//		} else {
//			for (int i = 2; i <= num; i += 2) {
//				sum += i;
//			}
//		}
//		
		System.out.println("결과 값 : " + sum);
		System.out.println("------------------------------");
		
		sc.close();
	}
	
	/*
	 * 문제4. 아래와 같은 출력이 나오도록 StringUtil 클래스의
	 * hokeyGraphics(char cell, int size, boolean isRect) 메소드를 완성한다.
	 * hokeyGraphics 메소드는 cell 문자와 size 값을 이용하여 특정 모양을 출력한다.
	 * isRect 값이 true 이면 사각형 모양을 출력하고, false 이면 삼각형을 출력한다.
	 * 
	 * << 출력 결과 >>
	 * ● hokeyGraphics(‘*’, 3, true)
	 * ***
	 * ***
	 * ***
	 * ● hokeyGraphics(‘&’, 3, false)
	 * &
	 * &&
	 * &&&
	 * 
	 * 문제 설명 :
	 * 1.	아래 제시된 소스 코드에 주석으로 된 부분을 채워서 프로그램을 완성한다.
	 * public class StringUtil {
	 *     public static void hokeyGraphics(char cell, int size, boolean isRect) {
	 *         //특정 도형을 출력하는 메소드 구현
	 *     }
	 *                     
	 *     public static void main(String args[])  {     
	 *         hokeyGraphics( ‘$’, 4, false); 
	 *     }
	 * }
	 */
	private static void ex4() {
//		public class StringUtil {
//			public static void hokeyGraphics(char cell, int size, boolean isRect) {
//				//특정 도형을 출력하는 메소드 구현
//			}
//			
//			public static void main(String args[]) {
//				hokeyGraphics( ‘$’, 4, false);
//			}
//		}
	}
	
	/*
	 * 문제5. 입력 받은 수 만큼 ‘*’로 직각 역삼각형을 출력하는 프로그램을 작성하십시오.
	 * 결과>
	 * 직각 역삼각형을 출력할 줄 수: 10
	 * **********
	 * *********
	 * ********
	 * *******
	 * ******
	 * *****
	 * ****
	 * ***
	 * **
	 * *
	 */
	private static void ex5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직각 역삼각형을 출력할 줄 수: ");
		int num = sc.nextInt();
		
		for (int row = 1; row <= num; row++) {
			for (int col = 1; col <= num + 1 - row; col++) {
				System.out.print("*"); // 옆으로 출력
			}
			System.out.println(); // 줄 바꾸기
		}
	}

}

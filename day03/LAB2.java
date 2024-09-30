package com.shinhan.day03;

import java.util.Scanner;

/*
 * If, For, 소수, 팩토리얼, 배수, 피보나치, 윤년, 공약수
 */
public class LAB2 {
	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

//		ex1();
//		ex2();
//		ex3();
//		ex4();
//		ex5();
//		ex6();
//		ex7();
		ex8();

		sc.close();
	}

	/*
	 * 문제1. 1보다 크고 10보다 작은 정수를 입력 받아서 아래와 같은 실행 결과가 나타나도록 Prob1 클래스의 main 메소드를
	 * 완성하십시오. 입력 받은 숫자에 해당하는 구구단을 완성시키는 프로그램입니다. 2보다 작거나 9보다 큰 정수가 입력될 경우에는 “잘못된
	 * 숫자가 입력되었습니다.”라는 경고 메시지를 출력하고 프로그램을 종료합니다.
	 * 
	 * 1보다 크고 10보다 작은 정수를 입력하세요. : 3 3 * 1 = 3 3 * 2 = 6 3 * 3 = 9 ... 3 * 9 = 27
	 */
	private static void ex1() {
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int num = sc.nextInt();

		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수 빠지기, 호출한 곳으로 돌아감
		}

		for (int i = 1; i <= 9; i++) {
//			System.out.println(num + " * " + i + " = " + num * i);
			System.out.printf("%2d * %2d = %2d\n", num, i, num * i);
		}
	}

	
	
	/*
	 * 문제2. 소수란 자신과 1외의 다른 수로는 나누어 떨어지지 않는 정수입니다. 아래와 같이 2~100 사이의 숫자를 입력하면 소수인지 여부를
	 * 판별하는 프로그램을 작성하십시오.
	 * 
	 * 실행 예 1) 2 ~ 100사이의 정수를 입력하세요. : 47 47는(은) 소수입니다.
	 * 
	 * 실행 예 2) 2 ~ 100사이의 정수를 입력하세요. : 93 93는(은) 소수가 아닙니다.
	 * 
	 * * 참고 : 2부터 100 사이의 소수는 다음과 같습니다. 프로그램 테스트에 참고하기 바랍니다. 2, 3, 5, 7, 11, 13, 17,
	 * 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
	 */
	private static void ex2() {
		// 소수인지 아닌지 판별할 변수
		boolean isPrime = true;

		System.out.print("2 ~ 100사이의 정수를 입력하세요. : ");
		int num = sc.nextInt();

		// 소수인지 아닌지 판별
//		for (int i = 2; i < num; i++) {
//			if (num % i == 0) {
//				isPrime = false; // 소수 아님
//				break; // 소수가 아닌게 확인되었으니 빠져나감
//			}
//		}

		// 다른 방법
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				isPrime = false; // 소수 아님
				break; // 소수가 아닌게 확인되었으니 빠져나감
			}
		}

		System.out.println(isPrime ? num + "는(은) 소수입니다." : num + "는(은) 소수가 아닙니다.");
	}

	
	
	/*
	 * 문제3. 임의의 숫자를 입력 받아 아래와 같은 실행 결과가 나타나는 프로그램을 작성하십시오. 정수 n의 팩토리얼(factorial)은
	 * 1부터 n까지의 모든 정수를 곱한 것으로 n!로 표시합니다. 단 2보다 작거나 9보다 큰 정수가 입력될 경우에는 “잘못된 숫자가
	 * 입력되었습니다.”라는 경고 메시지를 출력하고 프로그램을 종료합니다.
	 * 
	 * 1보다 크고 10보다 작은 정수를 입력하세요. : 5 1 ! = 1 2 ! = 2 3 ! = 6 4 ! = 24 5 ! = 120
	 */
	private static void ex3() {
		int result = 1;

		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int num = sc.nextInt();

		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수 빠지기, 호출한 곳으로 돌아감
		}

		for (int i = 1; i <= num; i++) {
			System.out.printf("%d ! = %d\n", i, factorial(i)); // factorial() 함수 따로 정의
		}
	}

	private static int factorial(int n) {
		int res = 1;

		for (int i = 1; i <= n; i++) {
			res *= i;
		}

		return res;
	}

	// factorial 다른 방법
//	private static int factorial(int n) {
//		if (n == 1) {
//			return 1;
//		} else {
//			return n * factorial(n - 1);
//		}
//	}

	
	
	/*
	 * 문제4. 임의의 정수를 입력 받아서, 1부터 1,000까지의 수 중에서 입력 받은 정수의 배수의 개수와 배수들의 합을 계산하십시오.
	 * 
	 * [출력값] 양의 정수를 입력하세요 : 7 7의 배수 개수 = 142 7의 배수 합 = 71071
	 */
	private static void ex4() {
		int count = 0, sum = 0;

		System.out.print("양의 정수를 입력하세요 : ");
		int num = sc.nextInt();

		for (int i = num; i <= 1000; i += num) {
			count++;
			sum += i;
		}

		System.out.println(num + "의 배수 개수 = " + count);
		System.out.println(num + "의 배수 합 = " + sum);

		// 다른 방법
//		int count = 1000 / num;
//		int sum = ((num + count * num) * count) / 2;
//		System.out.println(num + "의 배수 개수 = " + count);
//		System.out.println(num + "의 배수 합 = " + sum);
	}

	
	
	/*
	 * 문제5. 아래의 규칙으로 증가하는 수열에서 15번째까지의 합을 계산하십시오.
	 * 
	 * • 수열 규칙 : 1부터 시작해서 두 항의 차이가 1씩 증가 • 예 시 : 1 + 2 + 4 + 7 + 11 + 16 + 22 + …………
	 * 위의 수열에서 15번째 항까지의 합을 구하는 프로그램을 작성하십시오
	 * 
	 * 
	 * [출력값] 15번째까지의 합 : 575
	 */
	private static void ex5() {
		int sum = 0;

		for (int i = 1; i <= 15; i++) {
			sum += fibonacci(i);
		}
		
		System.out.printf("""
				[출력값]
				15번째까지의 합 : %d
				""", sum);

		// 다른 방법
//		int GOAL_NUM = 15;  //목표 값
//        int i = 0;  //증가분
//        int current_step = 0;  //현재 반복 횟수
//        int result = 1;  //수열 + 증가분
//        int total = 0;  //증가된 수열의 합
//        while (current_step < GOAL_NUM) {
//            result += i++;
//            current_step++;
//            total += result;
//        }
//        System.out.printf("%d번째까지의 합: %d", GOAL_NUM, total);
	}

	private static int fibonacci(int i) {
		if (i == 1) {
			return 1;
		}
		return i - 1 + fibonacci(i - 1);
	}

	
	
	/*
	 * 문제6 . 주어진 년도의 월에 해당하는 말일을 계산하는 프로그램을 완성하시오. 윤년인 경우에는 다음과 같은 조건에 의해 처리합니다.
	 * 
	 * [윤년의 조건]
	 * 1)	4의 배수인 해는 윤년.
	 * 2)	4의 배수이면서 100의 배수인 해는 윤년이 아님.
	 * 3)	100의 배수이면서 400의 배수인 해는 윤년.
	 * 
	 * [실행 결과]
	 * 2010년 2월의 말일은 28일 입니다
	 */
	private static void ex6() {
		System.out.print("년도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		int day = 0;
		
		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				day = 31;
			}
			case 4, 6, 9, 11 -> {
				day = 30;
			}
			case 2 -> {
				if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
					day = 29; // 윤년
				} else {
					day = 28; // 평년
				}
			}
			default -> {
				System.out.println("잘못된 월입니다.");
			}
		}
		
		System.out.println(year + "년 " + month + "월의 말일은 " + day + "일 입니다.");
	}

	
	
	/*
	 * 문제7.java 파일 내에 numDay 메쏘드를 작성하십시오. 속성은 다음과 같습니다.
	 * 1. int 형식의 인자값을 1개 받습니다. 인자값은 1-12의 값이 들어오지 않으면 오류 메시지를 출력하고 프로그램을 중단합니다.
	 * 2. 인자 값에 해당하는 월의 날짜 수를 반환합니다.
	 * Number of Days	Month Number
	 * 30				4, 6, 9,11
	 * 31				1, 3, 5, 7, 8, 10, 12
	 * 28				2
	 *  
	 * 실행 예) 
	 *  numDays(4)  30 
	 *  numDays(2)  28 
	 *  numDays(1)  31 
	 *  numDay(13) -> “13월은 존재하지 않습니다. 다시 입력하세요.”
	 */
	private static void ex7() {
		System.out.print("년도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
		// 함수 호출(값)
		int day = numDay(year, month);
		System.out.println(year + "년도 " + month + "월의 말일 : " + day);
	}

	private static int numDay(int year, int month) {
		int day = 0;
		
		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				day = 31;
			}
			case 4, 6, 9, 11 -> {
				day = 30;
			}
			case 2 -> {
				if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
					day = 29; // 윤년
				} else {
					day = 28; // 평년
				}
			}
		}
		return day;
	}

	
	
	/*
	 * 문제8. 두 숫자의 최대 공약수를 구하는 프로그램을 작성하십시오.
	 * 
	 * 최대 공약수는 두 숫자를 공통된 숫자로 나누어도 나머지가 0이 되는 가장 큰 수를 의미합니다.
	 * 예를 들어 2와 5의 최대 공약수는 1입니다.
	 * 왜냐하면, 1부터 2까지의 숫자중 공통으로 나눌 수 있는 숫자는 1 뿐이기 때문입니다.
	 * 다른 예로, 5와 15의 최대 공약수는 5가 됩니다.
	 * 메소드의 이름은 gcd로 하며, 매개변수는 두개의 정수를 받으며, 리턴 하는 타입 역시 정수입니다.
	 * 
	 * [입력값]
	 * 2, 5
	 * 5, 15
	 * 250, 30
	 * 
	 * [실행결과]
	 * 1
	 * 5
	 * 10
	 */
	private static void ex8() {
		System.out.println(gcd(2, 5));
		System.out.println(gcd(5, 15));
		System.out.println(gcd(250, 30));
	}

	private static int gcd(int a, int b) {
		int minNum = Math.min(a, b);
		
		for (int i = minNum; i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		
		return 0;
	}

}

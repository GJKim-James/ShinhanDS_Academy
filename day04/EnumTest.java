package com.shinhan.day04;

import java.util.Calendar;
import java.util.Scanner;

public class EnumTest {
	
	// 상수가 목적에 맞게 분리되지 않아서 로직 오류 발생(MONDAY와 SUCCESS의 값이 1로 같다)
	static final int MONDAY = 1;
	static final int SUCCESS = 1;

	public static void main(String[] args) {
		// 열거(Enum) 타입 : 한정된 값을 갖는 타입 ex) 요일, 계절
		// 열거 타입 이름은 첫 문자를 대문자로 하고 캐멀(camel) 스타일로 지어 주는 것이 관례
		
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f1() {
		// 상수 : 한 번 할당 후 수정 불가
	}

	private static void f2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("요일 입력(1)>> ");
		int num = sc.nextInt();
		
		System.out.println(num == MONDAY ? "월요일" : "기타");
	}
	
	private static void f3() {
		Week[] arr = Week.values();
		
		for	(Week week : arr) {
			System.out.println(week + " - " + week.name() + " - " + week.ordinal());
		}
		System.out.println("------------------------------");
		
		Week w = Week.MONDAY;
		System.out.println(w == Week.MONDAY ? "월요일" : "기타");
	}
	
	private static void f4() {
		// 오늘은 무슨 요일?
		// 1 ~ 7 (일요일 ~ 토요일)
		Calendar cal = Calendar.getInstance(); // Calendar 객체 생성(싱글톤)
		System.out.println(cal);
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		Week today = null;
		switch (week) {
			case 1:
				today = Week.SUNDAY;
				break;
			case 2:
				today = Week.MONDAY;
				break;
			case 3:
				today = Week.TUESDAY;
				break;
			case 4:
				today = Week.WEDNESDAY;
				break;
			case 5:
				today = Week.THURSDAY;
				break;
			case 6:
				today = Week.FRIDAY;
				break;
			case 7:
				today = Week.SATURDAY;
				break;
		}
		System.out.println(today + " - " + today.name() + " - " + today.ordinal());
	}
	
}

package com.shinhan.day02;

/*
 * java.base 모듈의 java.lang 패키지는 import 없이 사용
 * 나머지 Class나 interface 등 반드시 import 해서 사용해야함(ctrl + shift + o)
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class 표준입출력 {

	public static void main(String[] args) throws IOException {
		print();
//		input();
//		input2();
		input3();
	}

	private static void print() {
		// 표준 출력(기본은 모니터로 되어있음)
		PrintStream a = System.out;
		a.println(10);
		a.println("20(문자)");
		a.println(false);
		a.println(a);
		System.out.println("------------------------------");
	}
	
	private static void input() throws IOException {
		// 표준 입력(기본은 키보드)
		InputStream a = System.in;
		int b = a.read();
		System.out.println("b : " + b);
		System.out.println("------------------------------");
	}
	
	private static void input2() {
		// Scanner : 표준 입력을 간단히 사용하기 위해 제공되는 util 클래스
		InputStream a = System.in;
		// 1. 객체 참조 변수 선언
		Scanner sc;
		// 2. 객체 생성
		sc = new Scanner(a);
		System.out.print("당신의 이름은? ");
		// next() : 한 단어를 읽음(기본은 공백 분류)
		// nextLine() : 한 줄 읽기(엔터까지 읽음)
		// 섞이면 next() 다음에 nextLine()을 사용할 경우 \r\n을 읽는다.
		String name = sc.next();
		System.out.print("당신의 나이는? ");
		int age = sc.nextInt();
		sc.nextLine(); // 전공을 입력받기 위해 enter 버리기(그래서 next, nextLine 같이 사용 잘 안함.)
		System.out.print("당신의 전공은? ");
		String major = sc.nextLine();
		
		System.out.printf("당신은 나이가 %d이고, 이름은 %s이군요. 전공은 %s이네요.", age, name, major);
		
		sc.close();
	}
	
	private static void input3() {
		// 입력 : 이름과 나이와 전공, 3과목 점수
		// 모든 정보 출력, 이 때 평균도 출력
		String name, major;
		int age, java, sql, web;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("나이 : ");
		age = sc.nextInt();
		
		System.out.print("전공 : ");
		major = sc.next();
		
		System.out.print("java, sql, web 3과목 점수 : ");
		java= sc.nextInt();
		sql = sc.nextInt();
		web = sc.nextInt();
		avg = (java + sql + web) / 3.0;
		
		System.out.println("=============== 사용자 정보 ===============");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("전공 : " + major);
		System.out.println("평균 : " + avg);
	}

}

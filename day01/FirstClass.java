package com.shinhan.day01;

/*
 * 프로그램의 시작점은 main() 메서드이다.
 * 
 * format(포맷팅, 코드 정렬) : ctrl + shift + f
 * 
 * 자바 가상 머신은 main만 실행한다.
 * cmd > java FirstClass
 * 
 * 모듈화 하기 : 기능을 함수로 나누기
 */

public class FirstClass {

	public static void main(String[] args) {
		System.out.println("main 시작");
		// 함수 호출
		f1(); // 함수로 갔다가 반드시 돌아온다.
		System.out.println("main 끝");
	}
	
	// 함수 정의(main만 실행하기 때문에 이 부분은 호출하지 않으면 실행 안됨)
	public static void f1() {
		System.out.println("--------------------");
		System.out.println("f1 시작");
		System.out.println("f1 끝");
		System.out.println("--------------------");
		// return;
	}

}

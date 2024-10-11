package com.shinhan.day04;

import java.util.Scanner;

// class : Object를 만들기 위한 틀, template, 붕어빵 틀, 설계도, 특징과 행위를 갖는다.
// 객체(Object) : class로 만든 독립된 개체, 독립된 특징을 갖는다.
// instance = Object, 실체(new로 생성)
public class ObjectTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		Scanner a = new Scanner(System.in);
		Scanner b = new Scanner(System.in);
		System.out.println(a == b);
	}

}
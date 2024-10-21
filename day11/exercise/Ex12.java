package com.shinhan.day11.exercise;

// 12장 확인문제 12번
public class Ex12 {

	public static void main(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;
		
		// 범위가 -128 ~ 127이면 ==은 값을 비교하고 그 이외에는 번지를 비교
		System.out.println(obj1 == obj2); // true
		System.out.println(obj3 == obj4); // false
		
		System.out.println(obj1.equals(obj2)); // true
		System.out.println(obj3.equals(obj4)); // true
	}

}

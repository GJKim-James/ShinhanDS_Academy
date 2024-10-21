package com.shinhan.day11.exercise;

// 12장 확인문제 10번
public class Ex10 {

	public static void main(String[] args) {
		String str = "";
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 100; i++) {
			sb.append(i);
		}
		
		str = sb.toString();
		
		System.out.println(str);
	}

}

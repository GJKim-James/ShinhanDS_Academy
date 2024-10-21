package com.shinhan.day11.exercise;

import java.util.StringTokenizer;

// 12장 확인문제 11번
public class Ex11 {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		
		StringTokenizer st = new StringTokenizer(str, ",");
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}

}

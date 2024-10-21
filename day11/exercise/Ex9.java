package com.shinhan.day11.exercise;

import java.io.UnsupportedEncodingException;

// 12장 확인문제 9번
public class Ex9 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = { -20, -107, -120, -21, -123, -107 };
		
		// 문자열로 디코딩
		String str = new String(bytes, "UTF-8");
		
		System.out.println("str : " + str);
	}

}

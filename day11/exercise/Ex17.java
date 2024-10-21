package com.shinhan.day11.exercise;

import java.util.regex.Pattern;

// 12장 확인문제 17번
public class Ex17 {

	public static void main(String[] args) {
		// 정규 표현식을 이용해 첫 번째는 알파벳으로 시작하고 두 번째부터 숫자와 알파벳으로 구성된 8~12자 사이의 ID 값인지 검사
		// 알파벳은 대소문자를 모두 허용
		String id = "5Angel1004";
		String regExp = "[a-zA-Z][0-9a-zA-Z]{8,12}";
		
		boolean isMatch = Pattern.matches(regExp, id);

		if (isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		} else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}

}

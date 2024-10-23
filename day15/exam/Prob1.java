package com.shinhan.day15.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob1 {

	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
	}

	private static void printMaxScore(String[] array) {
		String maxName = null;
		int maxScore = 0;
		
		// 강사님 풀이1(정규표현식 사용)
		String regExp = "([ㄱ-힣]+)([0-9]+)점";
		
		Pattern pattern = Pattern.compile(regExp);
		
		for (String str : array) {
			Matcher matcher = pattern.matcher(str);
			
			if (matcher.find()) {
				String name = matcher.group(1); // 이름
				int score = Integer.parseInt(matcher.group(2)); // 점수
				
				if (score > maxScore) {
					maxScore = score;
					maxName = name;
				}
			}
		}
		
		// 강사님 풀이2(배열 사용)
		for (String str : array) {
			String name = "";
			String score = "";
			
			char[] charArr = str.toCharArray();
			
			for (char ch : charArr) {
				if (Character.isDigit(ch)) {
					score += ch; // 숫자이면 score에 한 문자씩 추가
				} else {
					name += ch; // 문자이면 name에 한 문자씩 추가
				}
			}
			
			name = name.substring(0, name.length() - 1);
			int score2 = Integer.parseInt(score);
			
			if (score2 > maxScore) {
				maxScore = score2;
				maxName = name;
			}
		}

		// 내 풀이
		int[] arr = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			// 이름
			String name = array[i].substring(0, array[i].length() - 3);

			// 점수
			String score = array[i].substring(array[i].length() - 3, array[i].length() - 1);
			arr[i] = Integer.parseInt(score);

			if (arr[i] > maxScore) {
				maxScore = arr[i];
				maxName = name;
			}
		}

		System.out.println("최고점수는 " + maxName + "님 " + maxScore + "점 입니다.");
	}

}

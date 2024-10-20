package com.shinhan.day13.exercise;

import java.util.HashMap;
import java.util.Map;

// 15장 확인문제 9번
public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null; // 최고 점수를 받은 아이디를 저장하는 변수
		int maxScore = 0; // 최고 점수를 저장하는 변수
		int totalScore = 0; // 점수 합계를 저장하는 변수
		
		for (String key : map.keySet()) {
			int score = map.get(key);
			totalScore += score;
			
			if (score > maxScore) {
				maxScore = score;
				name = key;
			}
		}
		
		int avgScore = totalScore / map.size(); // 평균 점수
		
		System.out.println("평균 점수: " + avgScore);
		System.out.println("최고 점수: " + maxScore);
		System.out.println("최고 점수를 받은 아이디: " + name);
	}

}

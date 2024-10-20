package com.shinhan.day13.exercise;

import lombok.ToString;

// 15장 확인문제 10번
@ToString
public class Student2 implements Comparable<Student2> {
	public String id;
	public int score;
	
	public Student2(String id, int score) {
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(Student2 obj) {
		// Student2의 score 필드값을 기준으로 내림차순(desc) 정렬
		return score - obj.score;
	}
}

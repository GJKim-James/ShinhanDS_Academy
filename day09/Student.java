package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 이미 존재하는 클래스의 Sort 기준 바꾸기 위해 2개를 비교하기 : Comparator 인터페이스를 구현해야한다.

// 기본적으로 Object는 비교 불가
// 내가 만든 클래스를 비교 가능한 클래스로 만들기 위해서는 반드시 Comparable 인터페이스를 구현해야한다.

@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Student implements Comparable<Student> {
	String name;
	int score;
	
	// lombok으로 대체 @AllArgsConstructor
//	public Student(String name, int score) {
//		super();
//		this.name = name;
//		this.score = score;
//	}

	// lombok으로 대체 @ToString
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Student [name=").append(name).append(", score=").append(score).append("]");
//		return builder.toString();
//	}

	@Override
	public int compareTo(Student obj) {
		// 1. 점수 순으로 asc
//		return score - obj.score;
		
		// 2. 점수 순으로 desc
//		return obj.score - score;
//		return (score - obj.score) * -1;
		
		// 3. 점수가 같으면 이름 순으로 asc
		int result = (score - obj.score) * -1;
		if (result == 0) {
			return name.compareTo(obj.name);
		}
		return result;
	}

}

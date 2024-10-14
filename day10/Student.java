package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok 라이브러리는 컴파일 시 자동으로 메소드들을 생성해준다.
// javaBeans 기술 : 기본 생성자 필수, field는 private, Getter/Setter는 public으로 선언
@ToString
//@ToString(of = { "name", "major" }) // name, major 필드만 표시
@Getter
@Setter
@NoArgsConstructor // 매개변수 없는 생성자(기본 생성자)
@AllArgsConstructor // 모든 필드를 매개변수로 가진 생성자
@EqualsAndHashCode
//@EqualsAndHashCode(exclude = { "name" }) // name 필드 제외하고 비교
public class Student {
	private String name;
	private Long score;
	private String major;

	// @AllArgsConstructor lombok으로 대체
//	public Student(String name, int score, String major) {
//		super();
//		this.name = name;
//		this.score = score;
//		this.major = major;
//	}

	// @NoArgsConstructor lombok으로 대체
//	Student() {
//		
//	}
}

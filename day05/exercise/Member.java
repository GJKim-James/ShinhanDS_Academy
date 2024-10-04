package com.shinhan.day05.exercise;

// 6장 확인문제 13번 ~ 15번
public class Member {

	// VO(Value Object) : 값 저장
	// DTO(Data Transfer Object) : 데이터 전달
	// 회원 정보를 Member 클래스로 모델링
	String name; // 이름
	String id; // 아이디
	String password; // 패스워드
	int age; // 나이

	// 생성자
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public Member(String id, String password, int age) {
		this.id = id;
		this.password = password;
		this.age = age;
	}

}

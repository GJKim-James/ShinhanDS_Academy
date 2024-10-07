package com.shinhan.day06.inheritance;

// 객체지향 프로그램 : 정보은닉(캡슐화, private), 상속성(수정, 추가 가능), 다형성
// 다형성 : 사용법은 같으나 결과가 다르다.(자동 타입 변환 + 메소드 오버라이딩 = 다형성)

public class Tire {
	public String color = "black";
	
	public void roll() {
		System.out.println("타이어가 굴러갑니다.");
	}
}

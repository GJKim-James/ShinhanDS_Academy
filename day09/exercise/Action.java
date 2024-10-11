package com.shinhan.day09.exercise;

// 9장 확인문제 5번

// 인터페이스는 instance를 만들 수 없다.(new Action(); 불가)
// 인터페이스는 구현 클래스를 정의하거나 익명 구현 객체 생성 가능(new Action() {} 가능)
public interface Action {
	
	public void work();

}

package com.shinhan.day06.inheritance;

// 자식은 부모(하나)의 정보를 알 수 있다.
public class Cat extends Animal {
	
	public Cat() {
		super();
		System.out.println("2. Cat 생성됨");
	}
	
	void play() {
		System.out.println("고양이 혼자 놀기");
	}
	
	@Override
	void sing() {
		System.out.println("Cat은 야옹 소리를 낸다.");
	}
	
	@Override
	void fly() {
		System.out.println("Cat은 날 수 없다.");
	}

}

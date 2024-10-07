package com.shinhan.day06.inheritance;

// 자식은 부모(하나)의 정보를 알 수 있다.
public class Dog extends Animal {
	
	public Dog() {
		super();
		System.out.println("2. Dog 생성됨");
	}
	
	@Override
	void sing() {
		System.out.println("Dog는 멍멍 소리를 낸다.");
	}
	
	@Override
	void fly() {
		System.out.println("Dog는 날 수 없다.");
	}

}

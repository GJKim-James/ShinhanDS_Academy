package com.shinhan.day07.exercise;

//7장 확인문제 7번
public class Child extends Parent {
	public String name;
	
	public Child() {
		this("홍길동");
		System.out.println("4. Child() call");
	}
	
	public Child(String name) {
		this.name = name;
		System.out.println("3. Child(String name) call");
	}
}

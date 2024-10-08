package com.shinhan.day07.exercise;

// 7장 확인문제 7번
public class Parent {
	public String nation;
	
	public Parent() {
		this("대한민국");
		System.out.println("2. Parent() call");
	}
	
	public Parent(String nation) {
		this.nation = nation;
		System.out.println("1. Parent(String nation) call");
	}
}

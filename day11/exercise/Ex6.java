package com.shinhan.day11.exercise;

class Member {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ": " + name;
	}
}

// 12장 확인문제 6번
public class Ex6 {

	public static void main(String[] args) {
		Member member = new Member("blue", "이파란");
		System.out.println(member);
	}

}

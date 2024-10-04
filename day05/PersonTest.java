package com.shinhan.day05;

public class PersonTest {

	public static void main(String[] args) {
		System.out.println(Person.getPopulation() + "명");
		
		Person p1 = new Person();
		Person p2 = new Person(20, "홍길동");
		
		p1.selfIntroduce();
		p2.selfIntroduce();
		
		System.out.println(p1.getPopulation() + "명");
		System.out.println(p2.getPopulation() + "명");
		System.out.println(Person.getPopulation() + "명"); // 바람직한 표현
	}

}

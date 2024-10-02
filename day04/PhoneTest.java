package com.shinhan.day04;

public class PhoneTest {

	public static void main(String[] args) {
		Phone p1 = new Phone();
		Phone p2 = new Phone("갤럭시24");
		Phone p3 = new Phone("갤럭시플립6", "삼성");
		Phone p4 = new Phone("아이폰16", "애플", 100);
		
		p1.print();
		p2.print();
		p3.print();
		p4.print();
	}

}

package com.shinhan.day04;

public class Phone {

	// 1. field
	// private : 정보은닉, 캡슐화 (외부에서 접근 금지, 변경 금지)
	private String model;
	private String company;
	private int price;
	
	// 2. constructor(생성자)
	// this : 객체 자신을 의미
	// 언제 사용?
	// 1) 매개 변수 이름과 field 이름이 같은 경우 구분을 위해
	// 2) 생성자의 Overloading에서 하나의 생성자가 다른 생성자 호출 시
	Phone() {
//		model = "AA";
//		company = "Samsung";
//		price = 100;
		this("AA", "Samsung", 100);
	}

	Phone(String model) {
		this(model, "S", 0);
	}

	Phone(String model, String company) {
		this(model, company, 0);
	}
	
	Phone(String model, String company, int price) {
		this.model = model;
		this.company = company;
		this.price = price;
	}
	
	// 3. 일반 메서드
	public void print() {
		System.out.println("---------- Phone 정보 ----------");
		System.out.println("model : " + this.model); // this는 써도 되고 안써도 된다.
		System.out.println("company : " + company);
		System.out.println("price : " + price);
	}

}

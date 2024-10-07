package com.shinhan.day06;

// class : object의 틀
// object는 class를 이용해서 만든 독립된 개체
// this : 현재 객체
public class ProductVO {
	
	// 1. field(data 저장 목적, 재사용) : instance 변수(non-static); new 시에 heap 영역에 객체 생성 후 자동 초기화
	// cf. class 변수(static)
	String name;
	int price;
	String maker;
	
	// 2. 생성자 : new 시 field 초기화가 목적
	public ProductVO(String name, int price, String maker) {
//		super();
		this.name = name;
		this.price = price;
		this.maker = maker;
	}
	
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", maker=" + maker + "]";
	}

}

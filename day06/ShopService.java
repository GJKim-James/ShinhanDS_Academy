package com.shinhan.day06;

// SingleTone : 객체가 한 번만 생성되도록 만든다.
// 생성자가 정의되지 않으면 컴파일 시 자동으로 class에 삽입된다.
public class ShopService {
	
	static ShopService shop;
	
	private ShopService() {
		System.out.println("생성자");
	}
	
	static ShopService getInstance() {
		if (shop == null) {
			shop = new ShopService();
		}
		return shop;
	}

}

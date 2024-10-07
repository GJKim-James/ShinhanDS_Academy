package com.shinhan.day06;

public class ShopServiceTest {

	public static void main(String[] args) {
		ShopService shopService = ShopService.getInstance();
		ShopService shopService2 = ShopService.getInstance();
		
		if (shopService == shopService2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체입니다.");
		}
	}

}

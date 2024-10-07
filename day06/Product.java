package com.shinhan.day06;

/*
 * 매개변수로 들어온 객체의 배열로부터 가격이 특정 금액 이상인 상품만 추출하여
 * 새로운 배열에 담아서 리턴하는 메서드를 구현하시오.
 * 
 * <<실행결과 >>
 * ProductVO [name=마이쭈, price=25000, maker=Samsong]
 * ProductVO [name=꿈틀이, price=32000, maker=Samsong]
 * ProductVO [name=고소미, price=75000, maker=Daehoo]
 */
public class Product {

	public static void main(String[] args) {
		
		ProductVO[] productList = new ProductVO[5];
		
		productList[0] = new ProductVO("마이쭈", 25000, "Samsong");
		productList[1] = new ProductVO("꿈틀이", 32000, "Samsong");
		productList[2] = new ProductVO("고소미", 75000, "Daehoo");
		productList[3] = new ProductVO("마이구미", 10000, "Samsong");
		productList[4] = new ProductVO("포카칩", 15000, "Samsong");
		
		// 배열 중 25000원 이상인 상품 추출
		ProductVO[] result = selectProduct(productList, 25000);
		for (ProductVO p : result) {
			if (p != null) {
				System.out.println(p); // "ProductVO [name=" + name + ", price=" + price + ", maker=" + maker + "]"
			}
		}
		
	}

	private static ProductVO[] selectProduct(ProductVO[] productList, int amount) {
		
		ProductVO[] result = new ProductVO[productList.length];
		int index = 0;
		
		for (ProductVO product : productList) {
			if (product.price >= amount) {
				result[index] = product;
				index++;
			}
		}
		
		return result;
		
	}

}

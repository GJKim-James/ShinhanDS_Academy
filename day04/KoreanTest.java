package com.shinhan.day04;

public class KoreanTest {

	public static void main(String[] args) {
		Korean k1 = new Korean("홍길동", "12345");
		
//		System.out.println(k1.nation); // nation이 private으로 선언되어있기 때문에 접근 불가
		System.out.println(k1.getNation());
		
		k1.setNation("미국");
		k1.setName("James");
		k1.setSsn("123456789");
		System.out.println(k1.getNation());
		System.out.println(k1.getName());
		System.out.println(k1.getSsn());
	}

}

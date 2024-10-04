package com.shinhan.day05;

public class SingleToneTest {

	public static void main(String[] args) {
//		SingleTone a = new SingleTone();
//		SingleTone b = new SingleTone();
		
		// 주소 값이 서로 다름
//		System.out.println(System.identityHashCode(a));
//		System.out.println(System.identityHashCode(b));
		System.out.println("------------------------------");
		
		SingleTone a2 = SingleTone.getInstance();
		SingleTone b2 = SingleTone.getInstance();
		
		// 주소 값이 같음
		System.out.println(System.identityHashCode(a2)); // 617901222
		System.out.println(System.identityHashCode(b2)); // 617901222
		System.out.println(a2 == b2); // true
	}

}

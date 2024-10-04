package com.shinhan.day05;

// class의 객체가 오직 한 번만 생성하고자 한다.
public class SingleTone {
	
	private static SingleTone single = new SingleTone();
	
	private SingleTone() {
		
	}
	
	// static이면 다른 클래스에서 new를 안해도 접근 가능
	public static SingleTone getInstance() {
		if (single == null) {
			single = new SingleTone();
		}
		return single;
	}

}

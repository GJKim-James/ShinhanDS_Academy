package com.shinhan.day08;

public interface RemoteControl {
	
	// 1. 상수
	
	// 2. 추상 메서드
	public abstract void turnOn();
	void turnOff();
	
	// 3. default 메서드
	default void f1() {
		
	}
	
	// 4. static 메서드
	static void f2() {
		
	}
	
	// 5. private 메서드
	private void f3() {
		
	}
	
	// 6. private static 메서드
	private static void f4() {
		
	}

}

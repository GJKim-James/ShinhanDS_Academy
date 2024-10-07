package com.shinhan.day06.inheritance;

public class HankookTire extends Tire {
	
	public boolean color = true;

	@Override
	public void roll() {
		System.out.println("========== 한국타이어 roll ==========");
	}
	
	void display() {
		System.out.println("한국타이어만 가지는 기술");
	}

}

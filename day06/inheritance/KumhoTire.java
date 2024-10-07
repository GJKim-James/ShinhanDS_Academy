package com.shinhan.day06.inheritance;

public class KumhoTire extends Tire {
	
	public int color = 256;

	@Override
	public void roll() {
		System.out.println("========== 금호타이어 roll ==========");
	}

}

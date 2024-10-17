package com.shinhan.day12.multithread;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		User1Thread t1 = new User1Thread();
		User2Thread t2 = new User2Thread();
		
		t1.setCalculator(cal);
		t2.setCalculator(cal);
		t1.start();
		t2.start();
	}

}

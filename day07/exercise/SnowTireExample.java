package com.shinhan.day07.exercise;

// 7장 확인문제 8번
public class SnowTireExample {

	public static void main(String[] args) {
		SnowTire snowTIre = new SnowTire();
		Tire tire = snowTIre;
		
		snowTIre.run();
		tire.run();
	}

}

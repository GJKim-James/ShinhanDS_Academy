package com.shinhan.mavenProject.section1;

public class TVUser {
	
	public static void main(String[] args) {
		f1();
		System.out.println("--------------------");
		f2();
		System.out.println("--------------------");
		f3();
	}
	
	private static void f1() {
		// interface(규격서)가 없는 경우
		SamsungTV tv = new SamsungTV("sam");
		tv.turnOn();
		tv.turnOff();
	}
	
	private static void f2() {
		// interface(규격서)가 없는 경우
		LgTV tv = new LgTV();
		tv.powerOn();
		tv.powerOff();
	}
	
	private static void f3() {
		// interface(규격서)가 있는 경우
		TVInterface tv = TVFactory.makeTV("sam");
//		TVInterface tv = new LgTV();
//		TVInterface tv = new SamsungTV();
		tv.turnOn();
		tv.turnOff();
	}

}

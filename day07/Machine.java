package com.shinhan.day07;

// abstract class : class 내의 추상 메소드가 1개 이상 있어야 한다.
public abstract class Machine {
	
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName() + " 전원 켠다.");
		System.out.println(this.getClass().getName() + " 전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName() + " 전원 끈다.");
	}
	
	// 정의만 있고 구현은 없다. 구현은 자식이 한다.
	public abstract void work();

}

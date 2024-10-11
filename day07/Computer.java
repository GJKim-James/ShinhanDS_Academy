package com.shinhan.day07;

public class Computer extends Machine {

	@Override
	public void work() {
		System.out.println("Computer class가 구현함.");
	}
	
	public static void main(String[] args) {
		Computer computer = new Computer();
		
		computer.powerOn();
		computer.powerOff();
		computer.work();
	}
	
}
package com.shinhan.day06;

public class PrinterTest {

	public static void main(String[] args) {
		// instance method; 객체 생성 필요
		Printer printer = new Printer();
		printer.println(10);
		printer.println("instance method 이용");
		printer.println(false);
		System.out.println("------------------------------");
		
		// static method; 객체 생성 불필요
		Printer.println2(10);
		Printer.println2("static method 이용");
		Printer.println2(false);
	}

}

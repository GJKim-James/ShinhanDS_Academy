package com.shinhan.day05;

//6장 확인문제 16번 ~ 17번
public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();
		
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
		System.out.println("------------------------------");
		
		// new 없이 사용하려면 Printer 클래스에서 static으로 선언
		Printer.println(false);
		Printer.println(100);
		Printer.println(3.14);
		Printer.println("자바");
	}

}

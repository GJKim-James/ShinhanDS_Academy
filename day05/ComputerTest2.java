package com.shinhan.day05;

public class ComputerTest2 {

	public static void main(String[] args) {
		System.out.println(Computer.count + "대"); // 0
		
		Computer c1 = new Computer();
		Computer c2 = new Computer("abc", "linux");
		Computer c3 = new Computer("def", "windows", 1000);
		
		System.out.println(Computer.count + "대"); // 3
	}

}

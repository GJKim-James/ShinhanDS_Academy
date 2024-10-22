package com.shinhan.day14.exercise;

// 16장 확인문제 4번
public class Ex4 {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("작업 스레드가 실행됩니다.");
			}
		});
		
		thread.start();
	}

}

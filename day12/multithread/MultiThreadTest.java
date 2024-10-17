package com.shinhan.day12.multithread;

public class MultiThreadTest {

	public static void main(String[] args) {
		// A ~ Z 출력
		Thread thread1 = new AlphabetUpperCaseThread();

		// a ~ z 출력
		Thread thread2 = new Thread(new AlphabetLowerCaseImpl());

		// 익명으로 Runnable 구현
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " - Runnable 인터페이스 구현(익명)");
			}
		});

		// 람다 표현식으로 Runnable 구현
		Thread thread4 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " - 람다 표현식으로 Runnable 인터페이스 구현"));
		
		// 스레드 구현(run); 순서대로
		// 스레드 시작(start); 다른 것을 기다리지 않음
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		// 1 ~ 26 출력
		for (int n = 1; n <= 26; n++) {
			System.out.println(Thread.currentThread().getName() + " : " + n);
		}

		System.out.println("=============== Main END ===============");
	}

}

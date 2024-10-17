package com.shinhan.day12.multithread;

// 2) 이미 다른 클래스를 상속 받고 있다면 Runnable 인터페이스를 구현한다. thread 로 만들기 가능
public class AlphabetLowerCaseImpl implements Runnable {

	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println(Thread.currentThread().getName() + " : " + ch);
		}
		System.out.println("----------------------------------------");
	}

}

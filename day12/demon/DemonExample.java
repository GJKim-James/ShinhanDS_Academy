package com.shinhan.day12.demon;

public class DemonExample {

	public static void main(String[] args) {
		// 데몬
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true); // 주 스레드가 끝나면 같이 종료
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 스레드 종료");
	}

}

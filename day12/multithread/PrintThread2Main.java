package com.shinhan.day12.multithread;

public class PrintThread2Main {

	public static void main(String[] args) {
		PrintThread2 t1 = new PrintThread2();
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t1.setStop(true); // 권장 안함, t1.stop();
	}

}

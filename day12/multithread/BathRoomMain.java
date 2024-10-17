package com.shinhan.day12.multithread;

public class BathRoomMain {

	public static void main(String[] args) {
		BathRoom bathRoom = new BathRoom();
		
		BathRoomUseThread thread1 = new BathRoomUseThread(bathRoom, "김");
		BathRoomUseThread thread2 = new BathRoomUseThread(bathRoom, "박");
		BathRoomUseThread thread3 = new BathRoomUseThread(bathRoom, "양");
		BathRoomUseThread thread4 = new BathRoomUseThread(bathRoom, "윤");
		
		// 스레드 이름 부여
		thread1.setName("Kim 스레드");
		thread1.setName("Park 스레드");
		thread1.setName("Yang 스레드");
		thread1.setName("Yoon 스레드");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}

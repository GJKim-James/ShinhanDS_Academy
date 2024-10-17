package com.shinhan.day12.multithread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BathRoomUseThread extends Thread {
	
	BathRoom bathRoom;
	String name;
	
	@Override
	public void run() {
		System.out.println(currentThread().getName());
		for (int i = 1; i <= 3; i++) {
			bathRoom.use(name);
		}
		
//		for (int i = 1; 1 <= 3; i++) {
//			try {
//				sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			bathRoom.use(name);
//		}
	}
	
}

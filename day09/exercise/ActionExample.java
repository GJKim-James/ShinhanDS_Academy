package com.shinhan.day09.exercise;

// 9장 확인문제 5번
public class ActionExample {

	public static void main(String[] args) {
//		Action action = new Action(); // 불가
		Action action = new Action() {
			@Override
			public void work() {
				System.out.println("복사를 합니다.");
			}
		};
		
		action.work();
	}

}

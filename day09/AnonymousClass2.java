package com.shinhan.day09;

interface RemoteControl {
	public abstract void turnOn();

	void turnOff();
}

class ARemoteControl implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println(getClass().getSimpleName() + "turnOn()");
	}

	@Override
	public void turnOff() {
		System.out.println(getClass().getSimpleName() + "turnOff()");
	}

}

// 익명 구현 클래스 연습2
// 내부(+익명 구현) 클래스에서 지역 변수는 변경 불가!(final 없어도 final로 선언된 것)
public class AnonymousClass2 {

	public static void main(String[] args) {
		int score = 100; // 지역 변수
		System.out.println("score : " + score);

		work(new RemoteControl() {
			// 익명 구현 클래스는 local class임
			@Override
			public void turnOn() {
				// 주의 : 지역 변수 변경 불가!
//				score++;
				System.out.println("익명 구현 클래스 turnOn(), " + score);
			}

			@Override
			public void turnOff() {
				System.out.println("익명 구현 클래스 turnOff()");
			}
		});
	}

	private static void work(RemoteControl remoteControl) {
		remoteControl.turnOn();
		remoteControl.turnOff();
	}

}

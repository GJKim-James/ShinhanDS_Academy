package com.shinhan.day09.inner;

public class ButtonApp {

	public static void main(String[] args) {
		Button.ClickListener aa = new SearchButtonListener(); // 조회
		Button.ClickListener bb = new CloseButtonListener(); // 창 닫기

		action(aa);
//		action(new SearchButtonListener());

		action(bb);
		System.out.println("----------------------------------------");

		// 익명 구현 클래스(필요 시에만 사용하고 사라짐)
		Button.ClickListener cc = new Button.ClickListener() {
			void call() {
				System.out.println("익명 구현 클래스에서 call() 함수 추가");
			}

			@Override
			public void onClick() {
				System.out.println("익명 구현 클래스 만들기 ... onClick() 재정의");
				call();
			}
		};
		action(cc);

		action(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("익명 구현 클래스 만들기2 ... onClick() 재정의");
			}
		});
	}

	public static void action(Button.ClickListener listener) {
		Button 아무거나 = new Button();
		아무거나.setMyListener(listener);
		아무거나.click();
	}

}

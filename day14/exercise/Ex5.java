package com.shinhan.day14.exercise;

// 16장 확인문제 5번

class Button {
	// 정적 멤버 인터페이스(함수형 인터페이스)
	@FunctionalInterface
	public static interface ClickListener {
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		this.clickListener.onClick();
	}
}

public class Ex5 {

	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다."); // 구현 클래스
			}
		});
		btnOk.click();
		
		Button btnCancel = new Button();
		btnCancel.setClickListener(() -> {
			System.out.println("Cancel 버튼을 클릭했습니다."); // 람다식
		});
		btnCancel.click();
	}

}

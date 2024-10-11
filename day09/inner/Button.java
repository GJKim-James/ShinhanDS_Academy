package com.shinhan.day09.inner;

// 구현 클래스 만들기
class SearchButtonListener implements Button.ClickListener {

	@Override
	public void onClick() {
		System.out.println("조회합니다.");
	}
	
}

class CloseButtonListener implements Button.ClickListener {

	@Override
	public void onClick() {
		System.out.println("창을 닫습니다.");
	}
	
}

public class Button {
	private ClickListener myListener;
	
	void setMyListener(ClickListener myListener) {
		this.myListener = myListener;
	}
	
	// 버튼을 누르면 무슨 동작?
	void click() {
		// 동작은 사용하는 쪽에서 결정한다.
		myListener.onClick();
	}
	
	// 정적 중첩 인터페이스(static inner interface)
	// static : Button.ClickListener
	// 구현 클래스는 Button.ClickListener를 implements
	// 구현 클래스는 반드시 추상 메소드들을 구현해야한다.
	public static interface ClickListener{
		// 추상 메소드
		public abstract void onClick();
	}

}

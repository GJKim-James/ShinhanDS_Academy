package com.shinhan.day08;

// 클래스는 다중 상속 불가
// 인터페이스는 다중 상속 가능
public interface Changeable extends Resizable, Colorable {

	void setFont(String font);

}

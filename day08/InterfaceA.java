package com.shinhan.day08;

// InterfaceB만 상속 가능
// sealed : 봉인
public sealed interface InterfaceA permits InterfaceB {
	
	void methodA();

}

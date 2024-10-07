package com.shinhan.day06.inheritance;

public class BonusPointAccount extends Account {
	
	int bonusPoint;
	
	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		// 명시적으로 부모의 생성자 호출
		super(accountNo, ownerName, balance);
		
		this.bonusPoint = bonusPoint;
	}

	// 입금 : Override(시그니처 같아야함)
	@Override // Annotation : 컴파일러가 해석하는 주석
	void deposit(int amount) {
		// 부모의 코드 호출
		super.deposit(amount);
		
		// 코드 추가(Override)
		bonusPoint += amount * 0.001; // 복합 대입 연산자는 자동으로 형 변환해준다.
	}
	
	// 출금 : 그대로 물려받아 사용

}

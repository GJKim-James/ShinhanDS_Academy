package com.shinhan.day06.inheritance;

public class CreditLineAccount extends Account {
	
	int creditLine; // 마이너스 한도
	
	public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
//		super(accountNo, ownerName, balance); // 부모 클래스에 Account() default 생성자가 없을 경우 써줘야 한다.
		this.creditLine = creditLine;
	}
	
	// withdraw 재정의(Override)
	// 이름 같고, 매개변수 타입과 개수 같고, return 같고, modifier가 같거나 더 넓어야 한다.
	// cf. Overloading : 추가, 이름 같고 매개변수 사양이 다르다.
	public int withdraw(int amount) {
		if (balance + creditLine < amount) {
			System.out.println("잔고 부족으로 출금 불가");
			return 0;
		} else {
			balance -= amount;
			return amount;
		}
	}

}

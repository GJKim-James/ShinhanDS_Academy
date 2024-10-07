package com.shinhan.day06.inheritance;

// class 정의 시 상속의 정의가 없으면 자바의 모든 class는 무조건
// 자바는 다중 상속 없음
// 자식은 부모의 private 제외한 모든 field와 method 사용 가능
public class CheckingAccount extends Account {
	
	// 부모를 물려받고 추가 요소가 있음(field와 method 추가)
	String cardNo;
	int pay(String cardNo, int amount) {
		if (cardNo.equals(this.cardNo)) {
			return withdraw(amount);
		}
		System.out.println("카드 번호가 다르면 지불 불가");
		return 0;
	}
	
	public CheckingAccount() {
		super(); // 부모 생성자 호출, 첫줄에서만 사용 가능, 
		System.out.println("2. CheckingAccount 생성자(자식)");
	}
	
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		// 명시적으로 부모 생성자를 호출
		super(accountNo, ownerName, balance);
//		this.setAccountNo(accountNo);
//		this.setOwnerName(ownerName);
//		this.setBalance(balance);
		
		this.cardNo = cardNo;
	}

	// 접근 가능한지 점검
	void test() {
		// 자식은 부모의 private은 접근 불가
//		System.out.println("accountNo : " + accountNo);
//		System.out.println("ownerName : " + ownerName);
//		System.out.println("balance : " + balance);
		System.out.println(getAccountNo());
		System.out.println(getOwnerName());
		System.out.println(getBalance());
		deposit(1000);
		withdraw(2000);
	}

}

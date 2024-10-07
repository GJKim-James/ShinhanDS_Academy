package com.shinhan.day06;

/*
 * 6장 확인문제 19번
 * 
 * 은행 계좌 객체인 Account 객체는 잔고(balance) 필드를 가지고 있습니다.
 * balance 필드는 음수값이 될 수 없고, 최대 백만 원까지만 저장할 수 있습니다.
 * 외부에서 balance 필드를 마음대로 변경하지 못하고,
 * 0 <= balance <= 1,000,000 범위의 값만 가질 수 있도록 Account 클래스를 작성
 * 
 * 1. Setter와 Getter를 이용
 * 2. 0과 1,000,000은 MIN_BALACNE와 MAX_BALANCE 상수를 선언해서 이용
 * 3. Setter의 매개값이 음수이거나 백만 원을 초과하면 현재 balance 값을 유지
 */

// modifier
// 1) 접근 권한 : public > protected > 생략(default) > private
// private은 외부에서 접근 불가하므로 외부 접근이 필요하면 접근하는 기능을 제공해야 한다.(Setter/Getter)
// 2) 활용 방법
public class Account {
	
	// field(변수)
	private int balance;
	
	// 상수 : static => class 소유, final => 최종(값 변경 불가)
	// 선언 시 또는 static block에서 반드시 초기화한다.
	private static final int MIN_BALANCE;
	private static final int MAX_BALANCE;
	static {
		MIN_BALANCE = 0;
		MAX_BALANCE = 1000000;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		if (balance < MIN_BALANCE || balance > MAX_BALANCE) {
			getBalance(); // Setter의 매개값이 음수이거나 백만 원을 초과하면 현재 balance 값을 유지
		} else {
			this.balance = balance;
		}
	}

}

package com.shinhan.day12.lab;

/*
 * << 출력 결과 >>
 * Money Class 구현을 완료하였습니다.
 * 
 * 문제 설명 :
 * 1. 아래 제시된 소스 코드에 주석으로 된 부분을 채워서 프로그램을 완성한다.
 * 
 * 문제 힌트 및 제한 :
 * 1. 사칙 연산 메쏘드(add, minus, multiply, divide)에서는
 * 자신의 금액(amount)과 인자로 넘어온 Money 객체의 금액(amount)을 계산하고,
 * 계산된 금액으로 새로운 Money 객체로 생성하여 리턴한다.
 * 2. equals 메쏘드에서는 인자로 넘어온 Object 객체가 Money 타입인지를 확인하고,
 * Money 타입인 경우에 금액이 동일한지를 확인한다.
 * 
 * 이 두가지 조건이 만족하는 경우에 true 를 리턴한다.
 */
public class Money {

	int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public Money add(Money money) {
		return new Money(amount + money.amount);
	}

	public Money minus(Money money) {
		return new Money(amount - money.amount);
	}

	public Money multiply(Money money) {
		return new Money(amount * money.amount);
	}

	public Money divide(Money money) {
		return new Money(amount / money.amount);
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount;
	}

	public static void main(String[] args) {
		Money five = new Money(5);
		Money two = new Money(2);
		Money three = new Money(3);
		Money ten = new Money(10);

		if (five.equals(two.add(three))
				&& three.equals(five.minus(two))
				&& ten.equals(five.multiply(two))
				&& two.equals(ten.divide(five))) {
			System.out.println("Money Class 구현을 완료하였습니다.");
		} else {
			System.out.println("Money Class 구현 실패");
		}
	}

}

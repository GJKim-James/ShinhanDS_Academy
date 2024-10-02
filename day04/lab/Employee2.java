package com.shinhan.day04.lab;

/*
 * 문제2
 * 1. 사원(Employee) 클래스는 사원번호를 나타내는 id(문자열)와 사원 이름을 나타내는 name(문자열),
 * 사원의 기본급을 나타내는 baseSalary(정수) 필드를 가지고 있다.
 * 
 * 2. 사원번호(id), 사원이름(name), 기본급(baseSalry)을 인자로 받는 생성자가 있어야 합니다.
 * 
 * 3. 메소드는 사원의 이름 변경 setName메소드와 이름을 반환하는 getName,
 * 기본급을 변경하는 setBaseSalary 와 기본급을 반환하는 getBaseSalary,
 * 사원번호를 변경하는 setId, 사원번호를 반환하는 getId 메소드를 가지고 있다.
 * 
 * 4. 또한 보너스 값을 매개인자로 받아 다음과 같이 봉급을 계산하여 반환하는 double getSalary(double bonus) 메소드를 가지고 있다.
 * - double getSalary(double bonus) 메소드의 봉급 구현 방법은 다음과 같이 기본급과 보너스를 곱한 값에 기본급을 더하여 계산한다.
 * - salary = baseSalary + baseSalary * bonus;
 * 
 * 5. 다음과 같은 형식으로 사원정보를 리턴하는 String toString() 메소드를 가지고 있다.
 * - "name(id) 사원의 기본급은 baseSalary원 입니다."
 * 
 * 모든 필드는 외부에서 직접 접근하여 값을 변경하거나 얻어가지 못하도록 private로 접근 제한을 막고,
 * 메소드는 제한 없이 모두 호출할 수 있는 접근 제한자(public)를 사용한다.
 */

// Object 클래스의 toString() 메소드가 이미 구현되어있다.(모든 클래스는 Object 클래스를 상속받음)
// 객체 출력 시 자동으로 toString() 메소드가 호출된다.
// 주소 출력 : 패키지 이름.class이름@hashCode
// 재정의(Override) 가능하다; 이름 같고, 매개변수 같고, ReturnType 같고, 접근 지정자는 같거나 더 넓어져야한다.

// public > protected > 생략 > private
// public : 모든 패키지에서 접근 가능
// protected : 같은 패키지이면 접근 가능, 다른 패키지이면 상속받을 때만 가능
// 생략 : 같은 패키지에서만 접근 가능
// private : 같은 클래스에서만 접근 가능
public class Employee2 {
	private String id; // 사원번호
	private String name; // 사원이름
	private int baseSalary; // 기본급
	
	// 생성자의 접근 지정자는 일반적으로 클래스의 접근 지정자와 같다.
	public Employee2(String id, String name, int baseSalary) {
//		super();
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	// getter, setter 생성
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	// 보너스 값을 매개인자로 받아 봉급을 계산하는 메소드
	double getSalary(double bonus) {
		double salary = baseSalary + baseSalary * bonus;
		return salary;
	}
	
	// 사원정보를 리턴하는 메소드
	public String toString() {
		return name + "(" + id + ")" + " 사원의 기본급은 " + baseSalary + "원 입니다.";
	}
}

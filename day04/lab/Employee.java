package com.shinhan.day04.lab;

/*
 * 문제1. 다음 설명을 읽고 Employee 클래스를 신규 작성하십시오. 테스트용으로 EmployeeExam .java 파일을 실행할 수 있습니다.
 * 
 * 1. Employee 클래스는 다음과 같은 필드를 가집니다.
 * 
 * 	멤버변수 name : String : private
 * 	       title : String : private
 * 	       baseSalary : int : private
 * 	       totalSalary : int : private
 * 
 * 2. Employee 클래스는 다음과 같은 생성자를 가집니다.
 * public Employee(String name, String title, int baseSalary) {
 *     3개의 매개변수를 차례대로 같은 이름의 멤버변수 값으로 초기화하는 문장 정의
 * }
 *  
 * 3. Employee 클래스는 다음과 같은 메소드를 가집니다.
 * 3-1. public void getTotalSalary() 메소드 :  
 *      title 이 “부장” 이면 totalSalary 는 baseSalary + baseSalary 의 25%로 계산
 *      title 이 “과장” 이면 totalSalary 는 baseSalary + baseSalary 의 15%로 계산 
 *      나머지 totalSalary 는 baseSalary + baseSalary 의 5%로 계산
 * 
 * 3-2. public void print() 메소드 : 
 *      EmployeeExam 클래스 실행 예의 결과대로 title, name, baseSalary, totalSalary 를 출력
 *       
 * 실행 예) java EmployeeExam
 * 부장 직급의 이부장씨의 본봉은 1500000 원이고 총급여는 1875000 원입니다.
 * 과장 직급의 김과장씨의 본봉은 1300000 원이고 총급여는 1495000 원입니다.
 * 대리 직급의 최대리씨의 본봉은 1200000 원이고 총급여는 1260000 원입니다.
 * 사원 직급의 박사원씨의 본봉은 1000000 원이고 총급여는 1050000 원입니다.
 */
public class Employee {
	// 1. field (멤버 변수, static 변수)
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	// 2. Constructor(생성자 : new 하는 방식); 값을 초기화하는 것이 목적
	public Employee(String name, String title, int baseSalary) {
//		super(); // 생략 가능
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		
		getTotalSalary();
	}

	// 3. 일반 메서드
	public void getTotalSalary() {
		// 문자열 비교에 주의! == 는 주소 비교이다. 값 비교할 때는 .equals() 사용
		if (title.equals("부장")) {
			totalSalary = (int) (baseSalary + baseSalary * 0.25);
		} else if (title.equals("과장")) {
			totalSalary = (int) (baseSalary + baseSalary * 0.15);
		} else {
			totalSalary = (int) (baseSalary + baseSalary * 0.05);
		}
	}

	public void print() {
		System.out.printf("%s 직급의 %s씨의 본봉은 %d원이고 총급여는 %d원입니다.\n", title, name, baseSalary, totalSalary);
	}

}

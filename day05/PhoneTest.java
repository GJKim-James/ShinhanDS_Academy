package com.shinhan.day05;

import com.shinhan.day04.lab.Employee;
 

public class PhoneTest {

	public static void main(String[] args) {
		
		System.out.println("COMPANY3 : " + Phone.COMPANY3);
//		Phone.COMPANY3 = "dd"; // 변경은 불가
		
		Phone p = new Phone();
		System.out.println("p.company : " + p.company);
		System.out.println("p.company2 : " + p.company2);
		// final로 선언했기 때문에 변경은 불가
//		p.company = "dd";
//		p.company2 = "dd";
		System.out.println("------------------------------");
		
		// Integer의 최대값
		// PI 값
		// Integer.MAX_VALUE = 100;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.PI);
		System.out.println("------------------------------");
		
		// 다른 패키지의 Employee
		Employee emp = new Employee("aa", "부장", 1000);
		emp.print();
		System.out.println("------------------------------");
		
		// 다른 패키지의 Calculator
		Calculator cal = new Calculator();
		System.out.println(cal.sum(1, 2));
		
		com.shinhan.day04.Calculator cal2 = new com.shinhan.day04.Calculator();
		System.out.println(cal2.plus(1, 2));
		
	}

}

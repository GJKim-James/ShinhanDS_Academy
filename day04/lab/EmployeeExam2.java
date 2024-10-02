package com.shinhan.day04.lab;

public class EmployeeExam2 {
	
	public static void main(String[] args) {
		Employee2 emp = new Employee2("1234", "홍길동", 1000000);
		System.out.println(emp.getSalary(0.1)); // 보너스 0.1프로
		
		System.out.println(emp);
		System.out.println(emp.toString());
	}

}

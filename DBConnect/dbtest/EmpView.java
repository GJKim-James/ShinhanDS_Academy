package com.firstzone.dbtest;

import java.util.List;

public class EmpView {
	
	public static void display(List<EmpDTO> empList) {
		System.out.println("------------------------------ 직원 정보 조회 ------------------------------");
		
		for (EmpDTO emp : empList) {
			System.out.println(emp);
		}
	}
	
	public static void display(EmpDTO emp) {
		System.out.println("------------------------------ 직원 정보 1건만 조회 ------------------------------");
		System.out.println(emp == null ? "해당 직원 번호를 가진 직원 없음" : emp);
	}
	
	public static void display(String message) {
		System.out.println("[알림] " + message);
	}
	
}

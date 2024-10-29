package com.firstzone.dept;

import java.util.List;

public class DeptView {

	public static void display(List<DeptDTO> deptList) {
		System.out.println("------------------------------ 모든 부서 정보 조회 ------------------------------");

		for (DeptDTO dept : deptList) {
			System.out.println(dept);
		}
	}

	public static void display(DeptDTO dept) {
		System.out.println("-------------------- 입력한 부서 번호의 정보 1건만 조회 --------------------");
		if (dept == null) {
			System.out.println("해당 부서 번호를 가진 부서 없음");
		} else {
			System.out.println("부서 번호 : " + dept.getDept_id());
			System.out.println("부서 이름 : " + dept.getDept_name());
			System.out.println("매니저 번호 : " + dept.getManager_id());
			System.out.println("지역 번호 : " + dept.getLocation_id());
		}
	}

	public static void display(String message) {
		System.out.println("[알림] " + message);
	}

}

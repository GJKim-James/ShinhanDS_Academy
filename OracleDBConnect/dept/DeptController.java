package com.firstzone.dept;

import java.util.List;
import java.util.Scanner;

public class DeptController {

	static Scanner sc = new Scanner(System.in);

	static DeptService deptService = new DeptService();

	public static void main(String[] args) {
		boolean isStop = false;

		while (!isStop) {
			menu();

			int jobSelect = Integer.parseInt(sc.nextLine());

			switch (jobSelect) {
				case 1 -> {
					List<DeptDTO> empList = deptService.selectAll(); // 모든 부서 정보 조회
					DeptView.display(empList);
				}
				case 2 -> {
					selectByID(); // 부서 번호 입력해서 해당 부서 정보 조회(상세보기)
				}
				case 3 -> {
					insert(); // 새로운 부서 정보 입력
				}
				case 4 -> {
					update(); // 부서 정보 수정
				}
				case 5 -> {
					delete(); // 부서 정보 삭제
				}
				case 0 -> {
					isStop = true; // 작업 종료
				}
				default -> {
					System.out.println("작업 선택 오류. 다시 선택해주세요.");
				}
			}
		}

		sc.close();
		System.out.println("==================== 프로그램 종료 ====================");
	}

	// 부서 정보 삭제
	private static void delete() {
		System.out.print("삭제할 부서 번호>> ");
		int deptId = Integer.parseInt(sc.nextLine());
		
		int result = deptService.delete(deptId);
	
		DeptView.display(result + "건 삭제됨");
	}

	// 부서 정보 수정
	private static void update() {
		System.out.println("----- 수정할 부서 정보를 입력하세요 -----");
		
		int result = deptService.update(makeDept());
		
		DeptView.display(result + "건 수정됨");
	}

	// 새로운 부서 정보 입력
	private static void insert() {
		System.out.println("----- 새로운 부서 정보를 입력하세요 -----");
		
		int result = deptService.insert(makeDept());
		
		DeptView.display(result + "건 입력됨");
	}

	// 부서 번호 입력해서 해당 부서 정보 조회(상세보기)
	private static void selectByID() {
		System.out.print("부서 번호>> ");
		int deptId = Integer.parseInt(sc.nextLine());
		
		DeptDTO dept = deptService.selectById(deptId);
		DeptView.display(dept);
	}
	
	private static DeptDTO makeDept() {
		System.out.print("부서 번호 : ");
		int deptId = Integer.parseInt(sc.nextLine());

		System.out.print("부서 이름 : ");
		String deptName = sc.nextLine();
		
		System.out.print("매니저 번호 : ");
		int managerId = Integer.parseInt(sc.nextLine());
		
		System.out.print("지역 번호 : ");
		int locationId = Integer.parseInt(sc.nextLine());
		
		DeptDTO dept = new DeptDTO();
		
		dept.setDept_id(deptId);
		dept.setDept_name(deptName);
		dept.setManager_id(managerId);
		dept.setLocation_id(locationId);
		
		return dept;
	}

	private static void menu() {
		System.out.println("=======================================");
		System.out.println("1.조회 2.상세보기 3.입력 4.수정 5.삭제 0.종료");
		System.out.println("=======================================");
		System.out.print("작업 선택>> ");
	}

}

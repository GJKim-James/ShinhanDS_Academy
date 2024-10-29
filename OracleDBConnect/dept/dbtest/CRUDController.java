package com.firstzone.dbtest;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.shinhan.util.DateUtil;

public class CRUDController {

	static Scanner sc = new Scanner(System.in);

	static EmpService empService = new EmpService();

	public static void main(String[] args) {
		boolean isStop = false;

		while (!isStop) {
			menu();

			int jobSelect = Integer.parseInt(sc.nextLine());

			switch (jobSelect) {
				case 1 -> {
					List<EmpDTO> empList = empService.selectAllService(); // 직원 정보 조회
					EmpView.display(empList);
				}
				case 2 -> {
					f_insert(); // 새로운 직원 정보 입력
				}
				case 3 -> {
					f_update(); // 직원 정보 수정
				}
				case 4 -> {
					f_delete(); // 직원 정보 삭제
				}
				case 5 -> {
					f_selectByID(); // 직원 번호 입력해서 해당 직원 정보 조회
				}
				case 6 -> {
					selectByDeptId(); // 부서 번호로 직원 조회
				}
				case 7 -> {
					selectByJobId(); // JOB_ID로 직원 조회
				}
				case 8 -> {
					selectBySalary(); // 급여가 ? 이상인 직원 조회
				}
				case 9 -> {
					selectByCondition(); // 부서, 직책, 급여, 입사일 조건으로 조회
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

	// 부서, 직책, 급여, 입사일 조건으로 조회
	private static void selectByCondition() {
		System.out.print("부서 번호(10, 20, 30, ..., 110)>> ");
		int deptId = Integer.parseInt(sc.nextLine());
		
		System.out.print("JOB_ID(IT_PROG, SH_CLERK, AD_ASST, ...)>> ");
		String jobId = sc.nextLine();
		
		System.out.print("기준 급여 입력>> ");
		double salary = Integer.parseInt(sc.nextLine());
		
		System.out.print("입사일(yyyy-MM-dd) 입력>> ");
		String hDate = sc.nextLine();
		Date hireDate = DateUtil.convertSqlDate(DateUtil.convertDate(hDate));
		
		Map<String, Object> map = new HashMap<>();
		map.put("DEPARTMENT_ID", deptId);
		map.put("JOB_ID", jobId);
		map.put("SALARY", salary);
		map.put("HIRE_DATE", hireDate);
		
		List<EmpDTO> empList = empService.selectByCondition(map);
		EmpView.display(empList);
	}

	// 급여가 ? 이상인 직원 조회
	private static void selectBySalary() {
		System.out.print("기준 급여 입력>> ");
		int salary = Integer.parseInt(sc.nextLine());
		
		List<EmpDTO> emp = empService.selectBySalary(salary);
		EmpView.display(emp);
	}

	// JOB_ID로 직원 조회
	private static void selectByJobId() {
		System.out.print("JOB_ID(IT_PROG, SH_CLERK, AD_ASST, ...)>> ");
		String jobId = sc.nextLine();
		
		List<EmpDTO> emp = empService.selectByJobId(jobId);
		EmpView.display(emp);
	}

	// 부서 번호로 직원 조회
	private static void selectByDeptId() {
		System.out.print("부서 번호(10, 20, 30, ..., 110)>> ");
		int deptId = Integer.parseInt(sc.nextLine());
		
		List<EmpDTO> emp = empService.selectByDeptId(deptId);
		EmpView.display(emp);
	}

	private static void f_delete() {
		System.out.print("삭제할 직원번호>> ");
		int empId = Integer.parseInt(sc.nextLine());
		
		int result = empService.deleteService(empId);
		EmpView.display(result + "건 삭제됨");
	}

	private static void f_update() {
		System.out.println("----- 수정할 직원 정보를 입력하세요 -----");
		
		int result = empService.updateService(f_makeEmp());
		
		EmpView.display(result + "건 수정됨");
	}

	private static void f_insert() {
		System.out.println("----- 새로운 직원 정보를 입력하세요 -----");
		
		int result = empService.insertService(f_makeEmp());
		
		EmpView.display(result + "건 입력됨");
	}

	private static void f_selectByID() {
		System.out.print("직원 번호>> ");
		int empId = Integer.parseInt(sc.nextLine());

		EmpDTO emp = empService.selectByIdService(empId);
		EmpView.display(emp);
	}

	private static EmpDTO f_makeEmp() {
		System.out.print("직원 번호(100 ~ 206 존재, 1 새로 추가됨) : ");
		int empId = Integer.parseInt(sc.nextLine());

		System.out.print("FIRST_NAME : ");
		String firstName = sc.nextLine();

		System.out.print("LAST_NAME : ");
		String lastName = sc.nextLine();

		System.out.print("EMAIL : ");
		String email = sc.nextLine();

		System.out.print("PHONE_NUMBER : ");
		String phoneNumber = sc.nextLine();

		System.out.print("HIRE_DATE(yyyy-MM-dd) : ");
		String hireDate = sc.nextLine();
		Date hire_Date = DateUtil.convertSqlDate(DateUtil.convertDate(hireDate));

		System.out.print("JOB_ID(FK, EX.IT_PROG) : ");
		String jobId = sc.nextLine();

		System.out.print("SALARY : ");
		Double salary = Double.parseDouble(sc.nextLine());

		System.out.print("COMMISSION_PCT(0.??) : ");
		Double commission = Double.parseDouble(sc.nextLine());

		System.out.print("MANAGER_ID(100 ~ 207) : ");
		int managerId = Integer.parseInt(sc.nextLine());

		System.out.print("DEPARTMENT_ID(10 ~ 270) : ");
		int departmentId = Integer.parseInt(sc.nextLine());

		EmpDTO emp = new EmpDTO();
		emp.setEmployee_id(empId);
		emp.setFirst_name(firstName);
		emp.setLast_name(lastName);
		emp.setEmail(email);
		emp.setPhone_number(phoneNumber);
		emp.setHire_date(hire_Date);
		emp.setJob_id(jobId);
		emp.setSalary(salary);
		emp.setCommission_pct(commission);
		emp.setManager_id(managerId);
		emp.setDepartment_id(departmentId);
		
		return emp;
	}
	
	private static void menu() {
		System.out.println("================================");
		System.out.println("0.종료");
		System.out.println("1.조회 2.입력 3.수정 4.삭제 5.상세보기");
		System.out.println("6.부서 번호로 직원 조회");
		System.out.println("7.JOB_ID로 직원 조회");
		System.out.println("8.급여가 ? 이상인 직원 조회");
		System.out.println("9.부서, 직책, 급여, 입사일 조건으로 조회");
		System.out.println("================================");
		System.out.print("작업 선택>> ");
	}

}

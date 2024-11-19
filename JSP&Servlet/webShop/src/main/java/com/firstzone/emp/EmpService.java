package com.firstzone.emp;

import java.util.List;
import java.util.Map;

// 사용자 요청 -> Controller -> Service -> DAO -> DB
// DB 관련 없는 업무 로직은 Service에서 수행
public class EmpService {
	
	EmpDAO empDAO = new EmpDAO();
	
	// 모든 직원 정보 조회
	public List<EmpDTO> selectAllService() {
		return empDAO.selectAll();
	}

	// 특정 직원 정보 조회
	public EmpDTO selectByIdService(int empId) {
		return empDAO.selectById(empId);
	}
	
	// 입력
	public int insertService(EmpDTO emp) {
		return empDAO.insert(emp);
	}
	
	// 수정
	public int updateService(EmpDTO emp) {
		return empDAO.update(emp);
	}

	// 삭제
	public int deleteService(int empId) {
		return empDAO.delete(empId);
	}

	// 부서 번호로 직원 조회
	public List<EmpDTO> selectByDeptId(int deptId) {
		return empDAO.selectByDeptId(deptId);
	}
	
	// JOB_ID로 직원 조회
	public List<EmpDTO> selectByJobId(String jobId) {
		return empDAO.selectByJobId(jobId);
	}

	// 급여가 ? 이상인 직원 조회
	public List<EmpDTO> selectBySalary(int salary) {
		return empDAO.selectBySalary(salary);
	}

	// 부서, 직책, 급여, 입사일 조건으로 조회
	public List<EmpDTO> selectByCondition(Map<String, Object> map) {
		return empDAO.selectByCondition(map);
	}
	
}

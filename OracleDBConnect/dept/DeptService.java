package com.firstzone.dept;

import java.util.List;

public class DeptService {
	
	DeptDAO deptDAO = new DeptDAO();

	// 모든 부서 정보 조회
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}

	// 부서 번호 입력해서 해당 부서 정보 조회(상세보기)
	public DeptDTO selectById(int deptId) {
		return deptDAO.selectById(deptId);
	}

	// 새로운 부서 정보 입력
	public int insert(DeptDTO dept) {
		return deptDAO.insert(dept);
	}

	// 부서 정보 수정
	public int update(DeptDTO dept) {
		return deptDAO.update(dept);
	}

	// 부서 정보 삭제
	public int delete(int deptId) {
		return deptDAO.delete(deptId);
	}

}

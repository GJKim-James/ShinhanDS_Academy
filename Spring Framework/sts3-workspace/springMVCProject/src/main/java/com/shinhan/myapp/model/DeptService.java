package com.shinhan.myapp.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.myapp.vo.DeptDTO;

@Service("deptService") // @Component + service 역할, 이름 설정 안하면 DeptService => deptService로 자동으로 이름 설정
// <bean id="deptService" class="com.shinhan.myapp.model"></bean>
public class DeptService {
	
	@Autowired // ref
	DeptDAO deptDAO; // DeptDAO deptDAO = new DeptDAO();

	// 모든 부서 정보 조회
	public List<DeptDTO> selectAllService() {
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

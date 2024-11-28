package com.shinhan.myapp.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.myapp.vo.DeptDTO;

@Service("deptService") // @Component + service ����, �̸� ���� ���ϸ� DeptService => deptService�� �ڵ����� �̸� ����
// <bean id="deptService" class="com.shinhan.myapp.model"></bean>
public class DeptService {
	
	@Autowired // ref
	DeptDAO deptDAO; // DeptDAO deptDAO = new DeptDAO();

	// ��� �μ� ���� ��ȸ
	public List<DeptDTO> selectAllService() {
		return deptDAO.selectAll();
	}

	// �μ� ��ȣ �Է��ؼ� �ش� �μ� ���� ��ȸ(�󼼺���)
	public DeptDTO selectById(int deptId) {
		return deptDAO.selectById(deptId);
	}

	// ���ο� �μ� ���� �Է�
	public int insert(DeptDTO dept) {
		return deptDAO.insert(dept);
	}

	// �μ� ���� ����
	public int update(DeptDTO dept) {
		return deptDAO.update(dept);
	}

	// �μ� ���� ����
	public int delete(int deptId) {
		return deptDAO.delete(deptId);
	}

}

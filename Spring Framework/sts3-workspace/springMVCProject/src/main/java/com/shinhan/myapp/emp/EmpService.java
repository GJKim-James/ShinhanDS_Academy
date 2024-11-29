package com.shinhan.myapp.emp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	
	@Autowired
	EmpDAO empDAO;
//	EmpDAO empDAO = new EmpDAO();
	
	public List<EmpDTO> selectAllService() {
		return empDAO.selectAll();
	}

	public EmpDTO selectByIdService(int empId) {
		return empDAO.selectById(empId);
	}
	
	public int insertService(EmpDTO emp) {
		return empDAO.insert(emp);
	}
	
	public int updateService(EmpDTO emp) {
		return empDAO.update(emp);
	}

	public int deleteService(int empId) {
		return empDAO.delete(empId);
	}

	public List<EmpDTO> selectByDeptId(int deptId) {
		return empDAO.selectByDeptId(deptId);
	}
	
	public List<EmpDTO> selectByJobId(String jobId) {
		return empDAO.selectByJobId(jobId);
	}

	public List<EmpDTO> selectBySalary(int salary) {
		return empDAO.selectBySalary(salary);
	}

	public List<EmpDTO> selectByCondition(Map<String, Object> map) {
		return empDAO.selectByCondition(map);
	}
	
}

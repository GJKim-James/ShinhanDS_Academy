package com.firstzone.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shinhan.util.DBUtil;

// DAO(Data Access Object)
// Service -> DB -> Service
public class EmpDAO {
	
	// 1.조회
	public List<EmpDTO> selectAll() {
		// 모든 직원 정보 조회
		String sql = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID";

		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		List<EmpDTO> empList = new ArrayList<EmpDTO>();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);

				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

//		for (EmpDTO emp : empList) {
//			System.out.println(emp);
//		}

		return empList;
	}

	// 2.입력
	public int insert(EmpDTO emp) {
		int result = 0;

		String sql = "INSERT INTO EMPLOYEES VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = DBUtil.getConnection();

		// Statement는 binding 변수 지원 안함, PreparedStatement는 binding 변수 지원함
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);

			// 숫자 : 물음표 순서
			st.setInt(1, emp.getEmployee_id());
			st.setString(2, emp.getFirst_name());
			st.setString(3, emp.getLast_name());
			st.setString(4, emp.getEmail());
			st.setString(5, emp.getPhone_number());
			st.setDate(6, emp.getHire_date());
			st.setString(7, emp.getJob_id());
			st.setDouble(8, emp.getSalary());
			st.setDouble(9, emp.getCommission_pct());
			st.setObject(10, emp.getManager_id() == -1 ? null : emp.getManager_id());
			st.setObject(11, emp.getDepartment_id() == -1 ? null : emp.getDepartment_id());

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, null);
		}

		return result;
	}

	// 3.수정
	public int update(EmpDTO emp) {
		int result = 0;

		String sql = """
				UPDATE EMPLOYEES
				SET FIRST_NAME = ?,
					LAST_NAME = ?,
					EMAIL = ?,
					PHONE_NUMBER = ?,
					HIRE_DATE = ?,
					JOB_ID = ?,
					SALARY = ?,
					COMMISSION_PCT = ?,
					MANAGER_ID = ?,
					DEPARTMENT_ID = ?
				WHERE EMPLOYEE_ID = ?
				""";

		Connection conn = DBUtil.getConnection();

		// Statement는 binding 변수 지원 안함, PreparedStatement는 binding 변수 지원함
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);

			// 숫자 : 물음표 순서
			st.setInt(11, emp.getEmployee_id());
			st.setString(1, emp.getFirst_name());
			st.setString(2, emp.getLast_name());
			st.setString(3, emp.getEmail());
			st.setString(4, emp.getPhone_number());
			st.setDate(5, emp.getHire_date());
			st.setString(6, emp.getJob_id());
			st.setDouble(7, emp.getSalary());
			st.setDouble(8, emp.getCommission_pct());
			st.setInt(9, emp.getManager_id() == -1 ? null : emp.getManager_id());
			st.setInt(10, emp.getDepartment_id() == -1 ? null : emp.getDepartment_id());

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, null);
		}

		return result;
	}

	// 4.삭제
	public int delete(int empId) {
		int result = 0;

		String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";

		Connection conn = DBUtil.getConnection();

		// Statement는 binding 변수 지원 안함, PreparedStatement는 binding 변수 지원함
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(sql);
			
			// 숫자 : 물음표 순서
			st.setInt(1, empId);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, null);
		}
		
		return result;
	}

	// 5.상세보기
	public EmpDTO selectById(int empId) {
		// 특정 직원 정보 조회
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " + empId;

		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		EmpDTO emp = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return emp;
	}
	
	// 6.특정 부서의 직원 조회 : WHERE DEPARTMENT_ID = ?
	public List<EmpDTO> selectByDeptId(int deptId) {
		String sql = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = ?";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<EmpDTO> empList = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql); // SQL문 준비
			st.setInt(1, deptId); // SQL문의 ?에 값 넣기
			rs = st.executeQuery(); // DB에 가서 SQL문 실행하고 결과(ResultSet 형태) 가져오기

			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return empList;
	}
	
	// 7.특정 JOB_ID인 직원 조회 : WHERE JOB_ID = ?
	public List<EmpDTO> selectByJobId(String jobId) {
		String sql = "SELECT * FROM EMPLOYEES WHERE JOB_ID = ?";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<EmpDTO> empList = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql); // SQL문 준비
			st.setString(1, jobId); // SQL문의 ?에 값 넣기
			rs = st.executeQuery(); // DB에 가서 SQL문 실행하고 결과(ResultSet 형태) 가져오기

			while (rs.next()) {
				EmpDTO emp = makeEmp2(rs);
				
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return empList;
	}
	
	// 8.급여가 ? 이상인 직원 조회 : WHERE SALARY >= ?
	public List<EmpDTO> selectBySalary(int salary) {
		String sql = "SELECT * FROM EMPLOYEES WHERE SALARY >= ?";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<EmpDTO> empList = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql); // SQL문 준비
			st.setInt(1, salary); // SQL문의 ?에 값 넣기
			rs = st.executeQuery(); // DB에 가서 SQL문 실행하고 결과(ResultSet 형태) 가져오기

			while (rs.next()) {
				EmpDTO emp = makeEmp2(rs);
				
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return empList;
	}
	
	// 9.부서, 직책, 급여, 입사일 조건으로 조회 : WHERE DEPARTMENT_ID = ? AND JOB_ID = ? AND SALARY >= ? AND HIRE_DATE >= ?
	public List<EmpDTO> selectByCondition(Map<String, Object> map) {
		String sql = """
				SELECT * FROM EMPLOYEES WHERE ('-1' = ? or DEPARTMENT_ID = ?) AND ('-1' = ? or JOB_ID = ?) 
				AND SALARY >= ? AND HIRE_DATE >= ?
				""";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<EmpDTO> empList = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql); // SQL문 준비
			
			// Key 이름 설정 시 대소문자 구분 주의!
			st.setInt(1, (Integer) map.get("DEPARTMENT_ID"));
			st.setInt(2, (Integer) map.get("DEPARTMENT_ID"));
			st.setString(3, (String) map.get("JOB_ID"));
			st.setString(4, (String) map.get("JOB_ID"));
			st.setDouble(5, (Double) map.get("SALARY"));
			st.setDate(6, (Date) map.get("HIRE_DATE"));
			
			rs = st.executeQuery(); // DB에 가서 SQL문 실행하고 결과(ResultSet 형태) 가져오기

			while (rs.next()) {
				EmpDTO emp = makeEmp2(rs);
				
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return empList;
	}

	private static EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();

		emp.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
		emp.setFirst_name(rs.getString("FIRST_NAME"));
		emp.setLast_name(rs.getString("LAST_NAME"));
		emp.setEmail(rs.getString("EMAIL"));
		emp.setPhone_number(rs.getString("PHONE_NUMBER"));
		emp.setHire_date(rs.getDate("HIRE_DATE"));
		emp.setJob_id(rs.getString("JOB_ID"));
		emp.setSalary(rs.getDouble("SALARY"));
		emp.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
		emp.setManager_id(rs.getInt("MANAGER_ID"));
		emp.setDepartment_id(rs.getInt("DEPARTMENT_ID"));

		return emp;
	}
	
	// Builder 사용하기
	private static EmpDTO makeEmp2(ResultSet rs) throws SQLException {
		EmpDTO emp = EmpDTO.builder()
				.employee_id(rs.getInt("EMPLOYEE_ID"))
				.first_name(rs.getString("FIRST_NAME"))
				.last_name(rs.getString("LAST_NAME"))
				.email(rs.getString("EMAIL"))
				.phone_number(rs.getString("PHONE_NUMBER"))
				.hire_date(rs.getDate("HIRE_DATE"))
				.job_id(rs.getString("JOB_ID"))
				.salary(rs.getDouble("SALARY"))
				.commission_pct(rs.getDouble("COMMISSION_PCT"))
				.manager_id(rs.getInt("MANAGER_ID"))
				.department_id(rs.getInt("DEPARTMENT_ID"))
				.build();

		return emp;
	}

}

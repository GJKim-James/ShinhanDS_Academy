package com.firstzone.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class DeptDAO {

	String sqlSelectAll = "SELECT * FROM DEPARTMENTS";
	String sqlSelectById = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
	String sqlInsert = "INSERT INTO DEPARTMENTS VALUES(?, ?, ?, ?)";
	String sqlUpdate = """
			UPDATE DEPARTMENTS
			SET DEPARTMENT_NAME = ?,
			    MANAGER_ID = ?,
			    LOCATION_ID = ?
			WHERE DEPARTMENT_ID = ?
			""";
	String sqlDelete = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;

	// 1. 모든 부서 정보 조회
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptList = new ArrayList<>();

		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sqlSelectAll);
			rs = st.executeQuery();

			while (rs.next()) {
				DeptDTO dept = makeDept(rs);

				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return deptList;
	}

	// 2. 특정 부서 정보 조회(상세보기)
	public DeptDTO selectById(int deptId) {
		conn = DBUtil.getConnection();
		DeptDTO dept = null;

		try {
			st = conn.prepareStatement(sqlSelectById);
			st.setInt(1, deptId);
			rs = st.executeQuery();

			while (rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);;
		}

		return dept;
	}

	// 3. 입력
	public int insert(DeptDTO dept) {
		int result = 0;
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlInsert);
			st.setInt(1, dept.getDept_id());
			st.setString(2, dept.getDept_name());
			st.setInt(3, dept.getManager_id());
			st.setInt(4, dept.getLocation_id());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, null);
		}
		
		return result;
	}

	// 4. 수정
	public int update(DeptDTO dept) {
		int result = 0;
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlUpdate);
			st.setString(1, dept.getDept_name());
			st.setInt(2, dept.getManager_id());
			st.setInt(3, dept.getLocation_id());
			st.setInt(4, dept.getDept_id());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, null);
		}
		
		return result;
	}

	// 5. 삭제
	public int delete(int deptId) {
		int result = 0;
		
		conn = DBUtil.getConnection();
		
		try {
			conn.setAutoCommit(false); // 자동으로 커밋 안함; 내가 커밋을 해줘야함
			st = conn.prepareStatement(sqlDelete);
			st.setInt(1, deptId);
			
			result = st.executeUpdate();
			
			conn.commit(); // 커밋을 직접 해줘야함; DB에 반영한다.
		} catch (SQLException e) {
			try {
				conn.rollback(); // 에러가 발생할 경우 롤백; DB에 작업한 내용 취소
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, null);
		}
		
		return result;
	}
	
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dept = new DeptDTO();

		dept.setDept_id(rs.getInt("DEPARTMENT_ID"));
		dept.setDept_name(rs.getString("DEPARTMENT_NAME"));
		dept.setManager_id(rs.getInt("MANAGER_ID"));
		dept.setLocation_id(rs.getInt("LOCATION_ID"));
		
		return dept;
	}

}

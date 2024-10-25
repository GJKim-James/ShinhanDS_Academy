package com.shinhan.day16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 자바 코드 실행 시 DB 연결하여 SQL문 실행 후 결과 받기
public class DBConnectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "hr", userPassword = "hr";
		String sql = """
				SELECT *
				FROM EMPLOYEES
				WHERE HIRE_DATE BETWEEN '2005-01-01' AND '2005-12-31'
				AND DEPARTMENT_ID IN (30, 50, 80)
				AND SALARY BETWEEN 10000 AND 17000
				AND COMMISSION_PCT IS NOT NULL
				ORDER BY HIRE_DATE ASC, SALARY DESC
				""";
	
		// 1. Driver Load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. Driver Load Success!");

			conn = DriverManager.getConnection(url, userId, userPassword);
			System.out.println("2. DB Connection Success!");

			st = conn.createStatement();
			System.out.println("3. SQL문 전송 통로 생성 Success!");
			System.out.println();
			
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("직원 번호 : " + rs.getInt("EMPLOYEE_ID"));
				System.out.println("FIRST_NAME : " + rs.getString("FIRST_NAME"));
				System.out.println("LAST_NAME : " + rs.getString("LAST_NAME"));
				System.out.println("SALARY : " + rs.getInt("SALARY"));
				System.out.println("COMMISSION_PCT : " + rs.getDouble("COMMISSION_PCT"));
				System.out.println("HIRE_DATE : " + rs.getDate("HIRE_DATE"));
				System.out.println("------------------------------");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void f1() throws ClassNotFoundException, SQLException {
		// 0. Class Path 지정
		// 프로젝트 우클릭 > Build Path > Configure Build Path... > Libraries > Classpath에 추가
		// C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib에서 ojdbc6_g.jar 추가

		// 1. Driver Load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Load 성공");

		// 2. DB 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr", password = "hr";

		Connection conn = DriverManager.getConnection(url, id, password);
		System.out.println("DB 연결 성공");

		// 3. 대화 통로 생성
		Statement st = conn.createStatement();
		System.out.println("SQL문 전송 통로 생성");
		System.out.println();

		String sql = "SELECT * FROM EMPLOYEES WHERE SALARY >= 15000";

		// Select 실행 결과는 ResultSet으로 옴
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.out.println("직원 번호 : " + rs.getInt(1)); // 첫 번째 필드를 Integer형으로 받겠다
			System.out.println("직원 이름 : " + rs.getString("FIRST_NAME"));
			System.out.println("급여 : " + rs.getDouble("SALARY"));
			System.out.println("입사일 : " + rs.getDate("HIRE_DATE"));
			System.out.println("------------------------------");
		}

		rs.close();
		st.close();
		conn.close();
	}

}

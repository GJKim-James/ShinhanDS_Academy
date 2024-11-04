package com.firstzone.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 실행 시 DB 연결 및 CRUD 작업
public class DBConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 0. Classpath에 JDBC 라이브러리 추가
		// C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib에서 ojdbc6_g.jar 추가

		// 1. Driver Load
		Class.forName("oracle.jdbc.OracleDriver");

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

package com.firstzone.job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class JobDAO {

	// JOBS 테이블 조회
	public List<JobDTO> selectAllJobs() {
		String sql = "SELECT * FROM JOBS";

		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		List<JobDTO> jobList = new ArrayList<JobDTO>();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				JobDTO jobDTO = makeJobs(rs);

				jobList.add(jobDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

//			for (jobDTO job : jobList) {
//				System.out.println(job);
//			}

		return jobList;
	}

	// Builder 사용하기
	private static JobDTO makeJobs(ResultSet rs) throws SQLException {
		JobDTO jobDTO = JobDTO.builder()
				.job_id(rs.getString("JOB_ID"))
				.job_title(rs.getString("JOB_TITLE"))
				.min_salary(rs.getInt("MIN_SALARY"))
				.max_salary(rs.getInt("MAX_SALARY"))
				.build();

		return jobDTO;
	}

}

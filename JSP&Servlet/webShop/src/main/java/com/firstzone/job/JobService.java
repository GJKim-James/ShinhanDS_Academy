package com.firstzone.job;

import java.util.List;

public class JobService {

	JobDAO jobDAO = new JobDAO();

	// 모든 JOBS 정보 조회
	public List<JobDTO> selectAllJobs() {
		return jobDAO.selectAllJobs();
	}

}

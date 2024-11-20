package com.shinhan4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;
import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;
import com.firstzone.job.JobDTO;
import com.firstzone.job.JobService;
import com.firstzone.member.MemberDTO;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class EmpListServlet
 * Servlet : 사용자의 요청을 받아서 처리 가능한 서버에서 실행되는 자바 클래스
 */
@WebServlet("/jsp/emp/emplist2.do")
public class EmpListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptid = request.getParameter("deptid");
		String jobid = request.getParameter("jobid");
		String salary = request.getParameter("salary");
		String hiredate = request.getParameter("hiredate");
		String chkdate = request.getParameter("chkdate");
		System.out.println("========== 검색할 조건 값 ==========");
		System.out.println("dept_id : " + deptid);
		System.out.println("job_id : " + jobid);
		System.out.println("salary : " + salary);
		System.out.println("hiredate : " + hiredate);
		System.out.println("chkdate : " + chkdate);
		System.out.println("=================================");
		
		Map<String, Object> empMap = new HashMap<>();
		// Key 이름 설정 시 대소문자 구분 주의!
		empMap.put("DEPARTMENT_ID", Integer.parseInt(deptid));
		empMap.put("JOB_ID", jobid);
		empMap.put("SALARY", Double.parseDouble(salary));
		if (chkdate.equals("true") || hiredate == "" || hiredate == null) {
			hiredate = "1900-01-01";
		}
		empMap.put("HIRE_DATE", DateUtil.convertSqlDate(DateUtil.convertDate(hiredate)));
		System.out.println("empMap : " + empMap);
		
		EmpService empService = new EmpService();
		List<EmpDTO> empList = empService.selectByCondition(empMap);
		
		System.out.println("empList 건수 : " + empList.size());
		
		// 1. HTML 만들까? NO
		// 2. ajax에서 결과값을 받아서 jquery로 HTML 만들까? NO
		// 3. JSP를 만들고 JSP 자체를 결과값으로 넘기기? YES; forward
		request.setAttribute("empDatas", empList);
		request.getRequestDispatcher("empListTable.jsp").forward(request, response);
	}

}

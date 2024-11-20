package com.shinhan4.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;
import com.firstzone.emp.EmpDTO;
import com.firstzone.emp.EmpService;
import com.firstzone.job.JobDTO;
import com.firstzone.job.JobService;
import com.shinhan.util.DateUtil;

@WebServlet("/empdetail.do")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 방식 : " + request.getMethod());
		
		int emp_id = Integer.parseInt(request.getParameter("empid"));
		
		EmpService empService = new EmpService();
		EmpDTO empDTO = empService.selectByIdService(emp_id);
		
		request.setAttribute("empDTO", empDTO);
		
		JobService jobService = new JobService();
		DeptService deptService = new DeptService();
		
		List<JobDTO> jobList = jobService.selectAllJobs();
		List<DeptDTO> deptList = deptService.selectAll();
		List<EmpDTO> empList = empService.selectAllService();
		
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("empList", empList);
		
		request.getRequestDispatcher("jsp/emp/empDetail.jsp").forward(request, response);
		System.out.println("==============================");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 방식 : " + request.getMethod());
		
		// 한글 인코딩
		// 2024. 11. 20 필터로 작성
//		request.setCharacterEncoding("UTF-8");
		
		EmpDTO empDTO = makeEmp(request);
		EmpService empService = new EmpService();
		int result = empService.updateService(empDTO);
		
		System.out.println(result + "건 수정");
		
		response.sendRedirect("jsp/emp/emplist.do");
		System.out.println("==============================");
	}

	private EmpDTO makeEmp(HttpServletRequest request) {
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		Date hire_date = DateUtil.convertSqlDate(DateUtil.convertDate(request.getParameter("hire_date")));
		String job_id = request.getParameter("job_id");
		
		String str_salary = request.getParameter("salary");
		double salary = 0.0;
		if (str_salary != "" && str_salary != null) {
			salary = Double.parseDouble(str_salary);
		}
		
		String str_commission = request.getParameter("commission_pct");
		double commission_pct = 0.0;
		if (str_commission != "" && str_commission != null) {
			commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
		}
		
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		System.out.println("========== form 태그로부터 받은 수정된 정보 ==========");
		System.out.println("employee_id : " + employee_id);
		System.out.println("first_name : " + first_name);
		System.out.println("last_name : " + last_name);
		System.out.println("email : " + email);
		System.out.println("phone_number : " + phone_number);
		System.out.println("hire_date : " + hire_date);
		System.out.println("job_id : " + job_id);
		System.out.println("salary : " + salary);
		System.out.println("commission_pct : " + commission_pct);
		System.out.println("manager_id : " + manager_id);
		System.out.println("department_id : " + department_id);
		System.out.println("================================================");
		
		EmpDTO empDTO = new EmpDTO().builder()
				.employee_id(employee_id)
				.first_name(first_name)
				.last_name(last_name)
				.email(email)
				.phone_number(phone_number)
				.hire_date(hire_date)
				.job_id(job_id)
				.salary(salary)
				.commission_pct(commission_pct)
				.manager_id(manager_id)
				.department_id(department_id)
				.build();
		
		return empDTO;
	}

}

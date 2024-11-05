<%@page import="com.firstzone.dbtest.EmpService"%>
<%@page import="com.firstzone.dbtest.EmpDTO"%>
<%@page import="com.shinhan.util.DateUtil"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#container {
		margin: 0 auto;
		border: 1px solid gray;
		width: 1100px;
	}
	table, tr, th, td {
		border: 1px solid gray;
		border-collapse: collapse;
		margin: 5px auto;
		padding: 5px;
	}
	h1 {
		text-align: center;
	}
	tr:first-child {
		background-color: lightgray;
	}
	tr:last-child {
		text-align: right;
	}
</style>
</head>
<body>
	<div id="container">
		<h1>신규 직원 DB에 저장하기</h1>
		<%
			/*
			get 방식은 URL 주소창에 data 가 넘어온다. 이때 자동으로 Encoding 된다.
			자바에서 읽으면 자동으로 decoding 된다.
			post 방식은 요청 문서의 body 에 숨겨서 서버에 전달된다.(Encoding 안됨)
			서버에서 그대로 읽으면 한글 깨짐
			post 일 때 반드시 Encoding 설정 후 읽는다.
			*/
			request.setCharacterEncoding("UTF-8");
		
			int emp_id = Integer.parseInt(request.getParameter("employee_id"));
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String email = request.getParameter("email");
			String phone_number = request.getParameter("phone_number");
			Date hire_date = DateUtil.convertSqlDate(DateUtil.convertDate(request.getParameter("hire_date")));
			String job_id = request.getParameter("job_id");
			double salary = Double.parseDouble(request.getParameter("salary"));
			double commission = Double.parseDouble(request.getParameter("commission_pct"));
			int mgr_id = Integer.parseInt(request.getParameter("manager_id"));
			int dept_id = Integer.parseInt(request.getParameter("department_id"));
			
			EmpDTO empDTO = EmpDTO.builder()
					.employee_id(emp_id)
					.first_name(first_name)
					.last_name(last_name)
					.email(email)
					.phone_number(phone_number)
					.hire_date(hire_date)
					.job_id(job_id)
					.salary(salary)
					.commission_pct(commission)
					.manager_id(mgr_id)
					.department_id(dept_id)
					.build();
			EmpService empService = new EmpService();
			empService.insertService(empDTO);
		%>
		<table>
			<tr>
				<th>직원 번호</th>
				<th>FIRST_NAME</th>
				<th>LAST_NAME</th>
				<th>이메일</th>
				<th>핸드폰 번호</th>
				<th>입사일</th>
				<th>JOB_ID</th>
				<th>급여</th>
				<th>커미션</th>
				<th>상사 번호</th>
				<th>부서 번호</th>
			</tr>
			<tr>
				<td><%=emp_id %></td>
				<td><%=first_name %></td>
				<td><%=last_name %></td>
				<td><%=email %></td>
				<td><%=phone_number %></td>
				<td><%=hire_date %></td>
				<td><%=job_id %></td>
				<td><%=salary %></td>
				<td><%=commission %></td>
				<td><%=mgr_id %></td>
				<td><%=dept_id %></td>
			</tr>
			<tr>
				<td colspan="11"><a href="/appleShop/emp/empAll.jsp">직원조회업무(절대경로)</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
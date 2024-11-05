<%@page import="com.firstzone.job.JobDTO"%>
<%@page import="com.firstzone.job.JobService"%>
<%@page import="com.firstzone.dbtest.EmpDTO"%>
<%@page import="com.firstzone.dbtest.EmpService"%>
<%@page import="com.firstzone.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.dept.DeptService"%>
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
	width: 500px;
}

h1 {
	text-align: center;
	background-color: green;
	color: white;
}

input, select {
	width: 200px;
	box-sizing: border-box;
}

label {
	background-color: lightgreen;
	display: inline-block;
	width: 150px; /* width 속성은 inline에서 사용 불가, block 요소에서만 가능 */
}

#btn_submit {
	text-align: right;
	padding: 10px;
}

input[required], select[required] {
	border: 3px dotted red;
}
</style>
</head>
<body>
	<div id="container">
		<h1>직원 등록</h1>
		<!-- /로 시작하면 절대 경로
			 / 시작 아니면 상대 경로(./ 생략됨)
			 
			 get 방식은 URL 주소창에 data 가 넘어온다. 이때 자동으로 Encoding 된다.
			 자바에서 읽으면 자동으로 decoding 된다.
			 post 방식은 요청 문서의 body 에 숨겨서 서버에 전달된다.(Encoding 안됨)
			 서버에서 그대로 읽으면 한글 깨짐
			 post 일 때 반드시 Encoding 설정 후 읽는다.
		 -->
		<form action="empRegister.jsp" method="post">
			<label>직원 번호 : </label><input type="number" name="employee_id" autofocus="autofocus"><br>
			<label>firstName : </label><input type="text" name="first_name"><br>
			<label>lastName : </label><input type="text" name="last_name" required="required"><br>
			<label>이메일 : </label><input type="text" name="email" required="required"><br>
			<label>핸드폰 번호 : </label><input type="text" name="phone_number"><br>
			<label>입사일 : </label><input type="date" name="hire_date" required="required"><br>
			
			<label>jobId : </label><select name="job_id" required="required">
				<%
				JobService jobService = new JobService();
				List<JobDTO> jobList = jobService.selectAllJobs();
				for (JobDTO job : jobList) {
				%>
				<option value="<%=job.getJob_id() %>">
					<%=job.getJob_id() %> (<%=job.getJob_title() %>)
				</option>
				<% } %>
			</select>
			<br>
			
			<label>급여 : </label><input type="number" name="salary" placeholder="> 0"><br>
			<label>커미션 : </label><input type="text" name="commission_pct" placeholder="0.1"><br>
			
			<label>상사 번호 : </label><select name="manager_id">
				<%
				EmpService empService = new EmpService();
				List<EmpDTO> empList = empService.selectAllService();
				for (EmpDTO emp : empList) {
				%>
				<option value="<%=emp.getManager_id() %>">
					<%=emp.getFirst_name() %> <%=emp.getLast_name() %> (<%=emp.getEmployee_id() %>)
				</option>
				<% } %>
			</select>
			<br>
			
			<label>부서 번호 : </label><select name="department_id">
				<%
				DeptService deptService = new DeptService();
				List<DeptDTO> deptList = deptService.selectAll();
				for (DeptDTO dept : deptList) {
				%>
				<option value="<%=dept.getDept_id() %>">
					<%=dept.getDept_name() %> (<%=dept.getDept_id() %>)
				</option>
				<% } %>
			</select>
			<br>
			
			<div id="btn_submit">
				<input type="submit" value="직원 저장">
			</div>
		</form>
	</div>
</body>
</html>
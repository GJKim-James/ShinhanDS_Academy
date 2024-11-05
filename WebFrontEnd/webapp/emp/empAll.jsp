<%@page import="com.firstzone.dbtest.EmpService"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.dbtest.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empAll.jsp</title>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<style type="text/css">
#container {
	margin: 0 auto;
	padding: 5px 0;
	border: 1px solid gray;
	width: 1300px;
}

span {
	color: red;
}

table, tr, th, td {
	margin: 0 auto;
	padding: 5px;
	border: 1px solid black;
	border-collapse: collapse;
}

h1 {
	text-align: center;
	font-family: "Nanum Pen Script", cursive;
	font-weight: bold;
	font-style: normal;
	font-size: 3em;
}

a.new {
	display: block;
	padding: 10px;
}

/* tag 이름 사이의 공백은 자손을 의미 */
tbody tr:nth-child(2n) {
	background-color: lightgray;
}

tbody tr:nth-child(2n+1) {
	background-color: lightgreen;
}
</style>
</head>
<body>
	<div id="container">
		<header>
			<h1>
				다음의 목록은 <span>직원 정보</span>입니다.
			</h1>
		</header>

		<main>
			<section>
				<div>
					<h1>직원 목록</h1>

					<table>
						<thead>
							<tr>
								<td colspan="11">
									<a href="empInsert.jsp" class="new">신규 직원 등록하기</a>
									<a href="../dept/deptInsert.jsp" class="new">신규 부서 등록하기</a>
								</td>
							</tr>
							<tr>
								<th>employee_id</th>
								<th>first_name</th>
								<th>last_name</th>
								<th>email</th>
								<th>phone_number</th>
								<th>hire_date</th>
								<th>job_id</th>
								<th>salary</th>
								<th>commission_pct</th>
								<th>manager_id</th>
								<th>department_id</th>
							</tr>
						</thead>

						<tbody>
							<%
							EmpService empService = new EmpService();
							List<EmpDTO> empList = empService.selectAllService();
							for (EmpDTO emp : empList) {
							%>
							<tr>
								<td><%=emp.getEmployee_id()%></td>
								<td><%=emp.getFirst_name()%></td>
								<td><%=emp.getLast_name()%></td>
								<td><%=emp.getEmail()%></td>
								<td><%=emp.getPhone_number()%></td>
								<td><%=emp.getHire_date()%></td>
								<td><%=emp.getJob_id()%></td>
								<td><%=emp.getSalary()%></td>
								<td><%=emp.getCommission_pct()%></td>
								<td><%=emp.getManager_id()%></td>
								<td><%=emp.getDepartment_id()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</section>
		</main>

	</div>
</body>
</html>
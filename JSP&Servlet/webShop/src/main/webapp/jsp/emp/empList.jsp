<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원 목록</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<style type="text/css">
	.container {
		text-align: center;
	}
	</style>
</head>
<body>
	<div class="container">
		<%-- <p>로그인한 Member 정보(request) : ${loginMember1}</p> --%>
		<p>로그인한 Member 정보(session) : ${loginMember2}</p>
		<%-- <p>로그인한 Member 정보(context) : ${loginMember3}</p> --%>
		
		<h1>직원 목록</h1>
		<%-- ${empDatas} --%>
	
		<table class="table table-striped table-hover">
			<tr>
				<th>직원 번호</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직책</th>
				<th>급여</th>
				<th>커미션</th>
				<th>매니저 번호</th>
				<th>부서 번호</th>
				<th>GET 요청</th>
				<th>POST 요청</th>
			</tr>
			
			<c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>
			<c:forEach items="${empDatas}" var="emp">
				<tr>
					<td><a href="${path}/empdetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
					<td>${emp.first_name}</td>
					<td>${emp.last_name}</td>
					<td>${emp.email}</td>
					<td>${emp.phone_number}</td>
					<td>${emp.hire_date}</td>
					<td>${emp.job_id}</td>
					<td>${emp.salary}</td>
					<td>${emp.commission_pct}</td>
					<td>${emp.manager_id}</td>
					<td>${emp.department_id}</td>
					
					<td><button onclick="location.href='${path}/empdelete.do?empid=${emp.employee_id}'" class="btn btn-dark">삭제</button></td>
					<td>
						<form action="${path}/empdelete.do" method="post">
							<input type="hidden" name="empid" value="${emp.employee_id}">
							<button class="btn btn-dark">삭제</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
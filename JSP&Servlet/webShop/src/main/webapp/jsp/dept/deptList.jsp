<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- prefix : taglib는 XML 문법을 사용하기 때문에 태그 이름을 마음대로 사용한다. HTML 태그와 충돌 가능성이 있다.
			  그래서 prefix로 taglib의 태그라는 것을 표시해줌.
 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 목록 조회</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<style type="text/css">
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 5px;
		text-align: center;
	}
	</style>
</head>
<body>
	<h1>부서 목록</h1>
	<hr>
	
	<table>
		<tr>
			<th>부서 번호</th>
			<th>부서 이름</th>
			<th>매니저 번호</th>
			<th>지역 번호</th>
		</tr>
		<%-- items : getAttribute("deptDatas") --%>
		<c:forEach items="${deptDatas}" var="dept">
		<tr>
			<c:set value="${pageContext.request.servletContext.contextPath}" var="contextPath"></c:set>
			<td><a href="${contextPath}/deptdetail.do?deptid=${dept.dept_id}">${dept.dept_id}</a></td>
			<td>${dept.dept_name}</td>
			<td>${dept.manager_id}</td>
			<td>${dept.location_id}</td>
			<td><button onclick="location.href='deptdelete.do?deptid=${dept.dept_id}'" class="btn btn-dark">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
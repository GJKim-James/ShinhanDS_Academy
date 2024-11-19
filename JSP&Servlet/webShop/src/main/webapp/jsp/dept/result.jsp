<%@page import="com.firstzone.dept.DeptDTO"%>
<%@page import="com.firstzone.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="1;url=deptlist.do">
<title>부서 등록 결과</title>
</head>
<body>
	${resultMessage}
	<table>
		<tr>
			<th>부서 번호</th>
			<th>부서 이름</th>
			<th>매니저 번호</th>
			<th>지역 번호</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</body>
</html>
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
	caption {
		color: pink;
		font-size: 30px;
		font-weight: bold;
		padding: 10px 0 10px 0;
	}
	table, caption, tr, th, td {
		margin: 0 auto;
		border: 1px solid black;
		border-collapse: collapse;
	}
	thead { background-color: aqua; }
	#cups {
		margin: 0 auto;
		padding: 5px;
		border: 1px solid gray;
		width: 506px;
	}
</style>
</head>
<body>
	<div id="cups">
		<!-- HTML(HTML 해석기가 해석을 하지 않기)
		상대 경로 : 나의 문서를 기준
		절대 경로 : http://localhost:9090 이후 작성 /부터 시작
				  /appleShop의 위치는 webapp 폴더
		 -->
		<img alt="둥근 컵 이미지" src="../resources/images/cup-2.jpg" width="250" height="170">
		<img alt="둥근 컵 이미지" src="../resources/images/cup-3.jpg" width="250" height="170">
	</div>
	
	<table>
		<caption>부서 목록</caption>
		
		<thead>
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>매니저 번호</th>
				<th>지역 번호</th>
			</tr>
		</thead>
		
		<tbody>
			<%
			DeptService deptService = new DeptService();
			List<DeptDTO> deptList = deptService.selectAll();
			for (DeptDTO dept : deptList) {
			%>
			<tr>
				<td><%=dept.getDept_id() %></td>
				<td><%=dept.getDept_name() %></td>
				<td><%=dept.getManager_id() %></td>
				<td><%=dept.getLocation_id() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>
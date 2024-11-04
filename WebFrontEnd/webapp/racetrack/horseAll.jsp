<%@page import="racetrack.Horse_DTO"%>
<%@page import="java.util.List"%>
<%@page import="racetrack.RaceTrack_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, caption, tr, th, td {
		margin: 0 auto;
		border: 1px solid black;
		border-collapse: collapse;
	}
	caption {
		width: 500px;
		font-size: 30px;
		font-weight: bold;
	}
</style>
</head>
<body>
	<table>
		<caption>경마장 말 List</caption>
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
		</thead>
		
		<tbody>
			<%
			RaceTrack_DAO dao = new RaceTrack_DAO();
			List<Horse_DTO> horseList = dao.getAllHorses();
			for (Horse_DTO horse : horseList) {
			%>
			<tr>
				<td><%=horse.getHorse_id() %></td>
				<td><%=horse.getHorse_name() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>
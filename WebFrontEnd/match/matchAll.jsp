<%@page import="soccer.match.dto.MatchListDTO"%>
<%@page import="java.util.List"%>
<%@page import="soccer.match.service.AdminService"%>
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
		color: white;
		font-size: 30px;
		font-weight: bold;
		padding: 10px 0 10px 0;
		background-color: green;
	}
	#stadium_img {
		margin-top: 20px;
		width: 800px;
	}
</style>
</head>
<body>
	<table>
		<caption>경기 목록</caption>
		
		<thead>
			<tr>
				<th>경기 번호</th>
				<th>경기 일시</th>
				<th>경기 장소</th>
				<th>신청 마감 여부(0 : 신청 가능, 1 : 신청 마감)</th>
				<th>신청 가격(원)</th>
				<th>신청 가능한 인원 수</th>
			</tr>
		</thead>
		
		<tbody>
			<%
			AdminService adminService = new AdminService();
			List<MatchListDTO> matchList = adminService.selectAll();
			for (MatchListDTO match : matchList) {
			%>
			<tr>
				<td><%=match.getMatch_no() %></td>
				<td><%=match.getMatch_date() %></td>
				<td><%=match.getMatch_place() %></td>
				<td><%=match.getMatch_close() %></td>
				<td><%=match.getMatch_price() %></td>
				<td><%=match.getHead_count() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	<table id="stadium_img">
		<tr>
			<td><img alt="Tottenham Hotspur Stadium" src="../resources/images/tottenham.jpg" width="400px" height="300px"></td>
			<td><img alt="Tottenham Hotspur Stadium2" src="../resources/images/tottenham2.jpg" width="400px" height="300px"></td>
		</tr>
		<tr>
			<td><img alt="Tottenham Hotspur Stadium3" src="../resources/images/tottenham3.jpg" width="400px" height="300px"></td>
			<td><img alt="Tottenham Hotspur Stadium4" src="../resources/images/tottenham4.jpg" width="400px" height="300px"></td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/commonHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청 내역</title>
<link rel="stylesheet" href="${contextPath}/css/UserMyMatch.css">
</head>
<body>
	<div id="container">
		<table>
			<caption>신청 내역</caption>
			<thead>
				<tr>
					<th>경기 번호</th>
					<th>경기 일시</th>
					<th>경기 장소</th>
					<th>사용자 이름</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${myMatchInfoList}" var="matchinfolist" varStatus="status">
					<tr>
						<td>${ matchinfolist.match_no }</td>
						<td>${ matchinfolist.match_date }</td>
						<td>${ matchinfolist.match_place }</td>
						<td>${ matchinfolist.user_name }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
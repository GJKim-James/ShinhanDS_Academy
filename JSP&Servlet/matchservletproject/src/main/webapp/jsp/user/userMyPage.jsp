<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/commonHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보(마이페이지)</title>
<link rel="stylesheet" href="${contextPath}/css/UserMyPage.css">
</head>
<body>
	<div id="container">
		<table>
			<caption>내 정보</caption>
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>성별</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td>${ resultDTO.user_id }</td>
					<td>${ resultDTO.user_pw }</td>
					<td>${ resultDTO.user_name }</td>
					<td>${ resultDTO.user_gender }</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
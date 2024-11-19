<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<title>로그인 화면</title>
	<style type="text/css">
	input[type="submit"] {
		margin: 10px;
	}
	</style>
</head>
<body>
	<h1>Sign In</h1>
	<hr>
	
	<%-- JSP 주석
		 HTML, JSP : http://localhost:9090
		 상대 경로 : login.do
		 절대 경로 : http://localhost:9090/webShop/jsp/auth/login.do
		 
		 pageContext.request.servletContext.contextPath : /webShop
	 --%>
	 <c:set var="path" value="${pageContext.request.servletContext.contextPath}"></c:set>
	<form action="${path}/login.do" method="post">
		<label>사용자 아이디</label>
		<input type="text" name="userid" value="gjk0635"><br>
		<label>사용자 비밀번호</label>
		<input type="password" name="userpw" value="1234"><br>
		<input type="submit" value="로그인" class="btn btn-dark">
		<hr>
		
		<h2>parameter 연습</h2>
		<input type="radio" name="food" value="김밥">김밥
		<input type="radio" name="food" value="감자탕">감자탕
		<input type="radio" name="food" value="피자">피자
		
		<div>
			<input type="checkbox" name="food2" value="짜장면">짜장면
			<input type="checkbox" name="food2" value="짬뽕">짬뽕
			<input type="checkbox" name="food2" value="탕수육">탕수육
			<input type="checkbox" name="food2" value="탕수육">볶음밥
		</div>
	</form>
</body>
</html>
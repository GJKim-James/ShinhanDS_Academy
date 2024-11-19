<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main2.jsp</title>
</head>
<body>
	<p>JSP 파일에서 절대경로 /는 http://localhost:9090</p>
	<a href="first">first 접근(상대)</a>
	<a href="/first">first 잘못된 접근(절대)</a>
	<a href="/webShop/first">first 옳은 접근(절대)</a>
</body>
</html>
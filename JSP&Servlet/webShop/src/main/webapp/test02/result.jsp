<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="file1" value="bg.jpg" />
<c:set var="file2" value="tottenham3.jpg" />
<html>
<head>
<meta charset=”UTF-8">
<title>이미지 파일 출력하기</title>
</head>
<body>
	파라미터 1 : <c:out value="${file1}" /><br>
	파라미터 2 : <c:out value="${file2}" /><br>
	
	<a href="${contextPath}/download.do?fileName=${file1}">
		<img alt="bg.jpg" src="${contextPath}/uploadLocation/${file1}" width="500px" height="300px">
	</a>
	
	<a href="${contextPath}/download.do?fileName=${file2}">
		<img alt="bg.jpg" src="${contextPath}/uploadLocation/${file2}" width="500px" height="300px">
	</a>
</body>
</html>

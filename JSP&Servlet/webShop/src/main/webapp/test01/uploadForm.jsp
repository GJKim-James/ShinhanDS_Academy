<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<head>
<title>파일 업로드창</title>
</head>
<body>
	<%@ include file="../jsp/header.jsp" %>
	
	<%-- binary upload : 반드시 method="post", enctype이 multipart이어야 한다. --%>
	<form action="${path}/upload.do" method="post" enctype="multipart/form-data">
		파일1: <input type="file" name="file1"><br>
		파일2: <input type="file" name="file2"><br>
		파라미터1: <input type="text" name="param1"><br>
		파라미터2: <input	type="text" name="param2"><br>
		파라미터3: <input	type="text" name="param3"><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>범위</title>
</head>
<body>
	<%-- request 영역 > session 영역 > application(context) 영역 --%>
	<h2>EL(Expression Language)의 내장 객체</h2>
	1. ${company}<br>
	2. ${requestScope.company}<br>
	3. ${sessionScope.company}<br>
	4. ${applicationScope.company}
	<hr>
	
	<h2>JSP 내장 객체 이용 Expression</h2>
	2. <%=request.getAttribute("company") %><br>
	3. <%=session.getAttribute("company") %><br>
	4. <%=application.getAttribute("company") %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP Page</h1>
	<p><%=request.getParameter("myname") %></p>
	<p><%=request.getParameter("mymajor") %></p>
	<p><%=request.getParameter("myphone") %></p>
	<p><%=request.getParameter("myregister") %></p>
</body>
</html>
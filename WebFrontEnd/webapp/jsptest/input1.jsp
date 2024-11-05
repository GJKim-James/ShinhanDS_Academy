<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8"); /* get 방식 : 안써줘도 알아서 인코딩해서 전달, post 방식 : 써줘야 인코딩해서 전달 */
	String user_id = request.getParameter("userid");
	String user_name = request.getParameter("username");
	%>
	<p>당신의 아이디는 <%=user_id %></p>
	<p>당신의 이름은 <%=user_name %></p>
</body>
</html>
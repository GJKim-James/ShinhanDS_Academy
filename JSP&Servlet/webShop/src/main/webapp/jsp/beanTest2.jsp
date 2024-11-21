<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean Test2</title>
</head>
<body>
	<h1>Bean Test2(Bean Test에서 넘어옴)</h1>
	<jsp:useBean id="member2" class="com.firstzone.member.MemberDTO" scope="request"/>
	<%-- getProperty : getter 역할 --%>
	<p>id : <jsp:getProperty property="member_id" name="member2"/></p>
	<p>pw : <jsp:getProperty property="member_pw" name="member2"/></p>
	<p>name : <jsp:getProperty property="member_name" name="member2"/></p>
	<p>email : <jsp:getProperty property="member_email" name="member2"/></p>
</body>
</html>
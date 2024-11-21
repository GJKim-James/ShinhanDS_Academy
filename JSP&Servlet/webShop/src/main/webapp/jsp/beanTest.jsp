<%@page import="com.firstzone.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean Test</title>
</head>
<body>
	<h1>Bean Test</h1>
	<h2>JSP에서 자바 코드 작성(권장 안함)</h2>
	<%
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setMember_id("gjk0635");
	memberDTO.setMember_pw("1234");
	memberDTO.setMember_name("김광진");
	memberDTO.setMember_email("gjk0635@naver.com");
	%>
	<p>id : <%=memberDTO.getMember_id() %></p>
	<p>pw : <%=memberDTO.getMember_pw() %></p>
	<p>name : <%=memberDTO.getMember_name() %></p>
	<p>email : <%=memberDTO.getMember_email() %></p>
	<br>
	
	<h2>JSP에서 자바 Beans 사용(action tag)</h2>
	<%-- scope : 다른 JSP에서 사용 가능하게 해줌 --%>
	<jsp:useBean id="member2" class="com.firstzone.member.MemberDTO" scope="request"/>
	<%-- setProperty : setter 역할 --%>
	<jsp:setProperty property="member_id" name="member2" value="kim"/>
	<jsp:setProperty property="member_pw" name="member2" value="1234"/>
	<jsp:setProperty property="member_name" name="member2" value="김광진2"/>
	<jsp:setProperty property="member_email" name="member2" value="kim@naver.com"/>
	<%-- getProperty : getter 역할 --%>
	<p>id : <jsp:getProperty property="member_id" name="member2"/></p>
	<p>pw : <jsp:getProperty property="member_pw" name="member2"/></p>
	<p>name : <jsp:getProperty property="member_name" name="member2"/></p>
	<p>email : <jsp:getProperty property="member_email" name="member2"/></p>
	<br>
	
	<%-- inclue : beanTest2.jsp를 현재 페이지에 포함 --%>
	<jsp:include page="beanTest2.jsp"></jsp:include>
	
	<%-- forward : beanTest.jsp를 실행하면 beanTest2.jsp로 넘어감 --%>
<%-- 	<jsp:forward page="beanTest2.jsp"></jsp:forward> --%>
</body>
</html>
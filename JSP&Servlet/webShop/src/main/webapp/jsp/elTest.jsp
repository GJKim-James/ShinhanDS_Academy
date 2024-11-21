<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(Expression Language)</title>
</head>
<body>
	<h1>표현 언어(EL, Expression Language)</h1>
	<pre>
	1. 산술 연산자 : ${ 1 + 2 }
	2. 비교 연산자 : ${ 10 > 20 }
	3. 문자 + 숫자 : ${ "문자" }10 <%-- ${ "문자" + 10 } 불가 --%>
<%-- 	4. null 무시 : ${ null + 10 } --%>
	4. null 무시 : ${ null + "10" }
	5. empty : ${ empty "Hello" }
	5. empty : ${ empty 10 }
	5. empty : ${ empty null }
	<jsp:useBean id="member" class="com.firstzone.member.MemberDTO"/>
	<jsp:useBean id="member2" class="java.util.ArrayList"/>
	5. empty : ${ empty member }
	5. 값 확인(EL) : ${ member.member_id }
	5. 값 확인(스크립트릿) : <%=member.getMember_id() %>
	5. empty : ${ empty member2 }
	<%
	// JSP 내장 객체를 이용해서 값 저장하기
	pageContext.setAttribute("score1", 100);
	request.setAttribute("score2", 200);
	session.setAttribute("score3", 300);
	application.setAttribute("score4", 400);
	%>
	6. pageContext : ${ score1 }
	6. request : ${ score2 }
	6. session : ${ score3 }
	6. application : ${ score4 }
	<%
	// JSP 내장 객체를 이용해서 값 저장하기
	pageContext.setAttribute("score", 100);
	request.setAttribute("score", 200);
	session.setAttribute("score", 300);
	application.setAttribute("score", 400);
	%>
	6. pageContext : ${ score }
	6. request : ${ score }
	6. session : ${ score }
	6. application : ${ score }
	
	6. pageContext : ${ score }
	6. request : ${ requestScope.score }
	6. session : ${ sessionScope.score }
	6. application : ${ applicationScope.score }
	
	7. param 읽기(URL 뒤에 ?myname= 써서 확인) : ${ param.myname }
	7. param 읽기(URL 뒤에 ?myname=광진&myname2=James 써서 확인) : ${ param.myname2 }
	</pre>
	
	<%-- jQuery --%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
		$("h1").css("background-color", "lightyellow");
		
		var contextPath = "${pageContext.servletContext.contextPath}"; // var contextPath = "/webShop";
		
		<%-- 백틱; \$는 톰캣 서버가 해석하지 않고 브라우저가 해석함, $는 톰캣 서버가 해석함 --%>
		var str = `현재 어플리케이션의 path는 \${contextPath}`;
		console.log("str : " + str); // str : 현재 어플리케이션의 path는 /webShop
	</script>
</body>
</html>
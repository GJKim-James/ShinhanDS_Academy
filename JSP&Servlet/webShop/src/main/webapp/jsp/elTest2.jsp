<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.firstzone.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL(JSP Standard Tag Library) : JSP 표준 태그 라이브러리 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
EmpService empService = new EmpService();
List<EmpDTO> empList = empService.selectAllService();
pageContext.setAttribute("empDatas", empList);

Map<String, List<EmpDTO>> map = new HashMap<>();
map.put("empMap", empList);
pageContext.setAttribute("mymap", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(Expression Language)</title>
</head>
<body>
	1. 스크립트릿의 Expression 이용하기 : <%=empList.get(0).getFirst_name() %><br>
	2. EL 이용하기(list) : ${ empDatas[0].first_name }<br>
	3. EL 이용하기(map) : ${ mymap.empMap[0].first_name }
	<hr>
	
	<h2>JSTL(JSP Standard Tag Library) : JSP 표준 태그 라이브러리</h2>
	1. set(값 저장; setAttribute)<br>
	<c:set var="major" value="컴퓨터공학과"/>
	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }"/>
	
	2. get(값 얻기; getAttribute)
	major : ${ major },	contextPath : ${ contextPath }<br>
	
	3. 조건문
	<c:if test="${ loginMember == null }">
		<h2>로그인 안한 사용자 메뉴</h2>
		<ul>
			<li><a href="${ path }/deptlist.do">부서 조회</a></li>
			<li><a href="${ path }/deptinsert.do">부서 입력</a></li>
		</ul>
	</c:if>
	<c:if test="${ loginMember != null }">
		<h2>로그인 한 사용자 메뉴</h2>
		<ul>
			<li><a href="${ path }/emplist.do">직원 조회</a></li>
			<li><a href="${ path }/empinsert.do">직원 입력</a></li>
			<li><a href="${ path }/deptlist.do">부서 조회</a></li>
			<li><a href="${ path }/deptinsert.do">부서 입력</a></li>
		</ul>
	</c:if>
	
	4. choose
	<%
	request.setAttribute("score", 99);
	%>
	<c:choose>
		<c:when test="${ score >= 90 && score <= 100 }">
			<p>A학점</p>
		</c:when>
		<c:when test="${ score >= 80 && score < 90 }">
			<p>B학점</p>
		</c:when>
		<c:otherwise>
			<p>노력 요함</p>
		</c:otherwise>
	</c:choose>
	
	5. 반복문(forEach)<br>
	<c:set var="total" value="0"/>
	<c:forEach begin="1" end="5" step="1" var="i">
		forEach로 반복중 ${ i }<br>
		<c:set var="total" value="${ total + i }"/>
	</c:forEach>
	<p>1~5까지 합계 : ${ total }</p>
	
	<%-- varStatus : 반복 상태 속성 --%>
	<c:forEach items="${ empDatas }" var="emp" varStatus="loopStatus">
		<li>
			${ loopStatus.index }(0부터 시작) / ${ loopStatus.count }(1부터 시작) / 
			${ loopStatus.first }(첫 번째 반복인지) / ${ emp.first_name }
		</li>
	</c:forEach><br>
	
	6. URL 만들기(JSTL의 URL 태그는 절대 경로일 때 default로 contextPath 포함하고 있음)
	<c:url var="empDetail" value="/empdetail.do">
		<c:param name="empid" value="100"></c:param>
	</c:url>
	<a href="${ empDetail }">100번 직원 상세보기</a><br><br>
	
	7. 이미지 출력<br>
	<c:forEach begin="1" end="10" var="i">
		<img alt="img" src="${ path }/images/img${i}.jpg">
	</c:forEach>
	<br>
	
	8. fmt(포맷팅)<br>
	입사일 : <fmt:formatDate value="${ empDatas[0].hire_date }" pattern="yyyy/MM/dd hh:mm:ss"/><br>
	<%
	Date today = new Date();
	request.setAttribute("today", today);
	%>
	오늘 : <fmt:formatDate value="${ today }" type="both" dateStyle="full" timeStyle="full"/>
</body>
</html>
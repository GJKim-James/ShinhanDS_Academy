<%@page import="com.firstzone.dept.DeptDTO"%>
<%@page import="com.firstzone.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 등록 중...</h1>
	
	<%
	String deptid = request.getParameter("department_id");
	String deptname = request.getParameter("department_name");
	String mgrid = request.getParameter("manager_id");
	String locid = request.getParameter("location_id");
	
	int i_deptid = Integer.parseInt(deptid);
	int i_mgrid = Integer.parseInt(mgrid);
	int i_locid = Integer.parseInt(locid);
	
	DeptService deptService = new DeptService();
	DeptDTO deptDTO = new DeptDTO(i_deptid, deptname, i_mgrid, i_locid);
	int result = deptService.insert(deptDTO);
	%>
	
	<h2><%=result %>건 입력됨</h2>
	
	<p><a href="/appleShop/dept/deptAll.jsp" target="blank">부서 목록 조회</a></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptInsert.jsp</title>
<style type="text/css">
#container {
	border: 1px dotted gray;
	width: 30%;
	margin: 0 auto;
}

label {
	width: 150px;
	display: inline-block;
	background-color: green;
	color: white;
	margin: 5px;
	padding: 5px;
}

h1, #submitBtn {
	/* border: 1px dotted gray; */
	text-align: center;
}

input {
	margin: 5px;
	padding: 5px;
}
</style>
</head>
<body>
	<div id="container">
		<h1>부서 등록</h1>
	
		<form action="deptRegister.jsp">
			<label>부서 번호</label><input type="number" name="department_id">
			<br>
			<label>부서 이름</label><input type="text" name="department_name">
			<br>
			<label>지역 번호</label><input type="number" name="location_id" value="2000">
			<br>
			<label>매니저 번호</label><input type="number" name="manager_id" value="100">
			<br>
			
			<div id="submitBtn">
				<input type="submit" value="부서 등록하기">
			</div>
		</form>
	</div>
</body>
</html>
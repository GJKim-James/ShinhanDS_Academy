<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>바인딩</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		function f_local() {
			localStorage.setItem("myname", "James");
			localStorage.setItem("mymajor", "Computer");
			localStorage.setItem("myscore", "99");
		}
		
		function f_session() {
			sessionStorage.setItem("myname2", "James2");
			sessionStorage.setItem("mymajor2", "Computer2");
			sessionStorage.setItem("myscore2", "88");
		}
	</script>
</head>
<body>
	<h1>application/session/request에 Bind 연습</h1>
	<p>myName을 읽음 : ${myName}</p>
	<p>myName2을 읽음 : ${myName2}</p>
	<p>myName3을 읽음 : ${myName3}</p>
	<hr>
	
	<h2>브라우저에 저장하기</h2>
	<button onclick="f_local()" class="btn btn-primary">Local Storage에 저장</button> <%-- 브라우저 탭이 닫혀도 살아있음 --%>
	<button onclick="f_session()" class="btn btn-primary">Session Storage에 저장</button>
</body>
</html>
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
			let a = localStorage.getItem("myname");
			let b = localStorage.getItem("mymajor");
			let c = localStorage.getItem("myscore");
			
			document.querySelector("#here").innerHTML = a + "<br>" + b + "<br>" + c;
		}
		
		function f_session() {
			let a = sessionStorage.getItem("myname2");
			let b = sessionStorage.getItem("mymajor2");
			let c = sessionStorage.getItem("myscore2");
			
			document.querySelector("#here").innerHTML = a + "<br>" + b + "<br>" + c;
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
	<button onclick="f_local()" class="btn btn-primary">Local Storage에서 읽기</button>
	<button onclick="f_session()" class="btn btn-primary">Session Storage에서 읽기</button>
	<hr>
	
	<div id="here">결과 표시 영역</div>
</body>
</html>
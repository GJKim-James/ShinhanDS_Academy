<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	
	<!-- font-family: 'Jua', sans-serif; 사용을 위한 링크 -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" href="../../css/UserLogin.css">
	<title>축구 경기 신청 프로그램 첫 화면</title>
	<script type="text/javascript">
		// 로그인을 위한 입력 정보의 유효성 체크하기
	    function loginCheck(login_form) {
	
	        if (login_form.user_id.value == "") {
	            alert("아이디를 입력하세요.");
	            login_form.user_id.focus();
	            return false;
	        }
	
	        if (login_form.user_pw.value == "") {
	            alert("비밀번호를 입력하세요.");
	            login_form.user_pw.focus();
	            return false;
	        }
	
	    }
	</script>
</head>
<body>
	<form name="login_form" method="post" action="${contextPath}/userlogin" onsubmit="return loginCheck(this)">
		<div class="main_login">
			<h2>
				<a href="/matchservletproject" target="_self">축구 경기<br>신청 프로그램</a>
			</h2>

			<fieldset>
				<legend>로그인 입력 폼</legend>
				<p class="id_field">
					<label for="uid" id="uid_label" style="display: block;">
						<span class="zh" data-translate="아이디"></span>
					</label>
					<input id="uid"	name="user_id" type="text" title="아이디 입력"
						maxlength="50" tabindex="1" placeholder="아이디" autofocus="autofocus">
				</p>
				<p class="pw_field">
					<label for="password" id="pass_label">
						<span class="zh" data-translate="비밀번호"></span>
					</label>
					<input id="password" name="user_pw"	type="password" title="비밀번호 입력"
						maxlength="15" tabindex="2" placeholder="비밀번호">
				</p>
				<p class="login_btn">
					<input type="submit" value="로그인" style="cursor: pointer">
				</p>

				<div class="account_area">
<!-- 					<a href="/user/FindIdPage" class="find_id">아이디 찾기</a> -->
<!-- 					<span class="bar">|</span> -->
<!-- 					<a href="/user/FindPassword" class="find_pw">비밀번호 찾기</a> -->
<!-- 					<span class="bar">|</span> -->
					<a href="${contextPath}/UserRegister">회원가입</a>
				</div>
			</fieldset>
		</div>
	</form>
</body>
</html>
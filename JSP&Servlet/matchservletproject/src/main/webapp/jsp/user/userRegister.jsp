<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 화면</title>
	<link href="css/UserRegister.css" rel="stylesheet">
	<script src="js/jquery-3.7.1.min.js"></script>
	<%-- font-family: 'Jua', sans-serif; 사용을 위한 링크 --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	<script type="text/javascript">
		// 회원가입 정보의 유효성 체크하기
		function doRegUserCheck(join_form) {
	
			if (join_form.user_id.value == "") {
				alert("아이디를 입력하세요.");
				join_form.user_id.focus();
				return false;
			}
	
			if (join_form.user_pw.value == "") {
				alert("비밀번호를 입력하세요.");
				join_form.user_pw.focus();
				return false;
			}
	
//             const pattern1 = /[0-9]/;
//             const pattern2 = /[a-zA-Z]/;
//             const pattern3 = /[~!@\#$%<>^&*-]/;

//             if (!pattern1.test(join_form.user_pw.value) || !pattern2.test(join_form.user_pw.value) || !pattern3.test(join_form.user_pw.value)) {
//                 alert("문자, 숫자, 기호를 조합하여 10~15자로 입력해주세요.");
//                 join_form.user_pw.focus();
//                 return false;
//             }

//             if (join_form.user_pw.length < 10 || join_form.user_pw.length > 15) {
//                 alert("문자, 숫자, 기호를 조합하여 10~15자로 입력해주세요.");
//                 join_form.user_pw.focus();
//                 return false;
//             }
	
			if (join_form.user_pw2.value == "") {
				alert("비밀번호 재확인을 입력하세요.");
				join_form.user_pw2.focus();
				return false;
			}
	
			if (join_form.user_pw.value != join_form.user_pw2.value) {
				alert("비밀번호가 일치하지 않습니다.");
				join_form.user_pw2.focus();
				return false;
			}
	
			if (join_form.user_name.value == "") {
				alert("이름을 입력하세요.");
				join_form.user_name.focus();
				return false;
			}
	
			if ($("#impossible").css("display") == "inline-block"
					&& $("#possible").css("display") == "none") {
				alert("중복된 아이디입니다. 다시 입력해주세요.");
				join_form.user_id.focus();
				return false;
			}
			
		}
	</script>
	
	<script>
		<!-- 회원가입 시 아이디 중복 확인 -->
		function idCheck() {
			let user_id = $('#user_id').val(); // id 값이 "user_id"인 입력란의 값을 저장
	
			$.ajax({
				url : '${contextPath}/useriddupcheck',
				type : 'POST', //POST 방식으로 전달
				data : { user_id : user_id },
				success : function(result) { // Servlet에서 넘어온 result 값을 받는다
					if (user_id == "") {
						$('#user_id').css("border", "1px solid #bbb");
						$('#possible').css("display", "none");
						$('#impossible').css("display", "none");
						return;
					}
					if (result == 0) { // result가 0이면 사용 가능한 아이디
						$('#possible').css("display", "inline-block");
						$('#impossible').css("display", "none");
						$('#user_id').css("border-color", "#bbbbbb");
					} else { // result가 1이면 이미 사용 중인 아이디
						$('#impossible').css("display", "inline-block");
						$('#possible').css("display", "none");
						$('#user_id').css("border-color", "#ff223c");
					}
				},
				error : function(error) {
					alert("error");
					console.log(error);
				}
			});
	
		};
	</script>
</head>
<body>
	<form name="join_form" method="post" action="userinsert.do" onsubmit="return doRegUserCheck(this)">
		<div id="membership">
			<div class="step2">
				<h1 class="logo">
					<a href="${contextPath}">축구 경기<br>신청 프로그램</a>
				</h1>

				<div class="membership_input_wrap">
					<div>
						<label for="user_id">아이디</label><br> <input type="text"
							id="user_id" name="user_id" maxlength="12" autocomplete="off"
							title="아이디" onkeyup="idCheck()"> <input type="hidden"
							name="check_id" value="-1">
						<p id="possible">사용 가능한 아이디입니다.</p>
						<p id="impossible">이미 사용 중인 아이디입니다.</p>
					</div>

					<div>
						<label>비밀번호</label><br> <input type="password" name="user_pw"
							maxlength="16" autocomplete="off" title="비밀번호">
					</div>
<%-- 					<p id="PwDefaultMsg">문자, 숫자, 기호를 조합하여 10~15자로 입력해주세요.</p> --%>

					<div>
						<label>비밀번호 재확인</label><br> <input type="password"
							name="user_pw2" maxlength="15" autocomplete="off"
							title="비밀번호 재확인"><span></span>
					</div>

					<div>
						<label>이름</label><br> <input type="text" name="user_name"
							maxlength="25" autocomplete="off" title="이름">
					</div>

					<div>
						<label>성별</label><br>
						<div class="radio_gender">
							<input type="radio" name="gender" id="gender_male" value="M"
								title="남자" checked>남자 <input type="radio" name="gender"
								id="gender_female" value="F" title="여자">여자
						</div>
					</div>
				</div>

				<div class="btn_wrap">
					<a href="${contextPath}" class="btn gray previous">취소</a> <input
						type="submit" id="join_btn" value="가입하기" style="cursor: pointer">
				</div>

			</div>
		</div>
	</form>
</body>
</html>
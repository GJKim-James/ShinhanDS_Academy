<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/commonHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>축구 경기 신청 프로그램</title>
	<script type="text/javascript">
		// 신청 가능한 경기 목록 조회
		$(document).ready(function() {
			selectAvailableMatch();
		});
		
		function selectAvailableMatch() {
			$.ajax({
				url: "${contextPath}/availableMatchList",
				type: "GET",
				success: function(res) {
					$("#resultSpace").html(res);
				},
				error: function(err) {
					alert(err);
				}
			});
		}
		
		// 사용자가 신청한 경기 내역 조회
		function selectMyMatch() {
			$.ajax({
				url: "${contextPath}/selectMyMatch",
				type: "GET",
				success: function(res) {
					$("#resultSpace").html(res);
				},
				error: function(err) {
					alert(err);
				}
			});
		}
		
		// 내 정보(마이페이지)
		function myPage() {
			$.ajax({
				url: "${contextPath}/myPage",
				type: "GET",
				success: function(res) {
					$("#resultSpace").html(res);
				},
				error: function(err) {
					alert(err);
				}
			});
		}
		
		// 관리자 경기 목록 조회
		function selectAllMatchList() {
			$.ajax({
				url: "${contextPath}/matchlist",
				type: "GET",
				success: function(res) {
					$("#resultSpace").html(res);
				},
				error: function(err) {
					alert(err);
				}
			});
		}
	</script>
</head>
<body id="page-top">
    <!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
	    <div class="container px-5">
	        <a class="navbar-brand" href="${contextPath}">축구 경기 신청 프로그램</a>
	        <div class="collapse navbar-collapse" id="dropdown-menu">
	            <ul class="navbar-nav">
	            	<c:if test="${SS_USER_DTO.user_id == null && SS_USER_DTO.user_id != 'admin'}">
	                	<li class="nav-item"><a class="nav-link" href="#scroll" onclick="selectAvailableMatch();">경기 목록</a></li>
	                </c:if>
	                <c:if test="${SS_USER_DTO.user_id.equals('admin')}">
		                <li class="nav-item"><a class="nav-link" href="#matchInsertModal" data-bs-toggle="modal">경기 생성</a></li>
<!-- 		                <li class="nav-item"><a class="nav-link" href="matchinsert.do">경기 생성</a></li> -->
		                <li class="nav-item"><a class="nav-link" href="#scroll" onclick="selectAllMatchList();">경기 목록</a></li>
	                </c:if>
	                <c:if test="${SS_USER_DTO.user_id != 'admin' && SS_USER_DTO.user_id != null}">
	                	<li class="nav-item"><a class="nav-link" href="#scroll" onclick="selectAvailableMatch();">경기 신청</a></li>
	                	<li class="nav-item"><a class="nav-link" href="#scroll" onclick="selectMyMatch();">신청 내역</a></li>
	                	<li class="nav-item"><a class="nav-link" href="#scroll" onclick="myPage();">내 정보</a></li>
	                </c:if>
	            </ul>
	        </div>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
            	<ul class="navbar-nav ms-auto">
            		<c:if test="${SS_USER_DTO.user_id == null}">
	                <li class="nav-item"><a class="nav-link" href="userlogin">Log In</a></li>
	                </c:if>
	                <c:if test="${SS_USER_DTO.user_id != null}">
	                <li class="nav-item"><a class="nav-link" href="#scroll" onclick="myPage();">${SS_USER_DTO.user_name} 님</a></li>
	                <li class="nav-item"><a class="nav-link" href="userlogout">Log Out</a></li>
	                </c:if>
            	</ul>
            </div>
	    </div>
	</nav>
	
	<!-- Modal -->
	<div class="modal fade" id="matchInsertModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="staticBackdropLabel" style="font-family: 'Jua', sans-serif;">경기 생성하기</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <form action="${contextPath}/matchinsert.do" method="post">
		      <div class="modal-body">
		      	<div class="input-group mb-3">
					<span class="input-group-text">경기 일시</span>
					<input type="datetime-local" class="form-control" name="match_date" required="required">
				</div>
				
				<div class="input-group mb-3">
					<span class="input-group-text">경기 장소</span>
					<input type="text" class="form-control" name="match_place" required="required">
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        <input type="submit" value="생성하기" class="btn btn-primary">
		      </div>
	      </form>
	    </div>
	  </div>
	</div>
	
	<!-- Header(경기장 사진 삽입되어 있음) -->
    <header class="masthead text-center text-white">
        <div class="masthead-content">
            <div class="container px-5">
                
            </div>
        </div>
        <div class="bg-circle-1 bg-circle"></div>
        <div class="bg-circle-2 bg-circle"></div>
        <div class="bg-circle-3 bg-circle"></div>
        <div class="bg-circle-4 bg-circle"></div>
    </header>
    
    <!-- Content section 1(ajax 결과 표시 영역) -->
    <section id="scroll" style="border-bottom: 1px solid #ccc;">
        <div class="container">
            <div class="row gx-5 align-items-center">
                <div class="p-5" id="resultSpace"></div>
            </div>
        </div>
    </section>
    <!-- Content section 2(경기장 사진 삽입) -->
    <section style="border-bottom: 1px solid #ccc;">
        <div class="container px-5">
            <div class="row gx-5 align-items-center">
                <div class="col-lg-6">
                    <img class="img-fluid" src="${contextPath}/images/tottenham2.jpg" alt="Tottenham Stadium"/>
                </div>
                <div class="col-lg-6">
                    <img class="img-fluid" src="${contextPath}/images/tottenham3.jpg" alt="Tottenham Stadium"/>
                </div>
            </div>
        </div>
    </section>
    
    <!-- Footer-->
    <footer class="py-5 bg-black">
        <div class="container px-5"><p class="m-0 text-center text-white small">Copyright &copy; Kim Gwang Jin</p></div>
    </footer>
</body>
</html>
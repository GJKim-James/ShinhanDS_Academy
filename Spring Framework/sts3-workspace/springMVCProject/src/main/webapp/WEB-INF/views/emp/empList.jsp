<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원 목록</title>
	<style type="text/css">
	.container {
		text-align: center;
		margin-top: 10px;
	}
	
	hr {
	clear: both;
	}
	</style>
</head>
<body>
	<div class="container">
		<%@ include file="../common/header.jsp" %>
		<a href="${contextPath}/auth/main.do" class="btn btn-primary">메인 화면으로</a>
		<hr>
		
		<div>
			<fieldset>
				<div class="input-group mt-5 mb-5">
					<legend>조건 선택</legend>
					<span class="input-group-text">부서 번호</span>
					<select class="form-control" name="department_id">
						<option value="-1">선택 안함</option>
						<c:forEach items="${deptList}" var="dept">
							<option value="${dept.dept_id}">${dept.dept_id} (${dept.dept_name})</option>
						</c:forEach>
					</select>
					
					<span class="input-group-text">직책</span>
					<select class="form-control" name="job_id" required="required">
						<option value="-1">선택 안함</option>
						<c:forEach items="${jobList}" var="job">
							<option ${job.job_id == 'IT_PROG' ? 'selected' : ''} value="${job.job_id}">${job.job_id} (${job.job_title})</option>
						</c:forEach>
					</select>
					
					<span class="input-group-text">급여(이상)</span>
					<input type="number" class="form-control" name="salary" value="5000">
					
					<span class="input-group-text">입사일(이후)</span>
					<input type="date" class="form-control" name="hire_date">
					<div class="input-group-text">
						<input class="form-check-input mt-0" type="checkbox" value="1" name="chkDate">모든 일자
					</div>
					<button id="btn_condition" class="btn btn-success">조건 조회</button>
				</div>
			</fieldset>
		</div>
		<hr>
		
		<h1>직원 목록</h1>
		<%-- ${empDatas} --%>
		
		<div id="table_here">
<!-- 			<table class="table table-striped table-hover"> -->
<!-- 				<tr> -->
<!-- 					<th>직원 번호</th> -->
<!-- 					<th>First Name</th> -->
<!-- 					<th>Last Name</th> -->
<!-- 					<th>이메일</th> -->
<!-- 					<th>전화번호</th> -->
<!-- 					<th>입사일</th> -->
<!-- 					<th>직책</th> -->
<!-- 					<th>급여</th> -->
<!-- 					<th>커미션</th> -->
<!-- 					<th>매니저 번호</th> -->
<!-- 					<th>부서 번호</th> -->
<!-- 					<th>GET 요청</th> -->
<!-- 					<th>POST 요청</th> -->
<!-- 				</tr> -->
				
<%-- 				<c:forEach items="${empDatas}" var="emp"> --%>
<!-- 					<tr> -->
<%-- 						<td><a href="${path}/empdetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td> --%>
<%-- 						<td>${emp.first_name}</td> --%>
<%-- 						<td>${emp.last_name}</td> --%>
<%-- 						<td>${emp.email}</td> --%>
<%-- 						<td>${emp.phone_number}</td> --%>
<%-- 						<td>${emp.hire_date}</td> --%>
<%-- 						<td>${emp.job_id}</td> --%>
<%-- 						<td>${emp.salary}</td> --%>
<%-- 						<td>${emp.commission_pct}</td> --%>
<%-- 						<td>${emp.manager_id}</td> --%>
<%-- 						<td>${emp.department_id}</td> --%>
						
<%-- 						<td><button onclick="location.href='${path}/empdelete.do?empid=${emp.employee_id}'" class="btn btn-dark">삭제</button></td> --%>
<!-- 						<td> -->
<%-- 							<form action="${path}/empdelete.do" method="post"> --%>
<%-- 								<input type="hidden" name="empid" value="${emp.employee_id}"> --%>
<!-- 								<button class="btn btn-dark">삭제</button> -->
<!-- 							</form> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<!-- 			</table> -->
		</div>
	</div>
	<script type="text/javascript">
		<%-- CRUD 작업 후 결과 alert --%>
		var resultMessage = "${result}";
		if (resultMessage != "") {
			alert(resultMessage);
		}
		
		$(function () {
			var date = new Date();
			date.setFullYear(date.getFullYear() - 30);
			$('[name="hire_date"]').val(date.toISOString().split("T")[0]);
			
			$("#btn_condition").on("click", f_ajax);
			
			// 이벤트 호출; 화면이 로드되자마자 디폴트로 값을 보여주기 위함(아무것도 없는 화면이 싫어서)
			$("#btn_condition").trigger("click");
		});
		
		function f_ajax() {
			$.ajax({
				url: "${contextPath}/emp/list2.do",
				type: "GET",
				data: {
					"deptid": $('[name="department_id"]').val(),
					"jobid": $('[name="job_id"]').val(),
					"salary": $('[name="salary"]').val(),
					"hiredate": $('[name="hire_date"]').val(),
					"chkdate": $('[name="chkDate"]').prop("checked") // true, false
					},
				success: function (responseData) {
					$("#table_here").html(responseData);
				},
				error: function (err) {
					alert(err);
				}
			});
		}
	</script>
</body>
</html>
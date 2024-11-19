<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 등록</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-3">
		<h2>부서 등록</h2>

		<form action="deptinsert.do" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text">부서 번호</span>
				<input type="number" class="form-control" placeholder="숫자 입력" name="department_id" required="required">
			</div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">부서 이름</span>
				<input type="text" class="form-control" name="department_name" required="required">
			</div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">매니저 번호</span>
				<input type="number" class="form-control" name="manager_id" value="105">
			</div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">지역 번호</span>
				<input type="number" class="form-control" name="location_id" value="1700">
			</div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">전화 번호</span>
				<input type="hidden" name="phone_number" value="010-1234-5678">
			</div>

			<button type="submit" class="btn btn-primary">신규 부서 등록</button>
		</form>
	</div>
</body>
</html>
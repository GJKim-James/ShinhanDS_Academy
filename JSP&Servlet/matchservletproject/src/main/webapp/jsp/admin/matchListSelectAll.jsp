<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/commonHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>경기 목록 조회</title>
	<link href="${contextPath}/css/matchListSelectAll.css" rel="stylesheet">
	<script type="text/javascript">
// 		$(function () {
// 			$("#btn_apply").on("click", applyMatch);
// 		});
		
// 		function applyMatch(event) {
// 			var match_no = $(this).parent().parent().children().eq(0).text();
// 			var match_date = $(this).parent().parent().children().eq(1).text();
// 			var match_place = $(this).parent().parent().children().eq(2).text();
// 			console.log(match_no);
// 			console.log(match_date);
// 			console.log(match_place);
			
// 			if (confirm("해당 경기를 신청하시겠습니까?")) {
// 				$.ajax({
// 	 				url: "${contextPath}/matchapply",
// 	 				type: "GET",
// 	 				data: {
// 	 					"match_no": match_no,
// 	 					"match_date": match_date,
// 	 					"match_place": match_place
// 	 					},
// 	 				success: function (res) {
// 	 					alert(res);
// 	 				},
// 	 				error: function (err) {
// 	 					alert(err);
// 	 				}
// 	 			});
// 			};
// 		}
		
// 		$("#applyModal").on("show.bs.modal", function(event) {
// 			console.log("Modal 실행!!!!!");
//             var match_no = $(event.relatedTarget).data('match_no');
//             var match_date = $(event.relatedTarget).data('match_date');
//             var match_place = $(event.relatedTarget).data('match_place');
//             console.log(match_no);
//             console.log(match_date);
//             console.log(match_place);
            
//             $.ajax({
// 				url: "${contextPath}/matchapply",
// 				type: "GET",
// 				data: {
// 					"match_no": match_no,
// 					"match_date": match_date,
// 					"match_place": match_place,
// 					"team_name": $('[name="team_name"]').val()
// 					},
// 				success: function (res) {
// 					alert(res);
// 				},
// 				error: function (err) {
// 					alert(err);
// 				}
// 			});
//         });
		
		function deleteMatch(match_no) {
			if (confirm(match_no + "번 경기를 삭제하시겠습니까?")) {
				location.href = "${contextPath}/matchdelete?match_no=" + match_no;
			}
		}
		
		// 관리자 수정하기 버튼 클릭 시 Modal에 경기 번호(match_no) readonly로 넣기
		$("#btn_update").on("click", function() {
			var match_no = $(this).parent().parent().children().eq(0).text();
			console.log(match_no);
            
            $("form input[name='match_no']").val(match_no);
		});
	</script>
</head>
<body>
	<div id="container">
		<table>
			<thead>
				<tr>
					<th>경기 번호</th>
					<th>경기 일시</th>
					<th>경기 장소</th>
					<th>신청 마감 여부</th>
					<th>신청 가격(원)</th>
					<th>신청 가능한 인원 수</th>
					<th colspan="2"></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${matchList}" var="matchlist" varStatus="status">
					<tr>
						<td>${ matchlist.match_no }</td>
						<td>${ matchlist.match_date }</td>
						<td>${ matchlist.match_place }</td>
						<td>${ matchlist.match_close }</td>
						<td>${ matchlist.match_price }</td>
						<td>${ matchlist.head_count }</td>
						<c:if test="${SS_USER_DTO.user_id == 'admin'}">
							<td colspan="2">
								<a href="#matchUpdateModal" data-bs-toggle="modal" data-id="${matchlist.match_no}" class="btn btn-primary" id="btn_update">수정하기</a>
<%-- 								<button data-bs-toggle="modal" data-target="#matchUpdateModal" data-id="${matchlist.match_no}" class="btn btn-primary">수정하기</button> --%>
								<button type="button" class="btn btn-primary" onclick="deleteMatch(${matchlist.match_no});">삭제하기</button>
							</td>
						</c:if>
						<c:if test="${SS_USER_DTO.user_id != 'admin'}">
							<td colspan="2">
								<a href="matchapply?match_no=${matchlist.match_no}&match_date=${matchlist.match_date}
										&match_place=${matchlist.match_place}" class="btn btn-primary">신청하기</a>
<%-- 								<c:if test="${SS_USER_DTO.user_id != null}"> --%>
<!-- 									<a href="#applyModal" data-bs-toggle="modal" class="btn btn-primary" -->
<%-- 										data-match_no="${ matchlist.match_no }" data-match_date="${ matchlist.match_date }" --%>
<%-- 										data-match_place="${ matchlist.match_place }">신청하기</a> --%>
<%-- 								</c:if> --%>
<%-- 								<c:if test="${SS_USER_DTO.user_id == null}"> --%>
<!-- 									<a href="matchapply" class="btn btn-primary">신청하기</a> -->
<%-- 								</c:if> --%>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- Modal -->
		<div class="modal fade" id="matchUpdateModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="staticBackdropLabel" style="font-family: 'Jua', sans-serif;">경기 수정하기</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="${contextPath}/matchupdate.do" method="get">
			      <div class="modal-body">
			      	<div class="input-group mb-3">
						<span class="input-group-text">경기 번호</span>
						<input type="text" class="form-control" name="match_no" readonly="readonly">
					</div>
					
			        <div class="input-group mb-3">
						<span class="input-group-text">경기 일시</span>
						<input type="datetime-local" class="form-control" name="match_date" required="required">
					</div>
					
					<div class="input-group mb-3">
						<span class="input-group-text">경기 장소</span>
						<input type="text" class="form-control" name="match_place" required="required">
					</div>
					
					<div class="input-group mb-3">
						<span class="input-group-text">신청 마감 여부</span>
						<select class="form-control" name="match_close">
							<option value="0">0(신청 가능)</option>
							<option value="1">1(신청 마감)</option>
						</select>
					</div>
					
					<div class="input-group mb-3">
						<span class="input-group-text">신청 가격</span>
						<input type="text" class="form-control" name="match_price" required="required">
					</div>
					
					<div class="input-group mb-3">
						<span class="input-group-text">신청 가능한 인원 수</span>
						<input type="text" class="form-control" name="head_count" required="required">
					</div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
<!-- 			        <a href="matchupdate.do" class="btn btn-primary" id="btn_apply">수정하기</a> -->
			        <input type="submit" value="수정하기" class="btn btn-primary">
			      </div>
			  </form>
		    </div>
		  </div>
		</div>
	</div>
</body>
</html>
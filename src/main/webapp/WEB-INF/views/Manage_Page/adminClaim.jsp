<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog Admin Claim</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">

function toTheTop() {
	$('html').scrollTop(0);
	// 동작이 안될 경우 $('html, body') 로 변경
}

function toTheBottom() {
	$('html').scrollTop($(document).height());
}

function updateClmCondition(claimno) {
	var clmno = claimno;

	var condition = $("#clmcondition"+clmno).val();
 
	if(condition == 1) {
		alert(clmno+"번 신고\n\n상태 변경: 확인 및 처리 완료!!");
	} 
	location.href='/Manage_Page/updateClmCondition.do?clmno='+clmno+'&clmcondition='+condition;
}


$(document).ready(function() {
	$("#btnSearch").click(function() {
		location.href="/Manage_Page/claimManage.do?searchContent="+$("#searchContent").val();
	});
});

</script>


<style type="text/css">

.container {
	width: 80%;
	min-width: 1200px;
	margin-left: 180px;
}

table {
	width: 100%;
/* 	background-image: url('https://i.pinimg.com/originals/8a/c7/49/8ac749d3599a1cf70fb6f295c8af9608.jpg'); */
	background-color: skyblue;
}

th, td {
	text-align: center;
}

th {
	font-size: 18px;
}

span {
	color: blue;
	font-size: 25px;
}

.red {
	color: red;
}

</style>

</head>
<body>

<div class="wrap">
<jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" />

<div class="container">
<div class="content">


<div class="clearfix"></div>
<hr>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="searchContent" placeholder="게시글 번호로 검색 가능" style="min-width: 40%; height: 50px" />
	<button id="btnSearch" class="btn btn-info btn-lg">검색</button>
</div>

<div class="pull-left">
<button type="button" class="btn btn-primary btn-lg" onclick="toTheBottom()">아래로 ↓</button>
</div>

<hr>
<span class="pull-right">조회된 신고 수 : ${paging.totalCount }</span>
<br>
<a href="/Manage_Page/claimPdfList.do">PDF로 출력하기</a>

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>신고 번호</th>
		<th>게시글 번호</th>
		<th>게시글 제목</th>
		<th>신고자</th>
		<th>피신고자</th>
		<th>신고 사유</th>
		<th>신고 상태</th>
		<th>신고일</th>
<!-- 		<th class="red">해당 게시물 삭제</th> -->
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="i">
	<tr>
		<td>${i.clmno }</td>

		<!-- 게시글 번호 -->
		<td>
			<c:choose>
				<c:when test="${i.bodno eq 0}">N/A</c:when>
				<c:when test="${i.bodno ne null}">${i.bodno }</c:when>
			</c:choose>
		</td>

		<!-- 게시글 번호 END -->

		<!-- 게시글 제목 -->
		<td>
			<c:choose>
				<c:when test="${i.bodtitle ne null}"><a href="/Manage_Page/boardView.do?bodno=${i.bodno }">${i.bodtitle }</a></c:when>
				<c:when test="${i.bodtitle eq null}">N/A</c:when>
			</c:choose>
		</td>
		<!-- 게시글 제목 END -->
		
		<!-- 신고자 닉네임 -->
		<td>${i.clmfromid }</td>
		<!-- 신고자 닉네임 END -->

		<!-- 피신고자 닉네임 -->
		<td>
			<c:choose>
				<c:when test="${i.clmtoid ne null}">${i.clmtoid }</c:when>
				<c:when test="${i.clmtoid eq null}">N/A</c:when>
			</c:choose>
		</td>
		<!-- 피신고자 닉네임 END -->

		<!-- 신고사유 -->
		<td>
			<c:choose>
				<c:when test="${i.clmreason eq 0}">욕설 및 인신공격(0)</c:when>
				<c:when test="${i.clmreason eq 1}">음란성 / 사행성 게시글(1)</c:when>
				<c:when test="${i.clmreason eq 2}">도배(2)</c:when>
				<c:when test="${i.clmreason eq 3}">타인 정보 공개 / 사생활 침해(3)</c:when>
				<c:when test="${i.clmreason eq 4}">기타 사유(4)</c:when>
			</c:choose>
		</td>
		<!-- 신고사유 END -->

		<!-- 신고 처리 상태 -->
		<td>
			<select class="form-control" id="clmcondition${i.clmno }" name="clmcondition" size="1" onchange="updateClmCondition(${i.clmno });">
				<c:if test="${i.clmcondition eq 0}">
					<option value="0">상태 : 확인중</option>
				</c:if>
				<c:if test="${i.clmcondition eq 1}">
					<option value="1">상태 : 확인 및 처리 완료</option>
				</c:if>
				
				<option value="1">확인 및 처리 완료(1)</option>
			</select>
		</td>
		<!-- 신고 처리 상태 END -->

		<!-- 신고일시 -->
		<td>
<%-- 			<fmt:formatDate value="${i.clmdate }" pattern="yyyy년MM월dd일 HH:mm:ss" /> --%>
			${i.clmdate }
		</td>
		<!-- 신고일시 END -->
	</tr>
</c:forEach>
</tbody>
</table>

<div class="clearfix"></div>

<div class="pull-right">
<button type="button" class="btn btn-primary btn-lg" onclick="toTheTop()">위로 ↑</button>
</div>

<jsp:include page="/resources/util/Manage_Page/paging.jsp" />

</div> <!-- content END -->
</div> <!-- container END -->
</div> <!-- wrap END -->
</body>
</html>
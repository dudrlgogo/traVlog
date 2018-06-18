<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog Admin Advertising</title>

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

function updateAdvertisingApprove(adno) {
	var advno = adno;

// 	console.log("advapprove"+advno);
// 	console.log($("#advapprove"+advno));
	var approve = $("#advapprove"+advno).val();
// 	alert("선택한 value 확인 : "+approve);
 
	if(approve == 1) {
		alert(advno+"번 광고\n\n상태 변경: 승인!!");
	} else if(approve == 2) {
		alert(advno+"번 광고\n\n상태 변경: 만료!!");
	}
	location.href='/Manage_Page/updateAdvApprove.do?advno='+advno+'&advapprove='+approve;
}

$(document).ready(function() {
	$("#btnSearch").click(function() {
		location.href="/Manage_Page/advManage.do?searchContent="+$("#searchContent").val();
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
}

th, td {
	text-align: center;
}

th {
	font-size: 18px;
	background-color: skyblue;
}

#totalno {
	color: blue;
	font-size: 25px;
}

.red {color: red;}
.greed {color: green;}
.gray {color: gray;}

.pagename {
	color: skyblue;
/* 	text-shadow: 3px 3px 3px black, 3px 3px 5px gold; */
}

</style>

</head>
<body>

<div class="wrap">
<jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" />

<div class="container">
<div class="content">


<div class="clearfix"></div>
<h1 class="pagename">광고 관리</h1>
<hr>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="searchContent" placeholder="광고명, 신청자 아이디로 검색 가능" style="min-width: 40%; height: 50px" />
	<button id="btnSearch" class="btn btn-info btn-lg">검색</button>
</div>

<div class="pull-left">
<button type="button" class="btn btn-primary btn-lg" onclick="toTheBottom()">아래로 ↓</button>
</div>

<hr>
<span class="pull-right" id="totalno">조회된 광고 수 : ${paging.totalCount }</span>
<br>
<!-- <a href="/Manage_Page/claimPdfList.do">PDF로 출력하기</a> -->

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>광고 번호</th>
		<th>신청자</th>
		<th>신청일시</th>
		<th>광고명</th>
		<th>금액</th>
		<th>시작일</th>
		<th>종료일</th>
		<th>승인 여부</th>
<!-- 		<th class="red">해당 게시물 삭제</th> -->
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="i">
	<tr>
		<td>${i.advno }</td>
		<td>${i.advid }</td>

		<td>
			<fmt:formatDate value="${i.advdate }" pattern="yyyy년MM월dd일 HH시mm분" />
		</td>
		
<%-- 		<td><a href="/Manage_Page/advView.do?advno=${i.advno }">${i.advtitle }</a></td> --%>
		<td>${i.advtitle }</td>

		<td>
		<fmt:formatNumber value="${i.advprice }" pattern="#,###.##(원)" />
		</td>
<%-- 		<td>${i.advprice }</td> --%>

		<td>
			<fmt:formatDate value="${i.advstart }" pattern="yyyy년 MM월 dd일" />
		</td>

		<td>
			<fmt:formatDate value="${i.advend }" pattern="yyyy년 MM월 dd일" />
		</td>

		<td>
			<select class="form-control" id="advapprove${i.advno }" name="advapprove" size="1" onchange="updateAdvertisingApprove(${i.advno });">
				<c:if test="${i.advapprove eq 0}">
					<option value="0">승인상태 : 대기중</option>
				</c:if>
				<c:if test="${i.advapprove eq 1}">
					<option value="1">승인상태 : 승인</option>
				</c:if>
				<c:if test="${i.advapprove eq 2}">
					<option value="2">승인상태 : 만료</option>
				</c:if>
				
				<option value="1">승인</option>
				<option value="2">만료</option>
			</select>
		</td>
		
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
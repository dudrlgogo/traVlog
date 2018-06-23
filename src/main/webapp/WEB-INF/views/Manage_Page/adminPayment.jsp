<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog Admin Payment</title>

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

function updatePaymentCondition(pno) {
	var payno = pno;
	
// 	console.log("advapprove"+advno);
// 	console.log($("#advapprove"+advno));
	var condition = $("#paycondition"+payno).val();
// 	alert("선택한 value 확인 : "+condition);
// 	alert("확인 : "+payno);
// 	alert("결제번호 : "payno+"번 결제 상태 변경 : "+condition);

 	if(condition == 1) {
		alert("결제번호 : "+payno+"번\n\n결제 승인");
	} else if(condition == 2) {
		alert("결제번호 : "+payno+"번\n\n결제 취소");
	} 
	location.href='/Manage_Page/updatePaycondition.do?paycondition='+condition+'&payno='+payno;
}

$(document).ready(function() {
	$("#btnSearch").click(function() {
		location.href="/Manage_Page/paymentManage.do?searchContent="+$("#searchContent").val();
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
/* 	text-shadow: 3px 3px 3px black, 3px 3px 2px gold; */
}

</style>

</head>
<body>

<div class="wrap">
<jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" />

<div class="container">
<div class="content">


<div class="clearfix"></div>
<h1 class="pagename">결제 관리</h1>
<hr>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="searchContent" placeholder="결제자 아이디, 광고 번호로 검색 가능" style="min-width: 40%; height: 50px" />
	<button id="btnSearch" class="btn btn-info btn-lg">검색</button>
</div>

<div class="pull-left">
<button type="button" class="btn btn-primary btn-lg" onclick="toTheBottom()">아래로 ↓</button>
</div>

<hr>
<span class="pull-right" id="totalno">조회된 결제 수 : ${paging.totalCount }</span>
<br>

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>결제 번호</th>
		<th>광고 번호</th>
		<th>아이디</th>
		<th>결제신청</th>
		<th>처리 완료</th>
		<th>결제 이름</th>
		<th>결제 금액</th>
		<th>결제 수단</th>
		<th>결제 상태</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="i">
	<tr>
		<td>${i.payno }</td>
		<td>${i.advno }</td>
		<td>${i.payid }</td>

		<td>
			<fmt:formatDate value="${i.paystart }" pattern="yyyy년MM월dd일 HH시mm분" />
		</td>

		<td>
			<fmt:formatDate value="${i.payend }" pattern="yyyy년MM월dd일 HH시mm분" />
		</td>
		<td>${i.paytitle }</td>
		
		<td>
		<fmt:formatNumber value="${i.payprice }" pattern="#,###.##(원)" />
		</td>
		
<%-- 		<td>${i.payprice }원</td> --%>
		<td>${i.payway }</td>

		<td>
			<select class="form-control" id="paycondition${i.payno }" name="paycondition" size="1" onchange="updatePaymentCondition(${i.payno });">
				<c:if test="${i.paycondition eq 0}">
					<option value="0">결제상태 : 대기중</option>
					<option value="1">승인</option>
					<option value="2">취소</option>
				</c:if>
				<c:if test="${i.paycondition eq 1}">
					<option value="1">결제상태 : 완료</option>
				</c:if>
				<c:if test="${i.paycondition eq 2}">
					<option value="2">결제상태 : 취소</option>
				</c:if>
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
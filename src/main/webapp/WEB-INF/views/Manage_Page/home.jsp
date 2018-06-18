<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet" type="text/css" href="./css/body.css" >	 -->
<script type="text/javascript">

function toTheTop() {
	$('html').scrollTop(0);
	// 동작이 안될 경우 $('html, body') 로 변경
}

function toTheBottom() {
	$('html').scrollTop($(document).height());
}

function updateMemberStatus(memid) {
	
	var id = memid;
	var memstatus = $("#memstatus"+id).val();

	if(memstatus != null) {
		if(memstatus == 0) {
			alert("회원 아이디: "+memid+"\n\n회원상태 변경: 일반계정!!");
			location.href='/Manage_Page/updateMemberStatus.do?memid='+id+'&memstatus='+memstatus;
		} else if(memstatus == 1) {
			alert("회원 아이디: "+memid+"\n\n회원상태 변경: 7일간 계정정지!!");
			location.href='/Manage_Page/updateMemberStatusPause.do?memid='+id+'&memstatus='+memstatus;
		} else if(memstatus == 2) {
			alert("회원 아이디: "+memid+"\n\n회원상태 변경: 계정블록!!");
			location.href='/Manage_Page/updateMemberStatus.do?memid='+id+'&memstatus='+memstatus;
		} else if(memstatus == 9) {
			alert("회원 아이디: "+memid+"\n\n회원상태 변경: 관리자 계정!!");
			location.href='/Manage_Page/updateMemberStatus.do?memid='+id+'&memstatus='+memstatus;
		}
// 		location.href='/Manage_Page/updateMemberStatus.do?memid='+id+'&memstatus='+memstatus;
	} else {
		return false;
	}
}

$(document).ready(function() {
	$("#btnSearch").click(function() {
		location.href="/Manage_Page/home.do?searchContent="+$("#searchContent").val();
	});
});

</script>


<style type="text/css">

/* check, hover 스타일 설정 IE, Chrome */
select option:checked, 
select option:hover {    
    background: #ff00ff; 
    color: #fff;
}
/* check, hover 스타일 설정 FireFox */
select option:checked,
select option:hover { 
    box-shadow: 0 0 10px 100px #ff00ff inset;  
    color: #fff;
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

.container {
	width: 80%;
	min-width: 1200px;
	margin-left: 180px;
}

.content{
	margin:0 auto;
}

.pagename {
	color: skyblue;
	text-shadow: 3px 3px 3px black, 3px 3px 5px gold;
}

</style>

</head>


<body>

<div class="wrap">
<jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" />

<div class="container">
<div class="content">

<div class="clearfix"></div>

<h1 class="pagename">회원 관리</h1>
<hr>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="searchContent" placeholder="회원 아이디, 닉네임으로 검색 가능" style="min-width: 40%; height: 50px" />
	<button id="btnSearch" class="btn btn-info btn-lg">검색</button>
</div>

<div class="pull-left">
<button type="button" class="btn btn-primary btn-lg" onclick="toTheBottom()">아래로 ↓</button>
</div>

<hr>
<span class="pull-right" id="totalno">조회된 회원 수 : ${paging.totalCount }</span>
<br>

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>회원 아이디</th>
		<th>닉네임</th>
		<th class="sizeup">나이</th>
		<th class="sizeup">성별</th>
		<th>이메일</th>
		<th>연락처</th>
		<th class="sizeup">포스팅</th>
		<th class="sizeup">팔로워</th>
		<th class="sizeup">팔로잉</th>
		<th>게시물 신고</th>
		<th>회원 신고</th>
		<th>회원상태</th>
		<th>정지기간</th>
		<th>회원상태 수정</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="i">
	<tr>
		<td>${i.memid }</td>
		<td>${i.memnick }</td>
		<td class="sizeup">${i.memage }</td>
		<td class="sizeup">${i.memsex }</td>
		<td>${i.mememail }</td>
		<td>${i.memphone }</td>
		<td class="sizeup">${i.memposting }</td>
		<td class="sizeup">${i.memfollower }</td>
		<td class="sizeup">${i.memfollwing }</td>
		<td>${i.claimed }회</td>
		<td>${i.memclaimed }회</td>
		<td>
			<select class="form-control" id="memstatus${i.memid }" name="memstatus" size="1">
				<c:if test="${i.memstatus eq 0}">
					<option value="0">회원상태 : 일반</option>
				</c:if>
				<c:if test="${i.memstatus eq 1}">
					<option value="1">회원상태 : 계정정지</option>
				</c:if>
				<c:if test="${i.memstatus eq 2}">
					<option value="2">회원상태 : 계정블록</option>
				</c:if>
				<c:if test="${i.memstatus eq 3}">
					<option value="3">회원상태 : 휴면계정</option>
				</c:if>
				<c:if test="${i.memstatus eq 9}">
					<option value="9">회원상태 : 관리자</option>
				</c:if>
				
				<option value="0">일반</option>
				<option value="1">일주일 계정정지</option>
				<option value="2">계정블록</option>
				<option value="9">관리자 계정</option>
			</select>
		</td>

		<td>
			<c:choose>
				<c:when test="${i.mempausetime eq null}">N/A</c:when>
				<c:when test="${i.mempausetime ne null}">
					<fmt:formatDate value="${i.mempausetime }" pattern="yyyy년MM월dd일까지" />
				</c:when>
			</c:choose>
		</td>

		
		<td><input type="button" class="btn btn-success" value="수정" onclick="updateMemberStatus('${i.memid}');"></td>
<%-- 		<td><input type="button" value="수정" onClick="location.href='/Manage_Page/updateMemberStatus.do?memid=${i.memid}&status='"></td> --%>
<!-- 		<td><button id="btnUpdate">수정</button> -->
	</tr>
</c:forEach>
</tbody>
</table>


<div class="clearfix"></div>

<div class="pull-right">
<button type="button" class="btn btn-primary btn-lg" onclick="toTheTop()">위로 ↑</button>
</div>

<jsp:include page="/resources/util/Manage_Page/paging.jsp" />


</div>		<!-- content end -->
</div>		<!-- container end -->
</div>		<!-- wrap end -->

</body>
</html>
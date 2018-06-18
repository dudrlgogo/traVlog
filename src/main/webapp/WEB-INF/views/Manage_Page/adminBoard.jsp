<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog Admin Board</title>

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

function deleteBoard(bodno) {
	
	var bno = bodno;
	
    var msg = "✔필수 체크 사항\n\n삭제된 게시물은 복구할 수 없습니다.\n삭제하시겠습니까?";
    var warning = "정말 삭제하시겠습니까?";
    
    if (confirm(msg) != 0) {
         // Yes click
        if (confirm(warning) != 0) {
	        alert(bno+"번 게시글을 영구삭제 합니다.");
			location.href='/Manage_Page/deleteBoard.do?bodno='+bno;
        } else {
	    	alert("삭제를 취소합니다.");
        }
    } else {
    	alert("삭제를 취소합니다.");
        // No click
        return;
	}
} // deleteBoard()

$(document).ready(function() {
	$("#btnSearch").click(function() {
		location.href="/Manage_Page/boardManage.do?searchContent="+$("#searchContent").val();
	});

	
// 	$("#deleteBtn").click(function() {
// 		alert("번 게시물 삭제");
// 	}); 
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

.red {
	color: red;
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
<h1 class="pagename">게시물 관리</h1>
<hr>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="searchContent" placeholder="게시물 제목, 작성자, 해시태그 검색 가능" style="min-width: 40%; height: 50px" />
	<button id="btnSearch" class="btn btn-info btn-lg">검색</button>
</div>

<div class="pull-left">
<button type="button" class="btn btn-primary btn-lg" onclick="toTheBottom()">아래로 ↓</button>
</div>

<hr>
<span class="pull-right" id="totalno">조회된 게시물 수 : ${paging.totalCount }</span>
<br>

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>해시태그</th>
		<th>추천수</th>
		<th>신고당한 수</th>
		<th>작성일</th>
		<th class="red">해당 게시물 삭제</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="i">
	<tr>
		<td>${i.bodno }</td>
		<td>${i.bodtitle }</td>
<%-- 		<td><a href="/Manage_Page/boardView.do?bodno=${i.bodno }">${i.bodtitle }</a></td> --%>
<%-- 		<td><a href="#" onclick="javascript:window.open('/Manage_Page/boardView.do?bodno=${i.bodno }','new','left=50, top=50, width=800, height=600')">${i.bodtitle }</a></td> --%>
		<td>${i.bodname }</td>
		<td>${i.bodhashtag }</td>
		<td>${i.bodrecommend }</td>
		<td>${i.claimed }</td>
		<td>
			<fmt:formatDate value="${i.boddate }" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" />
		</td>
<%-- 		<td><input type="button" id="deleteBtn" class="btn btn-danger" value="삭제" onClick="location.href='/Manage_Page/deleteBoard.do?bodno=${i.bodno}'"></td> --%>
		<td><input type="button" id="deleteBtn" class="btn btn-danger" value="삭제" onClick="deleteBoard('${i.bodno}');"></td>
	</tr>
</c:forEach>
</tbody>
</table>

<div class="clearfix"></div>

<jsp:include page="/resources/util/Manage_Page/paging.jsp" />
<br>

<div class="pull-right">
<button type="button" class="btn btn-primary btn-lg" onclick="toTheTop()">위로 ↑</button>
</div>

</div> <!-- content END -->
</div> <!-- container END -->
</div> <!-- wrap END -->
</body>
</html>
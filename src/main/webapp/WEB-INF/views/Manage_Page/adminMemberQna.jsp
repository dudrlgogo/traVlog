<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog Admin-Meber Q&A</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

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

.container {margin-left: 180px;}

</style>

</head>
<body>

<div class="wrap">
<jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" />

<div class="container">
<div class="content">


<div class="clearfix"></div>
<hr>
<span class="pull-right">전체 문의사항 수 : ${paging.totalCount }</span>
<br>

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>문의사항 번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>닉네임</th>
		<th>작성일</th>
		<th>답변여부</th>
<!-- 		<th class="red">해당 게시물 삭제</th> -->
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="i">
	<tr>
		<td>${i.qusno }</td>
		<td id="memid">${i.memid }</td>
		<td><a href="/Manage_Page/qnaView.do?qusno=${i.qusno }">${i.qustitle }</a></td>
		<td>${i.qusname }</td>
		<td>
			<fmt:formatDate value="${i.qusdate }" pattern="yyyy년MM월dd일 HH:mm:ss" />
		</td>
		<c:if test="${i.answered eq 1 }"><td>답변 완료</td></c:if>
		<c:if test="${i.answered eq 0 }"><td class="red">미답변</td></c:if>
<%-- 		<td class="red"><input type="button" id="deleteBtn" value="삭제" onClick="location.href='/Manage_Page/deleteBoard.do?boardno=${i.boardno}'"></td> --%>
	</tr>
</c:forEach>
</tbody>
</table>

<div class="clearfix"></div>

<jsp:include page="/resources/util/Manage_Page/qnaMemberPaging.jsp" />

</div> <!-- content END -->
</div> <!-- container END -->
</div> <!-- wrap END -->
</body>
</html>
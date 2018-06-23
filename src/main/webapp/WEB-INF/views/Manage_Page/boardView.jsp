<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog board Detail</title>

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

// $(document).ready(function() {
// 	$("#back").click(function() {
// 		history.back(-1);
// 	})
// });

</script>


<style type="text/css">

.container {
	width: 80%;
	min-width: 1200px;
	margin-left: 180px;
}

.content{
	margin:0 auto;
/* 	background: linear-gradient(20deg, skyblue, hotpink); */
 	background: #eee; 
	border: 3px outset skyblue;
}


.boardcontent {
	border: 5px ridge maroon;
	padding: 20px 30px 20px 30px;
	min-height: 250px; 
}

.content {
/* 	position: absolute; */
/* 	margin-left: 150px; */
/* 	width: 1000px; */
/* 	width: 70%; */
/* 	min-width: 500px; */
/* 	background: url('http://www.city.kr/files/attach/images/1326/873/829/004/dbba42174737c4934514a4569034db75.jpg'); */
/* 	background-size: cover; */
/* 	background-position: 0 50%; */
/* 	background: linear-gradient(20deg, skyblue, hotpink); */
}

.form-group {
	display: inline-block;
	width: 33%;
}

.pagename {
	color: skyblue;
/* 	text-shadow: 3px 3px 3px black, 3px 3px 5px gold; */
}

</style>

</head>
<body>

<div class="wrap">
<%-- <jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" /> --%>

<div class="container">
<div class="content">

<div>
<h1 class="pagename">게시글 상세보기</h1>
<hr>
</div><br>

<div class="form-group">
	<label for="bodno">게시글 번호</label><br>
	<input type="text" id="bodno" name="bodno" value="${boardView.bodno }" readonly="readonly" class="form-control"/>
</div>

<div class="form-group">
	<label for="bodname">작성자</label><br>
	<input type="text" id="bodname" name="bodname" value="${boardView.bodname }" readonly="readonly" class="form-control"/>
</div>

<div class="form-group">
	<label for="boddate">작성일</label><br>
<%-- 	<input type="text" id="writtendate" name="writtendate" value="${view.writtendate }" readonly="readonly" class="form-control"/> --%>
<input type="text" id="boddate" name="boddate" value="<fmt:formatDate value="${boardView.boddate }" pattern="yyyy년MM월dd일 HH시mm분ss초" />" readonly="readonly"  class="form-control">
</div>

<div class="form-group" style="width: 66%">
	<label for="bodtitle">제목</label><br>
	<input type="text" id="bodtitle" name="bodtitle" value="${boardView.bodtitle }" readonly="readonly" class="form-control"/>
</div>

<div class="form-group" style="width: 17%">
	<label for="claimed">신고</label><br>
	<input type="text" id="claimed" name="claimed" value="${boardView.claimed }" readonly="readonly" class="form-control"/>
</div>

<div class="form-group" style="width: 16%">
	<label for="bodrecommend">추천</label><br>
	<input type="text" id="bodrecommend" name="bodrecommend" value="${boardView.bodrecommend }" readonly="readonly" class="form-control"/>
</div>

<div class="boardcontent" id="content">
	<label for="content"></label><br>
<%-- 	<input type="text" id="content" name="content" value="${view.content }" readonly="readonly" class="form-control"/> --%>
${boardView.bodcontent }<br>
</div>

<div class="form-group" style="width: 100%">
<!-- 	<label for="bodhashtag">해시태그</label><br> -->
	<input type="text" id="bodhashtag" name="bodhashtag" value="${boardView.bodhashtag }" readonly="readonly" class="form-control"/>
</div>

<%-- 
<c:if test="${boardFileView.filsavefile ne null}">
	<c:forEach items="${boardFileView }" var="bf">
		<div style="width: 50%; height: 200px; line-height: 200px; text-align: center">
			<img src="/resources/upload/${bf.filsavefile }">
		</div>
	</c:forEach>
</c:if>
 --%>

<%-- <c:if test="${boardComentView.bodno ne null}"> --%>
	<c:forEach items="${boardComentView }" var="cmt">
<!-- 		<div class="form-group" style="width: 50%; margin-left: 10%;" > -->
		<div class="form-group" style="border: 1px solid black">
<!-- 			<label for="comwriter">작성자: </label> -->
			${cmt.comwriter }<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cmt.comcontent }
		</div>
	</c:forEach>
<%-- </c:if> --%>


<!-- <button id="back" class="center-block btn-warning btn-lg">이전 페이지로 돌아가기</button> -->

</div>	<!-- content END -->
</div>	<!-- container END -->
</div>	<!-- wrap END -->

</body>
</html>
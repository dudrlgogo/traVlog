<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog Q&A Detail</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	$("#back").click(function() {
		history.back(-1);
	})
});

</script>

<style type="text/css">

.container {
	width: 80%;
	min-width: 1200px;
	margin-left: 180px;
}

.content{
	margin:0 auto;
 	background: #eee; 
	border: 3px outset skyblue;
}

.quscontent, .anscontent {
	border: 5px ridge maroon;
	padding: 20px 30px 20px 30px;
	min-height: 250px; 
}

/* .content { */
/* 	position: absolute; */
/* 	margin-left: 150px; */
/* 	width: 1000px; */
/* 	width: 70%; */
/* 	min-width: 500px; */
/* 	background: url('http://www.city.kr/files/attach/images/1326/873/829/004/dbba42174737c4934514a4569034db75.jpg'); */
/* 	background-size: cover; */
/* 	background-position: 0 50%; */
/* 	background: linear-gradient(20deg, skyblue, hotpink); */
/* } */

.form-group {
	display: inline-block;
	width: 33%;
/* 	margin: 0 auto; */
}

.pagename {
	color: skyblue;
	text-shadow: 3px 3px 3px black, 3px 3px 5px gold;
}

input, p {
	text-align: center;
}

</style>

</head>
<body>

<div class="wrap">
<jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" />

<div class="container">
<div class="content">

<div>
<h1 class="pagename">문의사항 상세보기</h1>
</div>
<hr>

<div class="question">
<div class="form-group">
	<label for="qusno">문의사항 번호</label><br>
	<input type="text" id="qusno" name="qusno" value="${qusView.qusno }" readonly="readonly" class="form-control"/>
</div>


<div class="form-group">
	<label for="memid">작성자 아이디</label><br>
	<p id="memid" class="form-control"><a href="/Manage_Page/qnaList.do?memid=${qusView.memid }">${qusView.memid }</a></p>
</div>

<div class="form-group">
	<label for="qusname">작성자 닉네임</label><br>
	<input type="text" id="qusname" name="qusname" value="${qusView.qusname }" readonly="readonly" class="form-control"/>
</div>

<div class="form-group" style="width: 66%">
	<label for="qustitle">문의 제목</label><br>
	<input type="text" id="qustitle" name="qustitle" value="${qusView.qustitle }" readonly="readonly" class="form-control"/>
</div>

<div class="form-group">
	<label for="qusdate">작성일시</label><br>
<input type="text" id="qusdate" name="qusdate" value="<fmt:formatDate value="${qusView.qusdate }" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" />" readonly="readonly" class="form-control">
</div>


<div class="quscontent" id="quscontent">
	<label for="quscontent"></label><br>
<%-- 	<input type="text" id="content" name="content" value="${view.content }" readonly="readonly" class="form-control"/> --%>
${qusView.quscontent }<br>
</div><br>


</div>	<!-- question END -->
<hr class="line"><br>

<c:if test="${ansView.anstitle eq null }">
	<a href="/Manage_Page/qnaAnswer.do?qusno=${qusView.qusno }"><button class="center-block btn-success btn-lg">문의사항 답변</button></a>
</c:if>


<c:if test="${ansView.anstitle ne null }">
<div class="answer">
<h1 class="pagename">문의사항 답변</h1><br>

<div class="form-group" style="width: 66%">
	<label for="anstitle">답변 제목</label><br>
	<input type="text" id="anstitle" name="anstitle" value="${ansView.anstitle }" readonly="readonly" class="form-control"/>
</div>

<div class="form-group">
	<label for="ansdate">답변 작성일</label><br>
<input type="text" id="ansdate" name="ansdate" value="<fmt:formatDate value="${ansView.ansdate }" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" />" readonly="readonly" class="form-control">
</div>

<div class="anscontent" id="anscontent">
	<label for="anscontent"></label><br>
${ansView.anscontent }<br>
</div>
	
	<button id="back" class="center-block btn-warning btn-lg">이전 페이지로 돌아가기</button>
	
</div>	<!-- answer END -->
</c:if>

</div>	<!-- content END -->
</div>	<!-- container END -->
</div>	<!-- wrap END -->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog Notice Detail</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

.container {
	width: 80%;
	min-width: 1200px;
	margin-left: 180px;
}

.content{
	margin:0 auto;
/* 	background: linear-gradient(20deg, skyblue, #eee); */
	background: skyblue;
}

.notcontent {
	border: 5px ridge Black;
/* 	상, 우, 하, 좌 padding */
	padding: 20px 30px 20px 30px;
}

.form-group {
	display: inline-block;
/*  	width: 33%; */
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

<div>
<h1 class="pagename">공지사항 상세보기</h1>
<hr>
</div><br>

<div class="form-group" style="width: 15%">
	<label for="notno">공지사항 번호</label><br>
	<input type="text" id="notno" name="notno" value="${noticeView.notno }" readonly="readonly" class="form-control" />
</div>

<div class="form-group" style="width: 25%">
	<label for="notdate">작성일</label><br>
<input type="text" id="notdate" name="notdate" value="<fmt:formatDate value="${noticeView.notdate }" pattern="yyyy년MM월dd일 HH:mm:ss" />" readonly="readonly"  class="form-control">
</div>

<div class="form-group" style="width: 59%">
	<label for="nottitle">제목</label><br>
	<input type="text" id="nottitle" name="nottitle" value="${noticeView.nottitle }" readonly="readonly" class="form-control"/>
</div>

<div class="form-group">
	<label for="notfile">첨부파일: </label>
	<a href="/Manage_Page/nfdownload.do?notno=${noticeFile.notno }">${noticeFile.nforiginfile }</a><br>
</div><br>

<div class="notcontent" id="notcontent">
	<label for="notcontent"></label><br>
<%-- 	<input type="text" id="content" name="content" value="${view.content }" readonly="readonly" class="form-control"/> --%>
${noticeView.notcontent }<br>
</div>


<%-- 
<div class="form-group">
	<label for="notfile">첨부파일</label><br>
	<input type="text" id="notfile" name="notfile" value="<a href="/Manage_Page/noticedownload.do?notno=${noticeFile.notno }">${noticeFile.nforiginfile }</a>" readonly="readonly" class="form-control"/>
</div>
 --%>

<hr>

<div class="text-center">
<a href="noticeUpdate.do?notno=${noticeView.notno }"><button id="btnUpdate" class="btn-success btn-lg">공지사항 수정</button></a>
</div>

</div>	<!-- content END -->
</div>	<!-- container END -->
</div>	<!-- wrap END -->

</body>
</html>
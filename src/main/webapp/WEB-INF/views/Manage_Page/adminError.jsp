<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>traVlog Admin Error</title>

<script type="text/javascript">
window.onload = function() {
	setTimeout(function() {
		alert("권한이 있는 계정으로 로그인 후 접속해주세요.");
		location.href="/traVlog/login.do";
	}, 3100);
	
	var i=3;
	setInterval(function() {
		document.getElementById("time").innerText = --i;
	}, 1000);
};
</script>

<style type="text/css">

.title {
	color: red;
	text-align: center;
}

.images {
	width: 100%; 
	height: 200px; 
	line-height: 200px; 
	text-align: center;
}

</style>

</head>
<body>

<div>
	<h1 class="title">게시판 사용 권한 없음</h1>
	<hr>
</div>
<br>

<div class="images">
	<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaQvzoFQ2-I1sPPpDEBEIBnkFNv0UfwnuBw3-8ye9KZSF7dqs2Zg">
</div>
<hr>

<div>
	관리자 에러 페이지
	<span id="time">3</span>초후 메인화면으로 이동합니다...
</div>

</body>
</html>
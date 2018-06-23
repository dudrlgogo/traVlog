<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TraVlog find</title>

<link href="/resources/css/login.css" rel="stylesheet">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	
<script type="text/javascript">
$(document).ready(function(){
	$("#idfind").click(function(){
		
		if($("#idmemname").val() == "" || $("#idmemname").val() ==null){
			alert("이름을 입력해주세요.");
			return false;
		} 
		if($("#idmememail").val() == "" || $("#idmememail").val() ==null){
			alert("이메일을 입력해주세요.");
			return false;
		}
		
		$("#findid").submit();
		
	});
	

	$("#pwfind").click(function(){
		
		if($("#pwmemname").val() == "" || $("#pwmemname").val() ==null){
			alert("이름을 입력해주세요.");
			return false;
		} 
		if($("#pwmemid").val() == "" || $("#pwmemid").val() ==null){
			alert("아이디를 입력해주세요.");
			return false;
		}
		if($("#pwmememail").val() == "" || $("#pwmememail").val() ==null){
			alert("이메일을 입력해주세요.");
			return false;
		}
		
		$("#findpw").submit();
				
	});

});


</script>

</head>

<body>
<div id="wrap">

<div class="container"><!-- Begin #container -->

<div class="content-wrap">
<div class="content-op"></div>
<a class="logo" href="/traVlog/login.do"><img alt="traVlog" src="/resources/images/icon/logo.png" width="150px;"></a>

<div class="content-find">
	<div class="leftcon">
		<div>
		<strong>아이디 찾기</strong>
		<p>아래에 등록하신 이름과 이메일 주소를 입력해 주시면<br> 아이디를 입력하신 메일로 전송해드리겠습니다.</p>
		<form action="/traVlog/findid.do" id="findid" method="post">
			<label>닉네임</label>
			<input class="inputsize" id="idmemname" name="idmemname" type="text" required="required"><br>
			<label>이메일</label> 
			<input class="inputsize" id="idmememail" name="idmememail" type="email" required="required"><br>
			<button type="button" class="findbtn" id="idfind">아이디 찾기</button>
		</form>
		</div>
	
	</div>
	
	
	<div class="rightcon">
	<div>
		<strong>비밀번호 찾기</strong>
		<p>아래에 등록하신 이름과 아이디, 이메일 주소를 입력해주시면<br> 비밀번호를 입력하신 메일로 전송해드리겠습니다.</p>
		<form action="/traVlog/findpw.do" id="findpw" method="post">
			<label>닉네임</label>
			<input class="inputsize" id="pwmemname" name="pwmemname" type="text" required="required"><br>
			<label>아이디</label> 
			<input class="inputsize" id="pwmemid" name="pwmemid" type="text" required="required"><br>
			<label>이메일 주소</label>
			<input class="inputsize" id="pwmememail" name="pwmememail" type="email" required="required"><br>
			<button type="button" class="findbtn" id="pwfind">비밀번호 찾기</button>
			</form>
		</div>
	</div>
</div>

</div> <!-- End content-wrap -->

</div> <!-- // End #container -->

</div> <!-- // End #wrap -->
</body>

</html>
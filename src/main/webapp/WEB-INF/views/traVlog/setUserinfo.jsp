<%@page import="mvc.dto.Member"%>
<%@page import="mvc.dao.MemberDao"%>
<%@page import="mvc.dao.SettingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TraVlog 설정</title>

<link href="/resources/css/main.css" rel="stylesheet">
<link href="/resources/css/setting.css" rel="stylesheet">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	
<script type="text/javascript">

$(document).ready(function(){
    $("#btnUpdate").click(function(){
        // 확인 대화상자    
        if(confirm("수정하시겠습니까?")){
            document.form1.action = "/traVlog/updateUserinfo.do";
            document.form1.submit();
        }
    });
});

</script>

<style type="text/css">
body {
   background-image: url('/resources/images/BackGround/main.jpg');
   background-repeat: no-repeat;
   background-size: cover;
}
</style>
</head>

<body>
<div id="wrap">
	
<jsp:include page="/resources/util/Page/header.jsp" />


<div class="container"><!-- Begin #container -->

<div class="content-wrap">
<jsp:include page="/resources/util/Page/SettingSideMenu.jsp" />
<div class="content-op">
<div class="content">


<div class="userInfo">

<form name="form1" method="post">
<div class="userinfo">

	<div style="padding-top: 20px;">
	<h3>${member.memid }님의 회원 정보</h3>
	</div>
	<table>
			<tr>
                <td>이름</td>
                 <!-- id는 수정이 불가능하도록 readonly속성 추가 -->
                 
                <td><input name="memname" value="${member.memname}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>아이디</td>
                 <!-- id는 수정이 불가능하도록 readonly속성 추가 -->
                <td><input name="memid" value="${member.memid}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="mempassword" value="${member.mempassword }"></td><!-- name="userPw" --> 
            </tr>
            <tr>
                <td>닉네임</td>
                <td><input name="memnick" value="${member.memnick}"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input name="mememail" value="${member.mememail}"></td>
            </tr>
             <tr>
                <td>성별</td>
                <td><input name="memsex" value="${member.memsex}"></td>
            </tr>
             <tr>
                <td>나이</td>
                <td><input name="memage" value="${member.memage}"></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input name="memphone" value="${member.memphone}"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="수정" id="btnUpdate">
                    <input type="button" value="삭제" id="btnDelete">
                </td>
            </tr>
        </table>
	
</div>
</form>

<!-- </div> -->
<!-- <div class="btn"> -->
<!-- 	<button class="passchange" id="btnConfirm" onclick='passCheck()'>확인</button> -->
<!-- </div> -->


</div><!-- End content -->

</div>



</div> <!-- End content-wrap -->

</div> <!-- // End #container -->
<jsp:include page="/resources/util/Page/footer.jsp" />

</div> <!-- // End #wrap -->
</body>

</html>
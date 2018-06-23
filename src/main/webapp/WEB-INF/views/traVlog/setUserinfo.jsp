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
</head>

<body>
<div id="wrap">
   
<jsp:include page="/resources/util/Page/header.jsp" />


<div><!-- Begin #container -->

<div class="content-wrap">
<jsp:include page="/resources/util/Page/SettingSideMenu.jsp" />
<div class="content-op">
<div class="content">


<div class="userInfo">

<form name="form1" method="post">
<div class="userinfo">

   <div style="padding-top: 30px; padding-left: 200px; font-size:16px; ">
   <h3>${member.memid }님의 회원 정보</h3>
   </div>
   <table style="border-collapse: collapse; text-align: left;
          line-height: 1.5; margin : 20px 10px;">
         <tr>
                <th style="width: 150px; padding: 10px; text-align:center;
                font-weight: bold; vertical-align: top; border: 1px solid #ccc;">이름</th>
                 <!-- name은 수정이 불가능하도록 readonly속성 추가 -->
                 
                <td style="width: 350px; padding: 10px; text-align:center;
                   vertical-align: top; border: 1px solid #ccc;">
                   <input name="memname" value="${member.memname}" readonly="readonly"></td>
            </tr>
            <tr>
                <th style="width: 150px; padding: 10px; text-align:center;
                font-weight: bold; vertical-align: top; border: 1px solid #ccc;">아이디</th>
                 <!-- id는 수정이 불가능하도록 readonly속성 추가 -->
                <td style="width: 350px; padding: 10px; text-align:center;
                   vertical-align: top; border: 1px solid #ccc;">
                   <input name="memid" value="${member.memid}" readonly="readonly"></td>
            </tr>
            <tr>
                <th style="width: 150px; padding: 10px; text-align:center;
                font-weight: bold; vertical-align: top; border: 1px solid #ccc;">비밀번호</th>
                <td style="width: 350px; padding: 10px; text-align:center;
                   vertical-align: top; border: 1px solid #ccc;">
                <input type="password" name="mempassword" value="${member.mempassword }"></td><!-- name="userPw" --> 
            </tr>
            <tr>
                <th style="width: 150px; padding: 10px; text-align:center;
                font-weight: bold; vertical-align: top; border: 1px solid #ccc;">닉네임</th>
                <td style="width: 350px; padding: 10px; text-align:center;
                   vertical-align: top; border: 1px solid #ccc;">
                <input name="memnick" value="${member.memnick}"></td>
            </tr>
            <tr>
                <th style="width: 150px; padding: 10px; text-align:center;
                font-weight: bold; vertical-align: top; border: 1px solid #ccc;">이메일</th>
                <td style="width: 350px; padding: 10px; text-align:center;
                   vertical-align: top; border: 1px solid #ccc;">
                <input name="mememail" value="${member.mememail}"></td>
            </tr>
             <tr>
                <th style="width: 150px; padding: 10px; text-align:center;
                font-weight: bold; vertical-align: top; border: 1px solid #ccc;">성별</th>
                <td style="width: 350px; padding: 10px; text-align:center;
                   vertical-align: top; border: 1px solid #ccc;">
                <input name="memsex" value="${member.memsex}"></td>
            </tr>
             <tr>
                <th style="width: 150px; padding: 10px; text-align:center;
                font-weight: bold; vertical-align: top; border: 1px solid #ccc;">나이</th>
                <td style="width: 350px; padding: 10px; text-align:center;
                   vertical-align: top; border: 1px solid #ccc;">
                <input name="memage" value="${member.memage}"></td>
            </tr>
            <tr>
                <th style="width: 150px; padding: 10px; text-align:center;
                font-weight: bold; vertical-align: top; border: 1px solid #ccc;">전화번호</th>
                <td style="width: 350px; padding: 10px; text-align:center;
                   vertical-align: top; border: 1px solid #ccc;">
                <input name="memphone" value="${member.memphone}"></td>
            </tr>
            <br>
            <tr>
                <td colspan="2" align="center" style="padding-top:30px;">
                    <input type="button" value="수정" id="btnUpdate" style="border-style:solid; font-size:15px; border-radius: 2px;">
                    <input type="button" value="삭제" id="btnDelete" style="border-style:solid; font-size:15px; border-radius: 2px;">
                </td>
            </tr>
        </table>
   
</div>
</form>

<!-- </div> -->
<!-- <div class="btn"> -->
<!--    <button class="passchange" id="btnConfirm" onclick='passCheck()'>확인</button> -->
<!-- </div> -->


</div><!-- End content -->

</div>



</div> <!-- End content-wrap -->

</div> <!-- // End #container -->
<jsp:include page="/resources/util/Page/footer.jsp" />

</div> <!-- // End #wrap -->
</div>
</body>

</html>
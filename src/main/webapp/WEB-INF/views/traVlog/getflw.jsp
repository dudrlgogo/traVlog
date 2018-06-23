<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TraVlog 설정</title>

<link href="/resources/css/main.css" rel="stylesheet">
<link href="/resources/css/setting.css" rel="stylesheet">

<script type="text/javascript"
   src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
   

</head>

<body>
<div id="wrap">
   
<jsp:include page="/resources/util/Page/header.jsp" />


<div class="container"><!-- Begin #container -->

<div class="content-wrap">
<jsp:include page="/resources/util/Page/SettingSideMenu.jsp" />
<div class="content-op">
<div class="content">
 
    <div style="width:250px; height:150px; border-right:1px solid black; float:left; padding-top: 30px; padding-left:20px; 
    margin-right:10px; font-size:16px;">
    <h2>${memnick } 님이 팔로잉하는 회원</h2>
      <c:forEach var="flwing" items="${list}">
        <tr>
            <td style="border-top:1px solid black;">${flwing.flwid }</td><br>
        </tr>
      </c:forEach>
    </div>
    
        <div style="width:250px; height:150px; float:left; padding-top: 30px; padding-left:20px; font-size:16px;">
    <h2>${memnick } 님을 팔로우하는 회원</h2>
      <c:forEach var="flwer" items="${list1}">
        <tr>
            <td>${flwer.memid }</td>
        </tr>
      </c:forEach>
    </div> 

</div><!-- End content -->
</div>

</div> <!-- End content-wrap -->

</div> <!-- // End #container -->
<jsp:include page="/resources/util/Page/footer.jsp" />

</div> <!-- // End #wrap -->
</body>

</html>
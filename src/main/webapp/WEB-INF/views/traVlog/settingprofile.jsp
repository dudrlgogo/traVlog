<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TraVlog 설정</title>

<link href="/resources/css/main.css" rel="stylesheet">
<link href="/resources/css/setting.css" rel="stylesheet">
<link href="/resources/css/profiletext.css" rel="stylesheet">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	
<script type="text/javascript">
// 프로필 메시지 80자로 제한하기
$(function() {
      $('#profile_msg').keyup(function (e){
          var content = $(this).val();
          $(this).height(((content.split('\n').length + 1) * 4) + 'em');
          $('#counter').html(content.length + '/80');
      });
      $('#content').keyup();
});
$(document).ready(function(){
	$("#btnUpdate").click(function(){
		
	    document.frm.action = "/traVlog/insertprofile.do";
	    document.frm.submit();
	});
	$("#btnCancel").click(function() {
		history.back(-1);
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
    <form id="frm" name="frm" method="post" enctype="multipart/form-data" style="padding-top: 25px;">
        <table class="setprofile">
            <colgroup>
                <col width="15%">
                <col width="*"/>
            </colgroup>
            <tbody>
            	<tr>
                	<th>프로필 이미지</th>
                	<td><input type="file" id="profileimg" name="profileimg">
                </tr>
                <tr>
                	<th>프로필 메시지</th>
                    <td colspan="2" class="profile_text">
                        <textarea rows="20" cols="100" maxlength="80"  
                        title="프로필 메시지" id="profile_msg" name="pfText"></textarea>
                        <span id="counter">###</span>
                    </td>
                </tr>
                <tr>
                	<th></th>
                	 <td align="right"><button id="btnUpdate">수정</button></td>
                	 <td><button id="btnCancel">취소</button></td>
               	</tr>
                
            </tbody>
        </table>     
        <br/><br/>
          
    </form>



</div><!-- End content -->
</div>

</div> <!-- End content-wrap -->

</div> <!-- // End #container -->
<jsp:include page="/resources/util/Page/footer.jsp" />

</div> <!-- // End #wrap -->
</body>

</html>
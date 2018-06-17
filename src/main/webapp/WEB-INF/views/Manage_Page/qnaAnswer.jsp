<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notice Write Page</title>

<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- 네이버 스마트 에디터 -->
<script type="text/javascript" src="/resources/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">

//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
function submitContents(elClickedObj) {
    // 에디터의 내용이 textarea에 적용된다.
    oEditors.getById["anscontent"].exec("UPDATE_CONTENTS_FIELD", []);

    // 에디터의 내용에 대한 값 검증은 이곳에서
    // document.getElementById("ir1").value를 이용해서 처리한다.
    try {
        elClickedObj.form.submit();
    } catch(e) {}
}

var cusno = ${qusView.qusno };

$(document).ready(function() {
	$("#btnWrite").click(function() {
		alert(cusno+"번 문의사항 답변 작성 완료!!");
		submitContents($(this));
	});
	
	$("#title").focus();
	
	$("#cancel").click(function() {
		history.back(-1);
	})
	
});

</script>

<style type="text/css">


</style>


</head>
<body>


<div class="wrap">
<jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" />

<div class="container">
<div class="content">
<h1>문의사항 답변 작성</h1>
<hr>

<form action="/Manage_Page/qnaAnswer.do?qusno=${qusView.qusno }" method="post">
<%-- <div class="form-group">
	<label for="writer">작성자</label><br>
	<input type="text" id="writer" name="writer" value="${writer }" readonly="readonly" class="form-control"/>
</div> --%>
<input type="hidden" id="qusno" class="qusno" value="${qusView.qusno }">
	
<div class="form-group">
	<label for="anstitle">답변 제목</label><br>
	<input type="text" id="anstitle" name="anstitle" class="form-control" placeholder="답변 제목을 입력하세요." />
</div>

<div class="form-group">
	<label for="anscontent">내용</label><br>
	<textarea rows="10"id="anscontent" name="anscontent" style="display: none;">
	<b><span style="font-size: 11pt;">문의 제목 </span></b><span style="font-size: 11pt;"><b>:</b></span> ${qusView.qustitle }<br><br>
	<b><span style="font-size: 11pt;">문의 내용 </span></b><span style="font-size: 11pt;"><b>:</b></span> ${qusView.quscontent }<hr><br><br>
	</textarea>
</div>

<div class="form-group">
	<div class="col-sm-offset-5 col-sm-10">
		<button id="btnWrite" class="btn-success btn-lg">작성</button>
		<button id="cancel" class="btn-warning btn-lg">취소</button>
	</div>
</div>
	<!-- 가운데 정렬 class="center-block" -->
<!-- 	<button id="btnWrite" class="center-block btn-success btn-lg">작성</button>&nbsp;&nbsp; -->
<!-- 	<a href="/board/list.do">목록으로</a> -->
</form>
<!-- 	<button id="cancel" class="center-block btn-warning btn-lg">취소</button> -->

</div>	<!-- content END -->
</div>	<!-- container END -->
</div>	<!-- wrap END -->


<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "anscontent",
    sSkinURI: "/resources/smarteditor/SmartEditor2Skin.html",
    fCreator: "createSEditor2",
    htParams : {
    	bUseToolbar: true, // 툴바 사용여부
    	bUseVerticalResizer: false, //입력창 크기 조절바
    	bUseModeChanger: true //모드 탭
    }
});
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create PDF - Claim List</title>

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
}

</style>

</head>
<body>

<div class="wrap">
<jsp:include page="/resources/util/Manage_Page/sideMenu.jsp" />

<div class="container">
<div class="content">

<div class="center-block">
<h2>${message }</h2>
</div>
<br><br><br>

<button id="back" class="center-block btn-warning btn-lg">이전 페이지로 돌아가기</button>

</div> <!-- content END -->
</div> <!-- container END -->
</div> <!-- wrap END -->

</body>
</html>
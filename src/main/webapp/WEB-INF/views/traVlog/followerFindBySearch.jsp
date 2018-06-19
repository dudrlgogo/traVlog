<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="/resources/css/follow.css" rel="stylesheet">

<script>
function doFollow(memid){
	console.log("memid는"+memid);
	$.ajax({
		type:'post',
		url:'/traVlog/doFollow.do',
		data:{'memid':memid},
		dataType:'json',
		success:function(data){
			console.log('팔로우성공?'+data.KEY);
			$("#followBtn_"+memid).prop("disabled", true);
			$("#followBtn_"+memid).text("팔로우에 성공했습니다.");
			$("#followBtn_"+memid).css("width", "300px");
		},error:function(e){
			console.log('팔로우실패');		
		}
	});
}
</script>

<div class="left">
<strong class="title">검색 된 사용자</strong>
	<div class="left_content">
		<table class="recomm">
          <c:forEach items="${searchMemberList }" var="member">
             <tbody>
                  <tr>
                      <td class="Rimg" rowspan="2" ><img alt="" src="/resources/images/icon/user.png"></td>
                      <td><a href="#" class="recA">${member.memid}</a></td>
                  </tr>
                  <tr>
					<td><button class="followBtn" id="followBtn_${member.memid }" onclick="doFollow('${member.memid}')">팔로우</button></td>
                  </tr>
             </tbody>
          </c:forEach>
        	</table>
	</div>
</div>

		
		
		

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="pic">
	<c:forEach items="${selectContentPic }" var="p">
		<img class="viewpic" src="/resources/upload/${p.filsavefile }"
			alt="photo">
	</c:forEach>

	<button class="w3-button w3-black w3-display-left"
		onclick="plusDivs(-1)">&#10094;</button>
	<button class="w3-button w3-black w3-display-right"
		onclick="plusDivs(1)">&#10095;</button>
</div>

<div class="info">


	<div class="contents">
	
	<div class="dropdown">
    <button class="morebutton dropdown-toggle" id="menu1" type="button" data-toggle="dropdown">
    <img class="more" width="30px;" src="/resources/images/icon/more.png">
    </button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="update.do">수정</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="contentdelete.do?bodno=${selectContent.bodno }&memnick=${selectContent.bodname }">삭제</a></li>
      <li role="presentation" class="divider"></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">로그아웃</a></li>    
    </ul>
  </div>
	
	    <div class="user-card format-1-1 clearfix op-follow">
      <div class="profile-picture left">
        <a href="/naeun9564" target="_blank">
                 
    <c:forEach items="${selectprofile}" var="fc">             
    <img src= "/resources/profileImage/${fc.pfSavefile }" width="40px" height="40px">
    </c:forEach>
        </a>
      </div>
	
	     <div class="user-information nickname-alone">
        <div class="clearfix">
          <a class="nickname" href="/naeun9564" target="_blank">${selectContent.bodname }</a>

        </div>
        
    </div>
    
                <div class="scroll-bar-component op-scroll-bar-component">
              <div class="description-wrapper op-scrollable">
                <p class="description op-scroll-contents">
                ${selectContent.bodcontent } 
                </p>
              </div>
            </div>
    
</div>
 
</div>

        <div class="action">

 <div class="like-action op-like-action not-like">
 
 					<button id="recoBtn_${selectContent.bodno}" class="btnRecommend"
						onclick="recommend(${selectContent.bodno });">
						<c:if test="${selectContent.isExistsLikeData eq '1'}">
							<img id="like_${selectContent.bodno}" class="like" width="30px;"
								src="/resources/images/icon/liked.png">
						</c:if>
						<c:if test="${selectContent.isExistsLikeData eq '0'}">
							<img id="like_${selectContent.bodno }" class="like" width="30px;"
								src="/resources/images/icon/like.png">
						</c:if>
					</button>
					
				    <label>좋아요 <strong id="recommend_${selectContent.bodno }">${selectContent.recommendCnt }</strong>
						개
					</label>
     
          </div>
          </div>
          
          <div class="comment-wrapper op-comment-component">
           
           						<a id="showCommentBtn_${selectContent.bodno }"
							href="javascript:void(0);"
						onclick="showCommentBtn('${selectContent.bodno }')">댓글보기</a>
           
           </div>  
           
           	<div class="Bcomment">
		<label><strong class="commentNick">${sessionScope.memnick }</strong></label>
		<input type="text" id="comment_${selectContent.bodno }" name="comment"
			placeholder="댓글을 입력하세요 ..." style="width: 70%" required="required"></input>
		<a href="javascript:void(0);" id="commentBtn" style="width: 13%;"
			onclick="javacript:writeComment('${selectContent.bodno }')">입력</a> <br>
		<div class="showComment" id="showComment_${selectContent.bodno }"></div>
	</div>
          
</div>

<script>

var slideIndex = 1;
	showDivs(slideIndex);

	function plusDivs(n) {
	  showDivs(slideIndex += n);
	}

	function showDivs(n) {
	  var i;
	  var x = document.getElementsByClassName("viewpic");
	  if (n > x.length) {slideIndex = 1}    
	  if (n < 1) {slideIndex = x.length}
	  for (i = 0; i < x.length; i++) {
	     x[i].style.display = "none";  
	  }
	  x[slideIndex-1].style.display = "block";  
	}

	function deleteBoard(bodno) {
		
		var bno = bodno;
		
	    var msg = "삭제된 게시물은 복구할 수 없습니다.\n삭제하시겠습니까?";
	    
	    if (confirm(msg) != 0) {
	         // Yes click
	        if (confirm(warning) != 0) {
		        alert(bno+"번 게시글을 영구삭제 합니다.");
				location.href='/Manage_Page/deleteBoard.do?bodno='+bno;
	        } else {
		    	alert("삭제를 취소합니다.");
	        }
	    } else {
	    	alert("삭제를 취소합니다.");
	        // No click
	        return;
		}
	} // deleteBoard()
	
	
	
	   //댓글 작성function
   function writeComment(bodnumber){
      console.log(bodnumber);
      bodno = bodnumber;
      console.log($("#comment_"+bodno).val());
      var comContent = $("#comment_"+bodno).val();
      
      if(comContent == "" || comContent==null){
         alert("댓글을 입력하세요..");
      }
      else{
      //댓글 작성 ajax...
         $.ajax({
            type:'get',
            url:'/traVlog/writeComment.do',
            dataType:'html',
            data:{"bodno":bodno, "comcontent":comContent},
            success : function(data){
                  console.log("성공?");
                     $("#showComment_"+bodno).html(data);
                     //댓글작성하고나서 작성칸 비워달라그래서 넣어줌..
                     $("#comment_"+bodno).val("");
                     $("#showCommentBtn_"+bodno).text("댓글안보기");
                  },error:function(data){
                     alert("실패");
                  }
         });//ajax end
      }
   }
   //댓글 보여주기
   function showCommentBtn(bodnumber){
      console.log(bodnumber);
      bodno = bodnumber;
      var showStatus = $("#showCommentBtn_"+bodno).text();
      console.log($("#showCommentBtn_"+bodno).text());
      if(showStatus == "댓글보기"){
         $.ajax({
            type:'get',
            url:'/traVlog/writeComment.do',
            dataType:"html",
            data:{"bodno":bodno},
            success :function(data){
               console.log("성공?");
                  $("#showComment_"+bodno).html(data);
                  $("#showCommentBtn_"+bodno).text("댓글안보기");
            },error :function(e){
               alert("댓글이 없습니다. 댓글을 달아주세요!");
            }
         });//ajax 끝
      }else{//댓글감추기일때
         $("#showComment_"+bodno).html(" ");      
         $("#showCommentBtn_"+bodno).text("댓글보기");
      }
   }
 
//  댓글 업데이트
 function comUpdate(comno){
   console.log("수정버튼 눌림");
   var content = $("#showUpdateTag_"+comno).val();
   var commentDo = 'update';
   if(content == "" || content==null){
      alert("내용을 입력하세요..");
   }else{
      $.ajax({
         type:'get',
         url:'/traVlog/writeComment.do',
         data:{"comno":comno,"comcontent":content,"commentDo":commentDo,"bodno":bodno},
         dataType:"html",
         success:function(data){
             console.log("수정 성공");
            $("#showComment_"+bodno).html(data);
         },error:function(e){
             alert("실패");
         }
      });
   }//else 끝
 }
 //댓글 삭제
 function comDelete(comno){
    console.log("삭제버튼 눌림 comno: "+comno+"bodno:"+bodno);
    var commentDo = 'delete';
    $.ajax({
       type:'get',
       url:'/traVlog/writeComment.do',
       data:{"comno":comno,"commentDo":commentDo,"bodno":bodno},
       dataType:"html",
       success:function(data){
            $("#showComment_"+bodno).html(data);
          console.log("삭제 성공");
       },error:function(e){
           alert("삭제버튼 실패");
       }
    });
 }
 
 function recommend(a){
     var bodno = a;
        console.log("bodno : "+bodno);
        $.ajax({
            type: "get"
            , url: "/traVlog/recommend.do"
            , dataType: "json"
            , data: {
              bodno: bodno
            }
            , success: function(data) {
               console.log(data);

               if(data.result) {
                  $("#like_"+a).prop("src", "/resources/images/icon/liked.png");
               } else {
                  $("#like_"+a).prop("src", "/resources/images/icon/like.png");
               }
               console.log("AJAX a : "+a);
               console.log(data.recommend);
               $("#recommend_"+a).html(data.recommend);
               
            }
            , error: function(e) {
               alert("좋아요 실패. 다음에 이용해주세요.");
               console.log(e.responseText);
            }
         });
  }//function recommend(a) 끝
	
</script>


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
      <li role="presentation"><a role="menuitem" tabindex="-1" href="update.do">����</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="contentdelete.do?bodno=${selectContent.bodno }&memnick=${selectContent.bodname }">����</a></li>
      <li role="presentation" class="divider"></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">�α׾ƿ�</a></li>    
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
					
				    <label>���ƿ� <strong id="recommend_${selectContent.bodno }">${selectContent.recommendCnt }</strong>
						��
					</label>
     
          </div>
          </div>
          
          <div class="comment-wrapper op-comment-component">
           
           						<a id="showCommentBtn_${selectContent.bodno }"
							href="javascript:void(0);"
						onclick="showCommentBtn('${selectContent.bodno }')">��ۺ���</a>
           
           </div>  
           
           	<div class="Bcomment">
		<label><strong class="commentNick">${sessionScope.memnick }</strong></label>
		<input type="text" id="comment_${selectContent.bodno }" name="comment"
			placeholder="����� �Է��ϼ��� ..." style="width: 70%" required="required"></input>
		<a href="javascript:void(0);" id="commentBtn" style="width: 13%;"
			onclick="javacript:writeComment('${selectContent.bodno }')">�Է�</a> <br>
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
		
	    var msg = "������ �Խù��� ������ �� �����ϴ�.\n�����Ͻðڽ��ϱ�?";
	    
	    if (confirm(msg) != 0) {
	         // Yes click
	        if (confirm(warning) != 0) {
		        alert(bno+"�� �Խñ��� �������� �մϴ�.");
				location.href='/Manage_Page/deleteBoard.do?bodno='+bno;
	        } else {
		    	alert("������ ����մϴ�.");
	        }
	    } else {
	    	alert("������ ����մϴ�.");
	        // No click
	        return;
		}
	} // deleteBoard()
	
	
	
	   //��� �ۼ�function
   function writeComment(bodnumber){
      console.log(bodnumber);
      bodno = bodnumber;
      console.log($("#comment_"+bodno).val());
      var comContent = $("#comment_"+bodno).val();
      
      if(comContent == "" || comContent==null){
         alert("����� �Է��ϼ���..");
      }
      else{
      //��� �ۼ� ajax...
         $.ajax({
            type:'get',
            url:'/traVlog/writeComment.do',
            dataType:'html',
            data:{"bodno":bodno, "comcontent":comContent},
            success : function(data){
                  console.log("����?");
                     $("#showComment_"+bodno).html(data);
                     //����ۼ��ϰ��� �ۼ�ĭ ����޶�׷��� �־���..
                     $("#comment_"+bodno).val("");
                     $("#showCommentBtn_"+bodno).text("��۾Ⱥ���");
                  },error:function(data){
                     alert("����");
                  }
         });//ajax end
      }
   }
   //��� �����ֱ�
   function showCommentBtn(bodnumber){
      console.log(bodnumber);
      bodno = bodnumber;
      var showStatus = $("#showCommentBtn_"+bodno).text();
      console.log($("#showCommentBtn_"+bodno).text());
      if(showStatus == "��ۺ���"){
         $.ajax({
            type:'get',
            url:'/traVlog/writeComment.do',
            dataType:"html",
            data:{"bodno":bodno},
            success :function(data){
               console.log("����?");
                  $("#showComment_"+bodno).html(data);
                  $("#showCommentBtn_"+bodno).text("��۾Ⱥ���");
            },error :function(e){
               alert("����� �����ϴ�. ����� �޾��ּ���!");
            }
         });//ajax ��
      }else{//��۰��߱��϶�
         $("#showComment_"+bodno).html(" ");      
         $("#showCommentBtn_"+bodno).text("��ۺ���");
      }
   }
 
//  ��� ������Ʈ
 function comUpdate(comno){
   console.log("������ư ����");
   var content = $("#showUpdateTag_"+comno).val();
   var commentDo = 'update';
   if(content == "" || content==null){
      alert("������ �Է��ϼ���..");
   }else{
      $.ajax({
         type:'get',
         url:'/traVlog/writeComment.do',
         data:{"comno":comno,"comcontent":content,"commentDo":commentDo,"bodno":bodno},
         dataType:"html",
         success:function(data){
             console.log("���� ����");
            $("#showComment_"+bodno).html(data);
         },error:function(e){
             alert("����");
         }
      });
   }//else ��
 }
 //��� ����
 function comDelete(comno){
    console.log("������ư ���� comno: "+comno+"bodno:"+bodno);
    var commentDo = 'delete';
    $.ajax({
       type:'get',
       url:'/traVlog/writeComment.do',
       data:{"comno":comno,"commentDo":commentDo,"bodno":bodno},
       dataType:"html",
       success:function(data){
            $("#showComment_"+bodno).html(data);
          console.log("���� ����");
       },error:function(e){
           alert("������ư ����");
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
               alert("���ƿ� ����. ������ �̿����ּ���.");
               console.log(e.responseText);
            }
         });
  }//function recommend(a) ��
	
</script>


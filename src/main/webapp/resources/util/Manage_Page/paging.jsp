<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" type="text/css" href="/Manage_Page/css/Paging.css" />
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>

.pagination>.active>a, .pagination>.active>a:focus, 
.pagination>.active>a:hover, 
.pagination>.active>span, 
.pagination>.active>span:focus, 
.pagination>.active>span:hover 
{
    z-index: 2;
    color: #fff;
    cursor: default;
    background-color: #f16a0f !important;
    border-color: #f16a0f !important;
}
</style>

<div class="paging text-center">
	<ul class="pagination">
		<%-- 첫 페이지 버튼 --%>
		<%-- 첫 페이지가 아니면 버튼 노출 --%>
		<c:if test="${paging.curPage ne 1 }">
		<li>
<%-- 			<a href="${url }?pageNo=1"> --%>
			<a href="${url }?curPage=1&searchContent=${paging.searchContent }">
				<span aria-hidden="true">&larr;</span>
			</a>
		</c:if>

		
		<%-- 이전 페이지 버튼 --%>
		<%-- 첫 페이지면 금지 표시 --%>
		<c:if test="${paging.curPage ne 1 }">
		<li>
			<a href="${url }?pageNo=${paging.curPage-1 }&searchContent=${paging.searchContent }" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
		</c:if>
		
		<c:if test="${paging.curPage eq 1 }">
		<li class="disabled">
				<span aria-hidden="true">&laquo;</span>
		</li>
		</c:if>
		
		<%-- 페이징 번호 버튼 --%>
		<c:forEach begin="${paging.startPage }"
			end="${paging.endPage }"
			var="page">
			
			<%-- 페이지 번호가 현재페이지면 파랑색으로 보이기 --%>
	    <c:if test="${paging.curPage eq page }">
	    	<li class="active"><a href="${url }?curPage=${page }&searchContent=${paging.searchContent }">${page }</a></li>
	    </c:if>
	    <c:if test="${paging.curPage ne page }">
	    	<li><a href="${url }?curPage=${page }&searchContent=${paging.searchContent }">${page }</a></li>
	    </c:if>
		</c:forEach>
		
		<%-- 다음 페이지 버튼 --%>
		<%-- 마지막 페이지면 금지 표시 --%>
		<c:if test="${paging.curPage ne paging.totalPage }">
		<li>
			<a href="${url }?curPage=${paging.curPage+1 }&searchContent=${paging.searchContent }" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>
		</c:if>
	    <c:if test="${paging.curPage eq paging.totalPage }">
	    <li class="disabled"><span>&raquo;</span></li>
	    </c:if>		
	</ul>
</div>
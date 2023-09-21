<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 class="pt-5">게시글 조회</h1>
	<form action="<c:url value='/board/list'/>" method="get">
		<div class="input-group mb-3">
			<select class="form-control" name="t">
				<option value="all" <c:if test="${pm.cri.t == 'all'}">selected</c:if>>전체</option>
				<option value="total" <c:if test="${pm.cri.t == 'total'}">selected</c:if>>제목 + 내용</option>
				<option value="writer" <c:if test="${pm.cri.t == 'writer'}">selected</c:if>>작성자</option>
			</select>
			<input type="text" class="form-control" name="s" value="${pm.cri.s}">
			<button class="btn btn-outline-dark">검색</button>
		</div>
	</form>
	<table class="table table-warning table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>추천/비추천</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board" varStatus="vs">
				<tr>
					<td>${pm.totalCount - vs.index}</td>
					<td><a href="<c:url value='/board/detail/${board.bo_num }'/>">${board.bo_title }</a></td>
					<td>${board.bo_me_id }</td>
					<td>${board.bo_up }/${board.bo_down }</td>
					<td>${board.bo_views}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
			<li class="page-item">
				<a class="page-link" 
					href="<c:url value='/board/list${pm.cri.getUrl(pm.startPage-1) }'/>">이전</a>
			</li>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			<li class="page-item <c:if test='${pm.cri.page == i }'>active</c:if>">
				<a class="page-link" 
					href="<c:url value='/board/list${pm.cri.getUrl(i)}'/>">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next}">
			<li class="page-item">
				<a class="page-link" 
					href="<c:url value='/board/list${pm.cri.getUrl(pm.endPage+1) }'/>">다음</a>
			</li>
		</c:if>
	</ul>
</body>
</html>
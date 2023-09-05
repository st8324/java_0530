<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 리스트</h1>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>추천/비추천</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bo_num}</td>
					<td><a href="<c:url value='/board/detail?bo_num=${board.bo_num}'/>">${board.bo_title }</a></td>
					<td>${board.bo_me_id }</td>
					<td>${board.bo_views }</td>
					<td>${board.bo_up}/${board.bo_down}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<c:if test="${pm.prev}">
			<a href="<c:url value='/board/list${pm.cri.getUrl(pm.startPage-1) }'/>">이전</a>
		</c:if>
		<c:forEach begin="${pm.startPage }" end="${pm.endPage}" var="i">
			<a href="<c:url value='/board/list${pm.cri.getUrl(i) }'/>">${i}</a>
		</c:forEach>
		<c:if test="${pm.next}">
			<a href="<c:url value='/board/list${pm.cri.getUrl(pm.endPage+1) }'/>">다음</a>
		</c:if>
	</div>
	<a href="<c:url value='/board/insert'/>"><button>글쓰기</button></a>
</body>
</html>
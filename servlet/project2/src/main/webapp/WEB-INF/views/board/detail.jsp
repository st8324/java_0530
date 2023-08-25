<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="mt-5">게시글 상세</h1>
		<c:choose>
			<c:when test="${board == null }">
				<h2>삭제된 게시글이거나 등록되지 않은 게시글입니다.</h2>
			</c:when>
			<c:otherwise>
				<div class="form-group">
					<label>게시글 번호</label>
					<input type="text" name="bo_num" value="${board.bo_num}" readonly class="form-control">
				</div>
				<div class="form-group">
					<label>작성자</label>
					<input type="text" name="bo_me_id" value="${board.bo_me_id}" readonly class="form-control">
				</div>
				<div class="form-group">
					<label>제목</label>
					<input type="text" name="bo_title" value="${board.bo_title}" readonly class="form-control">
				</div>
			</c:otherwise>
		</c:choose>
		<a href="<c:url value='/board/list'/>" class="btn btn-outline-success">목록으로</a>
	</div>
</body>
</html>
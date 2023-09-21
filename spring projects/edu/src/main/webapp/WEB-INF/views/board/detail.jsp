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
	<h1 class="pt-5">게시글 상세</h1>
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" readonly value="${board.bo_title }">
	</div>
	<div class="form-group">
		<label>작성자</label>
		<input type="text" class="form-control" readonly value="${board.bo_me_id }">
	</div>
	<div class="form-group">
		<label>조회수</label>
		<input type="text" class="form-control" readonly value="${board.bo_views }">
	</div>
	<div class="form-group">
		<label>내용</label>
		<textarea class="form-control" readonly style="min-height: 400px">${board.bo_contents }</textarea>
	</div>
	<div class="form-group">
		<label>첨부파일</label>
		<c:forEach items="${fileList }" var="file">
			<a href="<c:url value='/download${file.fi_name}'/>" download="${file.fi_ori_name }">${file.fi_ori_name }</a>
		</c:forEach>
	</div>
</body>
</html>
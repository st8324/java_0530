<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
</head>
<body>

<h1>메일보내기</h1>
<form action="<c:url value='/mail'/>" method="post">
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" name="title">
	</div>
	<div class="form-group">
		<label>받는사람</label>
		<input type="text" class="form-control" name="to">
	</div>
	<div class="form-group">
		<label>내용</label>
		<textarea class="form-control" name="contents"></textarea>
	</div>
	<button>전송</button>
</form>
</body>
</html>

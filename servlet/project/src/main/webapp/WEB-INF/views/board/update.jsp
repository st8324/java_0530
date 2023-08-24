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
	<h1>게시글 수정</h1>
	<form action="<c:url value='/board/update'/>" method="post">
		<input type="hidden" name="bo_num" value="${board.bo_num }">
		<input type="text" name="title" placeholder="제목" value="${board.bo_title }"> <br>
		<button>등록</button>
	</form>
	
</body>
</html>
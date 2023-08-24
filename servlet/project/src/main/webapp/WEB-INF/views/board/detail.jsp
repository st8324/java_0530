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
	<h1>게시글 상세</h1>
	<div>제목 : ${board.bo_title }</div>
	<div>작성자:${board.bo_me_id }</div>
	
	<a href="<c:url value='/board/delete?bo_num=${board.bo_num}'/>">삭제</a> <br>
	<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>">수정</a> <br>
	<a href="<c:url value='/list'/>">목록으로</a>
	
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html>
<head>
	<title>스프링</title>
</head>
<body>
	<h1>메인</h1>
	<c:if test="${user == null }">
		<a href="<c:url value='/member/signup'/>">회원가입</a>
		<a href="<c:url value='/member/login'/>">로그인</a>
	</c:if>
	<c:if test="${user != null }">
		<a href="<c:url value='/member/logout'/>">로그아웃</a>
	</c:if>
	<a href="<c:url value='/board/list'/>">게시글 리스트</a>
</body>
</html>

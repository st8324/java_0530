<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value='/member/login'/>" method="post">
		<div class="form-group">
			<input type="text" name="me_id" class="form-control" placeholder="아이디">
		</div>
		<div class="form-group">
			<input type="password" name="me_pw" class="form-control" placeholder="비밀번호">
		</div>
		<input type="checkbox" name="autoLogin" id="autoLogin">
		<label for="autoLogin">자동 로그인</label>
		<button class="btn btn-success col-12">로그인</button>
	</form>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<c:url value='/member/signup'/>" method="post">
		<div class="form-group">
			<input type="text" name="me_id" class="form-control" placeholder="아이디">
		</div>
		<button class="btn btn-outline-dark col-12" type="button">아이디 중복체크</button>
		<div class="form-group">
			<input type="password" name="me_pw" class="form-control" placeholder="비밀번호">
		</div>
		<div class="form-group">
			<input type="password" name="me_pw2" class="form-control" placeholder="비밀번호 확인">
		</div>
		<div class="form-group">
			<input type="text" name="me_email" class="form-control" placeholder="이메일">
		</div>
		<button class="btn btn-success col-12">회원가입</button>
	</form>
</body>
</html>

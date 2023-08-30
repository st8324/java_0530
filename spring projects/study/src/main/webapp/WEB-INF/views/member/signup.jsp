<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<c:url value='/member/signup'/>" method="post">
		<input type="text" name="me_id" placeholder="아이디" required> <br>
		<input type="password" name="me_pw" placeholder="비번" required> <br>
		<input type="email" name="me_email" placeholder="이메일" required> <br>
		<button>회원가입</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/spring/login" method="post">
		<input type="text" name="username" value="member">
		<input type="password" name="password" value="member">
		<button>전송</button>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}">
	</form>
</body>
</html>
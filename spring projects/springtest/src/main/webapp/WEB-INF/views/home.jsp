<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	Hello world!${num}  
</h1>
<a href="<c:url value='/member/login?id=abc&pw=def'/>">id와 pw을 전송</a>
<form action="<c:url value='/member/login2'/>" method="get">
	<input type="text" name="id" > <br>
	<input type="password" name="pw" > <br>
	<button>전송</button>
</form>
<h1>여러 회원 정보를 서버에 전송 : login3</h1>
<form action="<c:url value='/member/login3'/>" method="get">
	<h3>회원1</h3>
	<input type="text" name="id" > <br>
	<input type="password" name="pw" > <br>
	<h3>회원2</h3>
	<input type="text" name="id" > <br>
	<input type="password" name="pw" > <br>
	<h3>회원3</h3>
	<input type="text" name="id" > <br>
	<input type="password" name="pw" > <br>
	<button>전송</button>
</form>
<h1>여러 회원 정보를 서버에 전송 : login4</h1>
<form action="<c:url value='/member/login4'/>" method="get">
	<c:forEach begin="0" end="2" var="i">
		<h3>회원${i+1}</h3>
		<input type="text" name="list[${i}].id" > <br>
		<input type="password" name="list[${i}].pw" > <br>
	</c:forEach>
	<button>전송</button>
</form>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<a href="<c:url value='?id=abc'/>">?를 이용하여 전송</a> <br>
	<a href="<c:url value='/abc'/>">경로에 데이터를 전송</a>
</body>
</html>

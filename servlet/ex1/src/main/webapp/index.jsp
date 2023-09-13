<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험</title>
</head>
<body>
	<h1>게시글 정보 조회(게시글 번호 검색)</h1>
	<form action="/ex1/selectBoard" method="get">
		<input type="text" name="search" placeholder="게시글 번호 검색">
		<button>조회</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 정보</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<tr>
			<td>${board.BOARD_NO }</td>
			<td>${board.BOARD_TITLE }</td>
			<td>${board.BOARD_WRITER }</td>
		</tr>
	</table>
	<a href="/ex1">메인페이지로 돌아가기</a>
</body>
</html>
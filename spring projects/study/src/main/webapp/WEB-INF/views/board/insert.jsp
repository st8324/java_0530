<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="<c:url value='/board/insert'/>" method="post" enctype="multipart/form-data">
		<input type="text" name="bo_title" placeholder="제목"> <br>
		<textarea rows="20" cols="30" name="bo_contents"  placeholder="내용"></textarea> <br>
		<input type="file" name="files"> <br>
		<input type="file" name="files"> <br>
		<input type="file" name="files"> <br>
		<button>등록</button>
	</form>
	
</body>
</html>
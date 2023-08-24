<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="" method="post">
		<input type="text" name="title" placeholder="제목"> <br>
		<input type="text" name="id" placeholder="작성자"> <br>
		<button>등록</button>
	</form>
	<script>
		<% 
			Boolean result = (Boolean)request.getAttribute("ok");
			if(result != null && result){
		%>
			alert('게시글 등록 성공!');
			location.href = '<c:url value="/list"/>';
		<%
			}else if(result != null && !result){
		%>
			alert('게시글 등록 실패!')
		<%
			}
		%>
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<form action="<%=request.getContextPath()%>/withdraw" method="post">
		<input type="text" name="id"> <br>
		<input type="password" name="pw"> <br>
		<button>탈퇴하기</button>
	</form>
	${withdraw }
	<script>
		<% 
			Boolean result = (Boolean)request.getAttribute("withdrawOk");
			if(result != null && result){
		%>
			alert('회원탈퇴 성공!')
		<%
			}else if(result != null && !result){
		%>
			alert('회원탈퇴 실패!')
		<%
			}
		%>
	</script>
</body>
</html>
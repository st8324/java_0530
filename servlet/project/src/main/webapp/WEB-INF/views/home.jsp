<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요.</h1>
	<h2>반갑습니다.</h2>
	<!-- 서버에서 보낸 msg를 jsp에서 출력 -->
	<h3><%=request.getAttribute("msg") %></h3>
	<%
		for(int i = 0; i<5; i++){
	%>
		<h4><%=i%></h4>	
	<%
		}
	%>
	<!-- 화면에서 서버로 데이터를 전송 -->
	<!-- action에는 컨텍스트 패스를 고려해서 url을 지정 -->
	<form action="/home" method="post">
		<input type="text" name="id">
		<button>전송</button>
	</form>
</body>
</html>
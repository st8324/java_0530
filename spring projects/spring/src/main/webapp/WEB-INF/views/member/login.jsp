<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.btn-kakao{
	background: url(<c:url value="/resources/img/kakao_login_large_narrow.png"/>);
	width: 366px; height: 90px; border: none; display: inline-block;
}

</style>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value='/member/login'/>" method="post">
		<div class="form-group">
			<label>아이디</label>
			<input type="text" class="form-control" name="me_id">
		</div>
		<div class="form-group">
			<label>비번</label>
			<input type="password" class="form-control" name="me_pw">
		</div>
		<div class="form-check-inline">
		  <label class="form-check-label">
		    <input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
		  </label>
		</div>
		<button class="btn btn-outline-warning col-12">로그인</button>
		<a class="btn-kakao mt-5" href="https://kauth.kakao.com/oauth/authorize?client_id=4e64b28ddafda35b866202c1a43c45a7&redirect_uri=http://localhost:8080/spring/kakao/login&response_type=code"></a>
	</form>

</body>
</html>






<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<c:url value='/member/signup'/>" method="post">
		<div class="form-group">
			<label>아이디</label>
			<input type="text" class="form-control" name="me_id">
		</div>
		<button class="btn btn-outline-success col-12" id="btn-check" type="button">아이디 중복 검사</button>
		<div class="form-group">
			<label>비번</label>
			<input type="password" class="form-control" name="me_pw">
		</div>
		<div class="form-group">
			<label>이메일</label>
			<input type="email" class="form-control" name="me_email">
		</div>
		<button class="btn btn-outline-warning col-12">회원가입</button>
	</form>
	<script type="text/javascript">
		$('#btn-check').click(function(){
			
			$.ajax({
				async : false, 
				type : 'post', 
				url : '<c:url value="/member/check/id"/>', 
				data : { id : $('[name=me_id]').val()}, 
				success : function(data){
					if(data){
						alert('사용 가능한 아이디입니다.')
					}else{
						alert('이미 사용중인 아이디입니다.')
					}
				}
			});
		})
		
	</script>
</body>
</html>






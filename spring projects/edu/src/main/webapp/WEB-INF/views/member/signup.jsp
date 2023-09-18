<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<c:url value='/member/signup'/>" method="post">
		<div class="form-group">
			<input type="text" name="me_id" class="form-control" placeholder="아이디">
		</div>
		<button class="btn btn-outline-dark col-12" type="button" id="btn-check">아이디 중복체크</button>
		<div class="form-group">
			<input type="password" name="me_pw" class="form-control" placeholder="비밀번호">
		</div>
		<div class="form-group">
			<input type="password" name="me_pw2" class="form-control" placeholder="비밀번호 확인">
		</div>
		<div class="form-group">
			<input type="text" name="me_email" class="form-control" placeholder="이메일">
		</div>
		<button class="btn btn-success col-12">회원가입</button>
	</form>
	<script type="text/javascript">
		let checkId = false;
		$('#btn-check').click(function(){
			//서버로 아이디를 전달=>Object로 id만 서버로 전송
			let id = $('[name=me_id]').val();
			if(id.trim() == ''){
				alert('아이디를 입력하세요.');
				return;
			}
			$.ajax({
				async : true,
				url : '<c:url value="/member/id/check"/>', 
				type : 'post', 
				data : {id : id}, 
				success : function (data){
					//서버에서 아이디 사용 가능여부를 알려주면 알림창으로 알려줌=>Object로 사용 가능/불가능만 알려주면 됨
					if(data){
						alert('사용 가능한 아이디입니다.');
						checkId = true;
					}else{
						alert('이미 사용중인 아이디입니다.')
					}
				}, 
				error : function(res){
					console.log(res);
				}
			});
		})
		$('form').submit(function(){
			if(!checkId){
				alert('아이디 중복 검사를 하세요.');
				return false;
			}
		})
		$('[name=me_id]').change(function(){
			checkId = false;
		})
	</script>
</body>
</html>

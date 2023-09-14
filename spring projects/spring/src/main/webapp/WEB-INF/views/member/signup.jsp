<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
<style type="text/css">
.error{
	color:#f00;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<c:url value='/member/signup'/>" method="post">
		<div class="form-group">
			<label>아이디</label>
			<label id="check-id-error" class="error"></label>
			<input type="text" class="form-control" name="me_id">
		</div>
		<div class="form-group">
			<label>비번</label>
			<input type="password" class="form-control" name="me_pw" id="pw">
		</div>
		<div class="form-group">
			<label>비번 확인</label>
			<input type="password" class="form-control" name="me_pw2">
		</div>
		<div class="form-group">
			<label>이메일</label>
			<input type="email" class="form-control" name="me_email">
		</div>
		<button class="btn btn-outline-warning col-12">회원가입</button>
	</form>
	<script type="text/javascript">
		let flag = false;
		$('[name=me_id]').keyup(function(){
			flag = false;
			let id = $(this).val();
			if(!/^[a-zA-Z]\w{5,19}$/.test(id)){
				$('#check-id-error').text('');
				return;
			}
			$.ajax({
				async : false, 
				type : 'post', 
				url : '<c:url value="/member/check/id"/>', 
				data : { id : id}, 
				success : function(data){
					if(data){
						$('#check-id-error').text('사용 가능한 아이디입니다.');
						flag = true;
					}else{
						$('#check-id-error').text('이미 사용중인 아이디입니다.');
					}
				}
			});
		})
		
		$(function(){
		    $("form").validate({
		        rules: {
		            me_id: {
		                required : true,
		                regex : /^[a-zA-Z]\w{5,19}$/
		            },
		            me_pw: {
		                required : true,
		                regex: /^\w{6,20}$/
		            },
		            me_pw2: {
		                required : true,
		                equalTo : pw
		            },
		            me_email: {
		                required : true,
		                email : true
		            }
		        },
		        //규칙체크 실패시 출력될 메시지
		        messages : {
		            me_id: {
		                required : "필수로입력하세요",
		                regex : "아이디는 6~20자이며, 첫글자는 영문자이어야 하고 영문,숫자로 되어야 합니다."
		            },
		            me_pw: {
		                required : "필수로입력하세요",
		                regex : "비번은 6~20자이며, 영문,숫자로 되어야 합니다."
		            },
		            me_pw2: {
		                required : "필수로입력하세요",
		                equalTo : "비밀번호와 일치하지 않습니다."
		            },
		            me_email: {
		                required : "필수로입력하세요",
		                email : "이메일 형식이 아닙니다."
		            }
		        },
		  		submitHandler : function(){
		  			if(!flag){
		  				alert('아이디 중복검사를 하세요.');
		  				return false;
		  			}
		  			return true;
		  		}
		    });
		})
		$.validator.addMethod(
		    "regex",
		    function(value, element, regexp) {
		        var re = new RegExp(regexp);
		        return this.optional(element) || re.test(value);
		    },
		    "Please check your input."
		);
	</script>
</body>
</html>






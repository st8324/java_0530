<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
</head>
<body>
	<h1>메인</h1>
	
	<script type="text/javascript">
	let data = {
		me_id : 'abc',
		me_pw : 'test'
	};
	$.ajax({
		async : false, /*비동기 : false => 동기화*/
		type : 'post', /*전송 방식 : get/post*/
		url : '<c:url value="/ajax/test"/>', /*데이터를 보낼 url*/
		data : JSON.stringify(data), /*보낼 데이터, 보통 객체나 json으로 보냄*/
		contentType : "application/json; charset=UTF-8", /*서버로 보낼 데이터의 타입 */
		dataType : "json", /* 서버에서 화면으로 보낸 데이터의 타입 */
		success : function(data){ /* ajax가 성공하면 실행될 메서드로 서버에서 보낸 데이터를 매개변수에 저장 */
			console.log(data);
		}
	});
	
	</script>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
</head>
<body>
	<h1>메인</h1>
	<button id="btn1" class="btn btn-outline-success">버튼1</button> <br>
	<button id="btn2" class="btn btn-outline-success mt-2">버튼2</button> <br>
	<button id="btn3" class="btn btn-outline-success mt-2">버튼3</button> <br>
	<button id="btn4" class="btn btn-outline-success mt-2">버튼4</button> <br>
	<script type="text/javascript">
	$('#btn1').click(function(){
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
	})
	$('#btn2').click(function(){
		let data = {
				bo_num : 1
		}
		$.ajax({
			async : false, 
			type : 'post', 
			url : '<c:url value="/ajax/test2"/>', 
			data : data, 
			dataType : "json",
			success : function(data){
				console.log(data)
			}
		});
	})
	$('#btn3').click(function(){
		let data = {
				bo_num : 1
		}
		$.ajax({
			async : false, 
			type : 'post', 
			url : '<c:url value="/ajax/test3"/>', 
			data : data, 
			success : function(data){
				console.log(data)
			}
		});
	})
	$('#btn4').click(function(){
		let data = {
				bo_num : 1
		}
		$.ajax({
			async : false, 
			type : 'post', 
			url : '<c:url value="/ajax/test4/1"/>', 
			success : function(data){
				console.log(data)
			}
		});
	})
	</script>
</body>
</html>

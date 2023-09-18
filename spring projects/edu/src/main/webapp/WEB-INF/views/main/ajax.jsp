<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div class="box1">json => json</div>
	<div class="box2">object => json</div>
	<div class="box3">object => object</div>
	<script type="text/javascript">
	$.ajax({
		async : true,
		url : '<c:url value="/ajax/test1"/>', 
		type : 'post', 
		data : JSON.stringify({me_id : 'abc', me_pw : 'def'}), 
		contentType : "application/json; charset=utf-8",
		dataType : "json", 
		success : function (data){
			let str = `
				<div> id : \${data.member.me_id}</div>
				<div> pw : \${data.member.me_pw}</div>
			`;
			$('.box1').html(str);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
	$.ajax({
		async : true,
		url : '<c:url value="/ajax/test2"/>', 
		type : 'post', 
		data : {me_id : 'abc', me_pw : 'def'}, 
		dataType : "json", 
		success : function (data){
			let str = `
				<div> id : \${data.member.me_id}</div>
				<div> pw : \${data.member.me_pw}</div>
			`;
			$('.box2').html(str);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
	$.ajax({
		async : true,
		url : '<c:url value="/ajax/test3"/>', 
		type : 'post', 
		data : {me_id : 'abc', me_pw : 'def'}, 
		success : function (data){
			let str = `
				<div> id : \${data.me_id}</div>
				<div> pw : \${data.me_pw}</div>
			`;
			$('.box3').html(str);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
	</script>
</body>
</html>

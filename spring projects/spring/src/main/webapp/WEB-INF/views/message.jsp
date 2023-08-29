<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<title>스프링</title>
</head>
<body>
	<script type="text/javascript">
	let msg = ${msg};
	
	if(msg != null | msg.msg != null){
		alert(msg.msg);
	}
	location.href = '<c:url value="/"/>' + msg.url;
	</script>
</body>
</html>

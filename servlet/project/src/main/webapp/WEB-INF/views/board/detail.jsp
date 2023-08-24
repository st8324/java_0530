<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세</h1>
	
	<c:if test="${board != null }">
		<div>제목 : ${board.bo_title }</div>
		<div>작성자:${board.bo_me_id }</div>
		
		<form action="<c:url value='/board/delete'/>" method="post" id="deleteForm" onsubmit="return checkId();">
			<button>삭제</button>
			<input type="hidden" name="bo_num" value="${board.bo_num }">
		</form> <br>
		<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>">수정</a> <br>
	</c:if>
	<c:if test="${board == null }">
		<h2>삭제되거나 등록되지 않은 게시글입니다.</h2>
	</c:if>
	<a href="<c:url value='/list'/>">목록으로</a>
	
	<script type="text/javascript">
		function checkId() {
			let bo_me_id = prompt('작성자 아이디를 입력하세요');
			if(bo_me_id != '${board.bo_me_id}'){
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
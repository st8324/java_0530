<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="<c:url value='/board/update'/>" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bo_num" value="${board.bo_num}">
		<input type="text" name="bo_title" placeholder="제목" value="${board.bo_title}"> <br>
		<textarea rows="20" cols="30" name="bo_contents"  placeholder="내용">${board.bo_contents }</textarea> <br>
		<h3>첨부파일</h3>
		<c:forEach items="${fileList}" var="file">
			<div class="box">
				<a  href="<c:url 
					value='/download${file.fi_name}'/>" 
					download="${file.fi_ori_name }"
				>${file.fi_ori_name }</a>
				<a href="#" class="btn-del" data-num="${file.fi_num}"><button type="button">X</button></a>
			</div>
		</c:forEach>
		<c:forEach begin="1" end="${3 - fileList.size() }">
			<input type="file" name="files"> <br>
		</c:forEach>
		<button class="btn-submit">등록</button>
	</form>
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		$('.btn-del').click(function(e){
			e.preventDefault();
			let fi_num = $(this).data('num');
			$('.btn-submit').before('<input type="file" name="files"> <br>');
			$('.btn-submit').before('<input type="hidden" name="delNums" value="'+fi_num+'"> <br>');
			$(this).parent().remove();
		})
	</script>
</body>
</html>
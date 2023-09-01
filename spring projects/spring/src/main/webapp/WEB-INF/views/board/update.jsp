<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="<c:url value='/board/update'/>" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bo_num" value="${board.bo_num }">
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="bo_title" value="${board.bo_title }">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input type="text" class="form-control" name="bo_me_id" value="${board.bo_me_id }" readonly>
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea name="bo_contents" id="summernote"></textarea>
		</div>
		<div class="form-group" id="file">
			<label>첨부파일</label>
			<c:forEach items="${board.fileVoList}" var="file">
				<a 	href="<c:url value='/download${file.fi_name }'/>"
					class="form-control" 
					download="${file.fi_ori_name}">${file.fi_ori_name } <span class="btn-del" data-num="${file.fi_num}">x</span></a>
			</c:forEach>
			<c:forEach begin="1" end="${3-board.fileVoList.size()}">
				<input type="file" class="form-control" name="files">
			</c:forEach>
		</div>
		<button class="btn btn-outline-success col-12">수정하기</button>
	</form>
	
	<script>
      $('#summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 400
      });
      $('#summernote').summernote('code', '${board.bo_contents}');
      $('.btn-del').click(function(e){
    	  e.preventDefault();
    	  let fi_num = $(this).data('num');
    	  $(this).parent().after('<input type="hidden" name="delFiles" value="'+fi_num+'">')
    	  $(this).parent().remove();
    	  $('#file').append('<input type="file" class="form-control" name="files">');
      });
    </script>
</body>
</html>





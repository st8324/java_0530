<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h1>게시글 리스트</h1>
		<table class="table table-hover">
		    <thead>
		      <tr>
		        <th>번호</th>
		        <th>제목</th>
		        <th>작성자</th>
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${list}" var="board">
			      <tr>
			        <!-- bo_num의 getter가 호출 => getBo_num()  -->
			        <td>${board.bo_num}</td>
			        <td><a href="<c:url value='${board.boardDetailUrl }'/>">${board.bo_title}</a></td>
			        <td>${board.bo_me_id}</td>
			      </tr>
			    </c:forEach>
		    </tbody>
		</table>
		<a href="" class="btn btn-outline-success">게시글 등록</a>
		<a href="" class="btn btn-outline-success">메인으로</a>
		
	</div>
</body>
</html>
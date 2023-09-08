<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
</head>
<body>
	<h1>게시판 타입 관리</h1>
	<div class="input-group mb-3 mt-3">
		<div class="input-group-prepend">
		    <select class="form-control" id="authority">
		      <option value="0">작성권한</option>
		      <option value="USER">회원이상</option>
		      <option value="ADMIN">관리자</option>
		    </select>
	    </div>
	    <input type="text" class="form-control" id="bt_title">
	    <button class="btn btn-outline-success btn-insert">등록</button>
	</div>
	<table class="table table-hover">
    <thead>
      <tr>
        <th>게시판 타입 번호</th>
        <th>게시판명</th>
        <th>권한</th>
        <th>기능</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="bt">
	      <tr>
	        <td>${bt.bt_num}</td>
	        <td><input type="text" value="${bt.bt_title}" class="form-control"></td>
	        <td>
	        	<select class="form-control" name="type">
			      <option value="USER" <c:if test="${bt.baList.size() == 2}">selected</c:if>>회원이상</option>
			      <option value="ADMIN"<c:if test="${bt.baList.size() == 1}">selected</c:if>>관리자</option>
			    </select>
	        </td>
	        <td>
	        	<button class="btn btn-outline-success">수정</button>
	        	<button class="btn btn-outline-warning">삭제</button>
			</td>
	      </tr>
      	</c:forEach>
    </tbody>
  </table>
  <script type="text/javascript">
  	$('.btn-insert').click(()=>{
  		let bt_title = $('#bt_title').val();
  		let bt_authority = $('#authority').val();
  		if(bt_authority == '0'){
  			alert('작성 권한을 선택하세요.');
  			return;
  		}
  		if(bt_title.trim().lenth == 0){
  			alert('게시판명을 입력하세요.');
  			return;
  		}
  		let boardType = {
  				bt_title : bt_title,
  				bt_authority : bt_authority
  		};
  		ajaxJsonToJson(false, post, "/admin/board/type/insert", boardType, (data)=>{
  			console.log(data);
  		});
  	});
  </script>
</body>
</html>

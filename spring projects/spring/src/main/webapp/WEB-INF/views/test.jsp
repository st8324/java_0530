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
	<div>
		<input id="pageNo" placeholder="페이지번호" value="1"> <br>
		<input id="numOfRows" placeholder="시설 개수" value="5"> <br>
		<button id="btn">조회</button>
	</div>
	
	<table>
		<thead>
			<tr>
				<th>시도명</th>
				<th>시군구명</th>
				<th>시설명</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		$('#btn').click(function(){
			let pageNo = $('#pageNo').val();
			let numOfRows = $('#numOfRows').val();
			$.ajax({
				url : '<c:url value="/api/request"/>',
				data: {
					pageNo : pageNo,
					numOfRows : numOfRows
				},
				success : function(data){
					let list = data.EarthquakeOutdoorsShelter[1].row;
					let str = '';
					for(item of list){
						str += 
							`
								<tr>
									<td>\${item.ctprvn_nm}</td>
									<td>\${item.sgg_nm}</td>
									<td>\${item.vt_acmdfclty_nm}</td>
								</tr>
							`;
					}
					$('tbody').html(str);
				},
				error : function(a,b,c){
					console.log(a)
				}
			})
		});
	</script>
</body>
</html>
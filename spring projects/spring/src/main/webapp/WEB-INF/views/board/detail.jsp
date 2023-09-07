<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
</head>
<body>
	<h1>게시글 상세</h1>
	<div class="form-group">
		<label>제목</label>
		<div class="form-control">${board.bo_title}</div>
	</div>
	<div class="form-group">
		<label>작성자</label>
		<div class="form-control">${board.bo_me_id}</div>
	</div>
	<div class="form-group">
		<label>조회수</label>
		<div class="form-control">${board.bo_views}</div>
	</div>
	<div class="form-group">
		<label>등록일</label>
		<div class="form-control">${board.bo_reg_date_str}</div>
	</div>
	<c:if test="${board.bo_up_date != null }">
		<div class="form-group">
			<label>수정일</label>
			<div class="form-control">${board.bo_up_date_str}</div>
		</div>
	</c:if>
	<div class="form-group clearfix">
		<button class="btn btn-like btn<c:if test="${like.li_state!=1 }">-outline</c:if>-primary btn-up col-6 float-left">추천(<span class="text-up">${board.bo_up }</span>)</button>
		<button class="btn btn-like btn<c:if test="${like.li_state!=-1 }">-outline</c:if>-danger btn-down col-6 float-right">비추천(<span class="text-down">${board.bo_down }</span>)</button>
	</div>
	<div class="form-group">
		<label>내용</label>
		<div class="form-control" style="min-height: 400px">${board.bo_contents}</div>
	</div>
	
	<div class="form-group">
		<c:choose>
			<c:when test="${board.fileVoList.size() != 0 }">
				<label>첨부파일</label>
				<c:forEach items="${board.fileVoList }" var="file">
					<a class="form-control" href="<c:url value='/download${file.fi_name}'/>" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<label>첨부파일 없음</label>
			</c:otherwise>
		</c:choose>
	</div>
	<a href="<c:url value='/board/list${cri.currentUrl }'/>" class="btn btn-outline-primary">목록으로</a>
	<a href="<c:url value='/board/insert?bo_ori_num=${board.bo_num}'/>" class="btn btn-outline-success">답글</a>
	<c:if test="${user.me_id == board.bo_me_id}">
		<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>" class="btn btn-outline-warning">수정</a>
		<a href="<c:url value='/board/delete?bo_num=${board.bo_num}'/>" class="btn btn-outline-danger">삭제</a>
	</c:if>
	
	<div class="comment-contaier mt-5">
		<!-- 댓글 입력창  -->
		<div class="input-group mb-3">
			<textarea class="form-control" placeholder="댓글" name="co_contents"></textarea>
		    <div class="input-group-append">
		        <button class="btn btn-outline-success btn-comment-insert">등록</button>
		    </div>
		</div>
		<!-- 댓글 목록창 -->
		<div class="comment-list">
			<div class="border rounded-sm border-danger p-3 mt-3 comment-box">
				<div class="">작성자아이디</div>
				<div class="input-group mb-3">
				    <div class="col-9">
				        댓글 내용
				    </div>
				    <div class="col-3">
				    	작성일
				    </div>
				</div>
			</div>
			<div class="border rounded-sm border-danger p-3 mt-3 comment-box">
				<div class="">작성자아이디</div>
				<div class="input-group mb-3">
				    <div class="col-9">
				        댓글 내용
				    </div>
				    <div class="col-3">
				    	작성일
				    </div>
				</div>
			</div>
		</div>
		<!-- 댓글 페이지네이션 -->
		<ul class="pagination justify-content-center mt-3 comment-pagination">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
		</ul>
	</div>
	<!-- 추천 기능 자바스크립트 -->
	<script type="text/javascript">
		//추천 버튼을 클릭했을 때 콘솔창에 추천이라고 출력 
		$('.btn-like').click(function(){
			if('${user.me_id}' == ''){
				//alert('로그인한 회원만 이용이 가능합니다.');
				if(confirm('로그인 화면으로 이동하겠습니까?')){
					location.href = '<c:url value="/member/login"/>'
				}
				return;
			}
			let li_state = $(this).hasClass('btn-up')? 1 : -1;
			let data = {
				li_me_id : '${user.me_id}',
				li_bo_num: '${board.bo_num}',
				li_state : li_state
			};
			ajaxJsonToJson(false, 'post', '/board/like', data, (data)=>{
				if(data.res == 1){
					alert('추천했습니다.');		
				}else if(data.res == -1){
					alert('비추천했습니다.');
				}else if(data.res == 0){
					if(li_state == 1){
						alert('추천을 취소했습니다.');
					}
					else{
						alert('비추천을 취소했습니다.');
					}
				}
				diplayLikeBtn(data.res);
				$('.text-up').text(data.board.bo_up);
				$('.text-down').text(data.board.bo_down);
			})
		})
		
		
		
		function diplayLikeBtn(li_state){
			let $upBtn = $('.btn-up');
			let $downBtn = $('.btn-down');
			
			$upBtn.removeClass('btn-primary').addClass('btn-outline-primary');
			$downBtn.removeClass('btn-danger').addClass('btn-outline-danger');
			
			if(li_state == 1){
				$upBtn.addClass('btn-primary').removeClass('btn-outline-primary');	
			}else if(li_state == -1){
				$downBtn.addClass('btn-danger').removeClass('btn-outline-danger');
			}
		}
		
	</script>

<!-- 댓글 기능 자바스크립트 -->
<script type="text/javascript">
	//로그인하지 않고 댓글 창을 활성화했을 때 처리하기 위한 코드 
	$('[name=co_contents]').focus(function(){
		if('${user.me_id}' == ''){
			if(confirm('댓글을 작성하려면 로그인 해야합니다. 로그인을 하겠습니까?')){
				location.href = '<c:url value="/member/login"/>';
			}
			$(this).blur();
			return;
		}
	});
	//댓글 등록버튼을 클릭했을 때
	$('.btn-comment-insert').click(()=>{
		//로그인 확인
		if('${user.me_id}' == ''){
			if(confirm('댓글을 작성하려면 로그인 해야합니다. 로그인을 하겠습니까?')){
				location.href = '<c:url value="/member/login"/>';
			}
			return;
		}
		let co_contents = $('[name=co_contents]').val();
		//댓글 내용 확인  
		if(co_contents == ''){
			alert('내용을 입력하세요.');
			return;
		}
		let comment = {
				co_contents : co_contents,
				co_bo_num : '${board.bo_num}',
				co_me_id : '${user.me_id}'
		}
		//댓글을 등록
		ajaxJsonToJson(false,'post','/comment/insert', comment,(data)=>{
			if(data.res){
				alert('댓글을 등록했습니다.');
				$('[name=co_contents]').val('');
			}else{
				alert('댓글을 등록하지 못했습니다.');
			}
			cri.page = 1;
			getCommentList(cri);
		});
	});
	
	
	$(document).on('click', '.btn-comment-update', function(){
		revertBox();
		let commentBox = $(this).parents('.comment-box')
		changeBox(commentBox);
	})
	$(document).on('click', '.btn-update-complete', function(){
		let co_num = $(this).parents('.comment-box').find('[name=co_num]').val();
		let co_contents = $(this).parents('.comment-box').find('[name=co_contents]').val();
		
		if(co_contents == ''){
			alert('내용을 입력하세요.');
			return;
		}
		
		let comment = {
			co_num : co_num,
			co_me_id : '${user.me_id}',
			co_contents : co_contents 
		}
		
		ajaxJsonToJson(false,'post','/comment/update', comment ,(data)=>{
			if(data.res){
				alert('댓글을 수정했습니다.')
			}else{
				alert('댓글을 수정하지 못했습니다.')
			}
			getCommentList(cri);
		});
	});
	
	
	let cri = {
			page : 1,
			perPageNum : 2,
	}
	//게시글이 화면에 출력되고 이어서 댓글이 화면에 출력되어야 하기 때문에 이벤트 등록없이 바로 호출
	getCommentList(cri);
	
	
	function revertBox(){
		$('[name=co_contents]').remove();
		$('.btn-update-complete').remove();
		$('.contents-box').show();
		$('.btn-group').show();
	}
	function changeBox(commentBox){
		let $contentsBox = commentBox.find('.contents-box');
		let contents = $contentsBox.text().trim(); 
		$contentsBox.hide().after('<textarea class="form-control col-9" name="co_contents">'+contents+'</textarea>');
		let $btnGroup = commentBox.find('.btn-group');
		$btnGroup.hide().after('<button class="btn btn-outline-success btn-update-complete">수정완료</button>')
	}
	
	//현재 페이지 정보가 주어지면 현재 페이지에 맞는 댓글 리스트를 가져와서 화면에 출력하는 함수 
	function getCommentList(cri){
		ajaxJsonToJson(false,'post','/comment/list/${board.bo_num}', cri ,(data)=>{
			//댓글 리스트 추가
			createCommentList(data.list, '.comment-list');
			
			createPagination(data.pm, '.comment-pagination');
		});
	}
	function createPagination(pm, target){
		let str = '';
		if(pm.prev){
			str += `<li class="page-item"><a class="page-link" href="javascript:void(0);" onclick="cri.page=\${pm.startPage-1};getCommentList(cri)">이전</a></li>`;
		}
		for(i=pm.startPage; i<=pm.endPage; i++){
			let active = pm.cri.page == i ? 'active' : '';
			str += `
			<li class="page-item \${active}">
				<a class="page-link" href="javascript:void(0);" onclick="cri.page=\${i};getCommentList(cri)">\${i}</a>
			</li>`;
		}
		if(pm.next){
			str += `<li class="page-item"><a class="page-link" href="javascript:void(0);" onclick="cri.page=\${pm.endPage+1};getCommentList(cri)">다음</a></li>`;
		}
		$(target).html(str);
	}
	
	//댓글 리스트가 주어지면 댓글을 만들어서 target안에 넣어주는 함수 
	function createCommentList(commentList, target){
		let str = '';
		if(commentList.length == 0){
			str = '<div class="border rounded-sm border-danger p-3 mt-3">등록된 댓글이 없습니다.</div>';
		}
		for(comment of commentList){
			let btnStr = '';
			if('${user.me_id}' == comment.co_me_id){
				btnStr = `
				<div class="btn-group">
					<button class="btn btn-outline-warning btn-comment-update" data-num="\${comment.co_num}">수정</button>
					<button class="btn btn-outline-danger btn-comment-delete" onclick="deleteComment(\${comment.co_num})">삭제</button>
				</div>
				`;
			}
			str += `
				<div class="border rounded-sm border-danger p-3 mt-3 comment-box">
					<input type="hidden" name="co_num" value="\${comment.co_num}">
					<div class="">\${comment.co_me_id}</div>
					<div class="input-group mb-3">
					    <div class="col-9 contents-box">
					        \${comment.co_contents}
					    </div>
					    <div class="col-3">
					    	작성일
					    </div>
					</div>
					\${btnStr}
				</div>`;
		}
		$(target).html(str);
	}
	//댓글을 삭제하는 함수
	function deleteComment(co_num){
		let comment = { 
				co_num : co_num,
				co_me_id : '${user.me_id}',
				co_bo_num : '${board.bo_num}'
		}
		ajaxJsonToJson(false,'post','/comment/delete', comment ,(data)=>{
			if(data.res){
				alert('댓글을 삭제했습니다.')
			}else{
				alert('댓글을 삭제하지 못했습니다.')
			}
			cri.page = 1;
			getCommentList(cri);
		});
	}
</script>
</body>
</html>

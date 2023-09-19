<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="<c:url value='/'/>">Logo</a>
	
	<!-- Links -->
	<ul class="navbar-nav">
		<c:if test="${user == null }">
			<li class="nav-item">
			  	<a class="nav-link" href="<c:url value='/member/signup'/>">회원가입</a>
			</li>
			<li class="nav-item">
			  	<a class="nav-link" href="<c:url value='/member/login'/>">로그인</a>
			</li>
		</c:if>
		<li class="nav-item">
		  	<a class="nav-link" href="<c:url value='/ajax/test'/>">ajax 테스트</a>
		</li>
		<c:if test="${user != null }">
			<li class="nav-item">
			  	<a class="nav-link" href="<c:url value='/member/logout'/>">로그아웃</a>
			</li>
		</c:if>
		<!-- Dropdown -->
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			  게시글
			</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="<c:url value='/board/list'/>">게시글 조회</a>
				<a class="dropdown-item" href="<c:url value='/board/insert'/>">게시글 등록</a>
				<a class="dropdown-item" href="#">Link 3</a>
			</div>
		</li>
	</ul>
</nav>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="<c:url value='/' />">
    <img src="<c:url value='/resources/img/logo.jpg'/>" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
  	<c:if test="${user == null}">
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/signup' />">회원가입</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/login'/>">로그인</a>
	    </li>
    </c:if>
    <c:if test="${user != null }">
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/logout'/>">로그아웃</a>
	    </li>
    </c:if>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value='/board/list'/>">게시판</a>
    </li>
    
    <c:if test="${user != null && user.me_role == 'ADMIN' }">
	    <li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	        관리자
	      </a>
	      <div class="dropdown-menu">
	        <a class="dropdown-item" href="<c:url value='/admin/board/type'/>">게시판 타입 관리</a>
	      </div>
	    </li>
    </c:if>
  </ul>
</nav>

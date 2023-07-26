<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    
</div>
<header>
    <div id="title">
    	<a href="${contextPath}">
	        <img src="${contextPath}/resources/images/logo.svg">&nbsp;&nbsp;
        </a>
        <a href="${contextPath}">
	        <p>Mixology Connect</p>
        </a>
    </div>
    <div id="account">
        <input id="login" type="checkbox">
        <label for="login">
            <img src="${contextPath}/resources/images/user.png">
            <p>계정</p>
        </label>
    </div>
</header>
<nav>
    <a class="themes-content-1">안내</a>
    <a class="themes-content-1" href="${contextPath}/column/columnAll">칼럼</a>
    <a class="themes-content-1" href="${contextPath}/board/boardAll?type=1">커뮤니티</a>
    <a class="themes-content-1" href="${contextPath}/cocktail/cocktailAll">칵테일</a>
    <a class="themes-content-1" href="${contextPath}/cocktailTest/cocktailTest">테스트</a>
    <a class="themes-content-1" href="${contextPath}/member/signUpterms">회원가입</a>
    <a class="themes-content-1" href="${contextPath}/member/myPage/info">마이페이지</a>
</nav>
<div id="theme-switch">
	<input type="checkbox">
	<img>
</div>
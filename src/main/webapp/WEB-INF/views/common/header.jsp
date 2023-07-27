<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="overlay">
    <div id="modal-account">
        <form id="modal-account-form" action="${contextPath}/member/login" method="post">
            <img id="modal-account-logo" src="${contextPath}/resources/images/logo2.svg">
            <p id="modal-account-head">Mixology Connect</p>
            <p id="modal-account-login">로그인</p>
            <input class="modal-account-input" name="inputId" type="text" placeholder="ID">
            <input class="modal-account-input" name="inputPw" type="password" placeholder="PW">
            <button id="modal-account-button">LOGIN</button>
        </form>
    </div>
</div>
<div id="account">
    <c:choose>
        <c:when test="${!empty loginMember}">
        	<a href="${contextPath}/myPage/myPage">
	            <img class="account-image" src="${contextPath}/resources/images/user1.png">
	            <p class="account-text">마이페이지</p>
            </a>
        </c:when>
        <c:otherwise>
            <input id="login" type="checkbox">
            <label id="login-label" for="login">
                <img class="account-image"src="${contextPath}/resources/images/user.png">
                <p class="account-text">계정</p>
            </label>
        </c:otherwise>
    </c:choose>
</div>


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
</header>
<nav>
    <a class="themes-content-1">안내</a>
    <a class="themes-content-1" href="${contextPath}/column/columnAll">칼럼</a>
    <a class="themes-content-1" href="${contextPath}/board/boardAll?type=1">커뮤니티</a>
    <a class="themes-content-1" href="${contextPath}/cocktail/cocktailList">칵테일</a>
    <a class="themes-content-1" href="${contextPath}/cocktailTest/cocktailTest">테스트</a>
    <a class="themes-content-1" href="${contextPath}/member/signUpterms">회원가입</a>
    <a class="themes-content-1" href="${contextPath}/member/myPage/info">마이페이지</a>
</nav>
<div id="theme-switch">
	<input type="checkbox">
	<img>
</div>

<c:if test="${!empty sessionScope.message}">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session"/>
</c:if>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <div id="login-overlay"></div> -->
<header class="themes-main-2">
    <div id="title">
        <img src="https://i.ibb.co/9ZDf4Jk/logo.png">&nbsp;&nbsp;
        <p>Mixology Connect</p>
    </div>
    <div id="account">
        <input id="login" type="checkbox">
        <label for="login">
            <img src="https://i.ibb.co/hdK6rgX/keyhole.png">
            <p>LOGIN</p>
        </label>
    </div>
</header>
<nav class="themes-main-2">
    <a class="themes-content-1">안내</a>
    <a class="themes-content-1">칼럼</a>
    <a class="themes-content-1" href="${contextPath}/board/boardAll">커뮤니티</a>
    <a class="themes-content-1" href="${contextPath}/cocktail/list">칵테일</a>
    <a class="themes-content-1" href="${contextPath}/cocktailTest/cocktailTest">테스트</a>
    <a class="themes-content-1" href="${contextPath}/member/signUpterms">회원가입</a>
</nav>
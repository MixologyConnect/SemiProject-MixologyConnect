<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="login-overlay"></div>
<nav class="themes-main-1">
    <div id="navTop" class="themes-main-2">
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
    </div>
    <div id="navBottom" class="themes-main-2">
        <a class="themes-content-1">안내</a>
        <a class="themes-content-1">칼럼</a>
        <a class="themes-content-1">커뮤니티</a>
        <a class="themes-content-1" href="${contextPath}/cocktail/list">칵테일</a>
        <a class="themes-content-1">테스트</a>
    </div>
</nav>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="account">
    <c:choose>
        <c:when test="${!empty loginMember}">
            <a href="${contextPath}/myPage/myPage">
              <label id="account-label">
                  <img class="account-image" src="${contextPath}/resources/images/user.png">
                  <p class="account-text">마이페이지</p>
              </label>
            </a>
        </c:when>
        <c:otherwise>
            <input id="account-cbox" type="checkbox">
            <label id="account-label" for="account-cbox">
                <img class="account-image" src="${contextPath}/resources/images/key.png">
                <p class="account-text">계정</p>
            </label>
        </c:otherwise>
    </c:choose>
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
    <a>안내</a>
    <a href="${contextPath}/column/columnList?type=3">칼럼</a>
    <a href="${contextPath}/board/boardAll?type=1">커뮤니티</a>
    <a href="${contextPath}/cocktail/cocktailList">칵테일</a>
    <a href="${contextPath}/cocktailTest/cocktailTest">테스트</a>
    <a href="${contextPath}/member/signUpterms">회원가입</a>
</nav>
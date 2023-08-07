<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="account">
    <c:choose>
        <c:when test="${!empty loginMember}">
            <a href="${contextPath}/logout">
                <label id="logout-button" class="account-label" for="account-cbox">
                    <img class="account-image" src="${contextPath}/resources/images/logout.png">
                    <p class="account-text">로그아웃</p>
                </label>
            </a>
            <a href="${contextPath}/myPage/myPage">
                <label id="mypage-button" class="account-label">
                    <img class="account-image" src="${contextPath}/resources/images/user.png">
                    <p class="account-text">${loginMember.memberName}</p>
                </label>
            </a>
        </c:when>
        <c:otherwise>
            <input id="account-cbox" type="checkbox">
            <label id="account-button" class="account-label" for="account-cbox">
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
    <div id="sub-nav">
        <a href="${contextPath}/column/columnList?type=3">매거진</a>
        <a href="${contextPath}/board/boardAll?type=1">커뮤니티</a>
        <a href="${contextPath}/cocktail/list">칵테일</a>
        <a href="${contextPath}/cocktailTest/cocktailTest">칵테일 테스트</a>
        <a href="${contextPath}/place">플레이스</a>
        <c:if test="${loginMember.managerCode == 'Y'}">
            <a href="${contextPath}/manager/manager?type=2">관리자 모드</a>
        </c:if>
    </div>
</header>
<nav>
    <a href="${contextPath}/column/columnList?type=3">매거진</a>
    <a href="${contextPath}/board/boardAll?type=1">커뮤니티</a>
    <a href="${contextPath}/cocktail/list">칵테일</a>
    <a href="${contextPath}/cocktailTest/cocktailTest">칵테일 테스트</a>
    <a href="${contextPath}/place">플레이스</a>
    <c:if test="${loginMember.managerCode == 'Y'}">
        <a href="${contextPath}/manager/manager?type=2">관리자 모드</a>
    </c:if>
</nav>

<div id="theme-switch">
    <img>
</div>

<input id="community-checkbox" type="checkbox">
<label for="community-checkbox">
    <div id="community-switch">
        <img src="${contextPath}/resources/images/chat.png">
    </div>
</label>
<div id="community">
    <div id="community-header">
        <h3>전체 채팅</h3>
    </div>
    <div id="community-message"></div>
    <div id="community-input">
        <input type="text">&nbsp;
        <button onclick="sendMessage('${loginMember.memberNo}')">전송</button>
    </div>
</div>

<input type="hidden" id="loginMemberNo" value="${loginMember.memberNo}">
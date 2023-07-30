<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>searchId</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/searchId.css">
</head>
<body>
    <h3>아이디 찾기</h>
    <div class="searchId-div" >
        <c:choose>
            <c:when test="${!empty member}">
                <div class="resultId">
                    <div class="found-success">
                        <span>${member.memberName}</span>님의 아이디는<br><br>
                        <span>${member.memberId}</span>입니다.
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="resultId">
                    <div class="found-fail">
                        <div>등록된 정보가 없습니다.</div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

        <div class="searchId2">
            <button id="searchPwBtn">비밀번호 찾기</button> 

            <button id="loginBtn">로그인 하기</button>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    
</body>
</html>
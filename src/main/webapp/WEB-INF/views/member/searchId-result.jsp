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
                <div class="cont">
                    <div class="found-success">
                        <div>${member.memberName}</div>님의 아이디는
                        <div>${member.memberEmail}</div>입니다.
                        
                    </div>
                </div>

            </c:when>

            <c:otherwise>
                <div class="cont">
                    <div class="found-fail">
                        <div>등록된 정보가 없습니다.</div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>



        <div class="searchId2-1">
     
            <button  id="btn">비밀번호 찾기</button> 
    
            <button  id="btn">로그인 하기</button>
        </div>



        
    </div>


   
    


   

   




    <script src="${contextPath}/resources/js/searchId.js"></script>
    
</body>
</html>
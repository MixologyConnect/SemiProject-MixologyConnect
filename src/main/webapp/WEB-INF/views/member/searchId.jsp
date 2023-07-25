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
    <div class="contSearchId">아이디 찾기</div>

    <div class="searchId1">
        <form action="searchId" method="get" name="searchId-form">
            <table >
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="inputName" id="inputName" placeholder="이름"></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="inputTel" id="inputTel" placeholder="전화번호(-미포함)"></td>
                </tr>
            </table>
                <button type="submit"  id="btn">다음</button> 

        </form>
             
   
    
        <div class="searchId2-1">
            <button type="button"  id="btn">비밀번호 찾기</button> 

            <button type="button" id="btn">로그인 하기</button>
        </div>


   

    </div>





    
</body>
</html>
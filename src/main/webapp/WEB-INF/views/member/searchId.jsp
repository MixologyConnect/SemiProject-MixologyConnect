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

    <div class="searchId1">
        <form action="searchId" method="post" id="searchId-form" name="searchId-form" onsubmit="return searchId()">
            <table >
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="memberName" id="inputName" placeholder="이름"></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="memberTel" id="inputTel" placeholder="전화번호(-미포함)"></td>
                </tr>
            </table>
                <button type="submit"  id="seachIdBtn">다음</button> 
            
        </form>

             
   
  
        <div class="searchId2">
 
            <button type="button"  id="searchPwBtn">비밀번호 찾기</button> 

            <button type="button" id="loginBtn">로그인 하기</button>
        </div>


   

    </div>


    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>


    <script src="${contextPath}/resources/js/searchId.js"></script>
    
</body>
</html>
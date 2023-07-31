<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>searchPw</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/searchPw.css">
</head>
<body>





    <div class="contSearchPw">비밀번호 찾기</div>

    <div class="searchPw1">
        <form action="#" method="#" name="searchPw-form">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="inputId" id="inputId" placeholder="아이디"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="inputName" id="inputName" placeholder="이름"></td>
                </tr>


            </table>
            <div class="searchPw2-1">
                <button type="submit"  id="btn">다음</button> 
            </div>
        </form>
    </div>

    

  
</body>
</html>
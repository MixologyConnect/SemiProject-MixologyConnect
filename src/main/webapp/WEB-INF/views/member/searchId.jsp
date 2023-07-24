<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>searchId</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/searchId.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="contSearchId">아이디 찾기</div>

    <div class="searchId1">
        <form action="#" method="get" name="searchId-form">
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

    <div id="mc-footer"></div>

    <script>
        $.ajax({
            url: 'https://gist.githubusercontent.com/abs013r/cb774124e29ab7e396b638939ec0bda1/raw/479c0716a7104236e2e4fdc089586b3aeef5831b/MCnav.html',
            type: 'GET',
            success: function(data) { $('#mc-nav').html(data); },
            error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
        });
        
        $.ajax({
            url: 'https://gist.githubusercontent.com/abs013r/0d6ff4139684cf842192a2d312266a83/raw/6e629f95c437670fc573560fd8559829a25b30c8/MCfooter.html',
            type: 'GET',
            success: function(data) { $('#mc-footer').html(data); },
            error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
        });
    </script>





    
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="boardName" value="${map.boardName}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="columnList" value="${map.columnList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칼럼 전체보기 창</title>

	<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/columnAll.css">
    
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    

</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <!-- 전체 브라우저 container -->
<div class="container">

    <!-- 컨텐츠 감싸는 container -->
    <div class="secon-container">
        <!-- 칵쓸신잡 배너-->
        <div id="banner">
            <!-- 칵쓸신잡 배너 사진 -->
            <a href="">
                <img src="https://i.ibb.co/9ZDf4Jk/logo.png" id="bannerPic">
            </a>
           
             <!-- 칵쓸신잡 배너 글 -->
             <div>
                 <p id="banner1" style="font-weight: bold;">칵쓸신잡에서</p>
                 <p id="banner2">칵테일에 대한 흥미로운 정보를 만나보세요</p>
             </div>
        </div>

        <!-- 배너랑 칼럼 사이 검색 창 -->
        <div id="searchArea">
            <!-- 검색 목록 선택 -->
            <select name="title" id="SearchOption">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="TC">제목 + 내용</option>
            </select>
            <!-- 검색 input -->
            <input type="text" name="" id="search" placeholder="원하는 정보를 입력하세요!">
            <!-- 검색 버튼 -->
            <button id="searchBtn">검색</button>
        </div>

             <!-- 컨텐츠 시작 -->
        <div class="list">
            <ul class="list-content">
                <div class="">
                    <ul>
                        <li>
                            <a href="">
                                <div>
                                    <img id="picture" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F990B86335A07F47B25" style="width: 100%;">
                                </div>
                                <div class="title">
                                    <p style="margin-top: 10px;"><h3>${columb.boardTitle}</h3></p><br>
                                    <p style="margin-bottom: 10px;">${column.member}</p>
                                </div>
                            </a>
                        </li>
               
                     
                    </ul>
                </div>
            </ul>
        </div>


        <ul class="pagination">
            <li><button id="pageCon1"><a href=""><</a></button></li>
            <li><button id="pageCon1"><a href="">1</a></button></li>
            <li><button id="pageCon1"><a href="">2</a></button></li>
            <li><button id="pageCon1"><a href="">3</a></button></li>
            <li><button id="pageCon1"><a href="">></a></button></li>
        </ul>
            
    </div>
    
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
<jsp:include page="/WEB-INF/views/common/modal.jsp"/>

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

    <script src="${contextPath}/resources/js/columnAll.js"></script>
</body>
</html>
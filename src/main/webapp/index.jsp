<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="boardName" value="${map.boardName}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="columnList" value="${map.columnList}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mixology Connect</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/index.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <main>
        <div id="banner">
            <p>
                THIS IS BANNER<br>
                THIS IS BANNER<br>
                THIS IS BANNER
            </p>
        </div>
        <div id="search">
            <label for="search-button"><img id="search-img" src="${contextPath}/resources/images/magnifier.png"></label>
            <form action="search" onsubmit="return searchValidate()">
        	    <input id="search-box" type="text" name="query" placeholder="칵테일, 게시글">
                <button id="search-button">검색</button>
            </form>
        </div>
        <div id="ad"></div>
        <div id="populars">
            <p>Columns</p>
            <p>최근 칼럼</p>
            <ul class="contents-column">
                <li><a>
                    <img src="${contextPath}/resources/images/column/20230808171838_60172.png">
                    <div>asdf</div>
                </a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
            </ul>
        </div>
        <div id="populars">
            <p>Trending</p>
            <p>실시간 인기 게시글</p>
            <ul class="contents">
                <li><a></a></li>
            	<li><a></a></li>
            	<li><a></a></li>
            	<li><a></a></li>
            </ul>
        </div>
    </main>
    <jsp:include page="/WEB-INF/views/manager/noticeModal.jsp"/>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/common/modal.jsp"/>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
</body>
</html>

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
                        <c:choose>
                            <c:when test="${empty map}">
                                <span><h4>게시글이 존재하지 않습니다.</h4></span>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="column" items="${columnList}">
                                    <li>
                                        <a href="">
                                            <div>
                                                <img id="picture" src="${contextPath}${column.thumbnail}" style="width: 100%;">
                                            </div>
                                            <div class="title">
                                                <p style="margin-top: 10px;"><h3>${column.boardTitle}</h3></p><br>
                                                <p style="margin-bottom: 10px;">${column.memberName}</p>
                                            </div>
                                        </a>
                                    </li>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>


            </ul>
        </div>
        <div class="btn-area">
            <c:if test = "${loginMember.managerCode=='Y'}">
            <button id="insertBtn" type = "button" onclick="location.href = 'columnWrite?mode=insert&type=${param.type}&cp=${param.cp}'">글쓰기</button>
        </c:if>
        </div>


        <ul class="pagination">
            <!-- /http://localhost:8080/SemiProject-MixologyConnect/column/columnList?type=3 -->
            <c:set var="url" value="columnList?type=${param.type}&cp="/>

            <!-- 첫페이지로 이동 -->
            <li><button id="pageCon1"><a href="${url}1">&lt;</a></button></li>
            
            <!-- 범위 정하기 -->
            <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">

                <c:choose>
                    <c:when test="${i == pagination.currentPage}">
                        <li><a class="current" id="pageCon1">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${url}${i}" id="pageCon1">${i}</a></li>
                    </c:otherwise>
                </c:choose>

            </c:forEach>



            <!-- 마지막 페이지로 이동 -->
            <li><button id="pageCon1"><a href="${url}${pagination.maxPage}">&gt;</a></button></li>
        </ul>
            
    </div>
    
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
<jsp:include page="/WEB-INF/views/common/modal.jsp"/>

    <script src="${contextPath}/resources/js/columnAll.js"></script>
</body>
</html>
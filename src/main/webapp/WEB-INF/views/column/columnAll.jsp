
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

    <c:if test="${!empty param.title}">
        <c:set var="sURL" value="&title=${param.title}&columnquery=${param.columnquery}"/>
    </c:if>

    <!-- 전체 브라우저 container -->
<div class="container">

    <!-- 컨텐츠 감싸는 container -->
    <div class="secon-container">
        <!-- 칵쓸신잡 배너-->
        <div id="banner">
            <!-- 칵쓸신잡 배너 사진 -->
            <a href="#">
                <img src="https://i.ibb.co/9ZDf4Jk/logo.png" id="bannerPic">
            </a>
           
             <!-- 칵쓸신잡 배너 글 -->
             <div>
                 <p id="banner1" style="font-weight: bold;">칵쓸신잡에서</p>
                 <p id="banner2">칵테일에 대한 흥미로운 정보를 만나보세요</p>
             </div>
        </div>

        <!-- 배너랑 칼럼 사이 검색 창 -->
        <form action="columnList" method="get" id="columnSearch" onsubmit="return searchValidate()">
        
            <div id="searchArea">
                <input type="hidden" name="type" value="${param.type}">
                <!-- 검색 목록 선택 -->
                <select name="title" id="SearchOption">
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                    <option value="TC">제목 + 내용</option>
                </select>
                <!-- 검색 input -->
                <input type="text" name="columnquery" id="search" placeholder="원하는 정보를 입력하세요!">
                <!-- 검색 버튼 -->
                <button id="searchBtn">검색</button>
            </div>
        </form>

             <!-- 컨텐츠 시작 -->
        <div class="list">
            <ul class="list-content">

                <c:if test="${!empty param.title}">
                    <h3>"${param.columnquery}" 검색결과</h3>
                </c:if>
                
                <div>
                    <ul>
                        <c:choose>
                            <c:when test="${empty columnList}">
                                <span><h4>게시글이 존재하지 않습니다.</h4></span>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="column" items="${columnList}">
                                    <li>
                                        <a href="columnDetail?no=${column.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">
                                            <div>
                                                <img id="picture" src="${contextPath}${column.thumbnail}" style="width: 100%;">
                                            </div>
                                            <div class="title">
                                                <p><h3>${column.boardTitle}</h3></p>
                                                <p>${column.memberName}</p>
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



        <div class="pagination-area">
            <c:set var="url" value="columnList?type=${param.type}&cp="/>

            <ul class="pagination">
                <!-- 첫 페이지로 이동 -->
                <li><a href="${url}1${sURL}">&lt;</a></li>

                <!-- 범위가 정해진 일반 for문 사용 -->
                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                    <c:choose>
                        <c:when test="${i == pagination.currentPage}">
                            <li><a class="current">${i}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${url}${i}${sURL}">${i}</a></li>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>

                <!-- 끝 페이지로 이동 -->
                <li><a href="${url}${pagination.maxPage}${sURL}">&gt;</a></li>
            </ul>
        </div>
            
    </div>
    
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
<jsp:include page="/WEB-INF/views/common/modal.jsp"/>

<<<<<<< HEAD
    <script src="${contextPath}/resources/js/columnAll.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
=======
<script src="${contextPath}/resources/js/columnAll.js"></script>
<script src="${contextPath}/resources/js/main.js"></script>
>>>>>>> e000f44396a9672c94f9eb7d348c48a9b7bff99a
</body>
</html>
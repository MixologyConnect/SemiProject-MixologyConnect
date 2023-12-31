<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
    
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="bookMarkList" value="${map.bookMarkList}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>북마크</title>

    <link href="https://fonts.cdnfonts.com/css/segoe-ui-4" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/bookMark.css">

    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
    
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

   

    
    <section class="board-list">
        <h1 class="board-name">북마크</h1>
        
        <div class="list-wrapper">
            <table class="list-table">
                <thead>
                    <tr>
                        <th><input type="checkbox" class="allCheck"></th>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>

                
                <tbody id="list">

                    <c:choose>
                        <c:when test="${empty bookMarkList}">
                            <tr>
                                <td colspan="5">게시글이 존재하지 않습니다.</td>
                            </tr>
                        </c:when>
                
                            <c:otherwise>
                
                                <c:forEach var="bk" items="${bookMarkList}">
                                    <tr>
                                        <td><input type="checkbox" name="deleteBox" class="delete" value="${bk.boardNo}"></td>
                                        <td>${bk.boardNo}</td>
                                        <td><a href="${contextPath}/board/boardDetail?no=${bk.boardNo}&cp=${pagination.currentPage}&type=1">${bk.boardTitle}</a></td>
                                        <td>${bk.memberName}</td>
                                        <td>${bk.boardDate}</td>
                                        <td>${bk.readCount}</td>
                                    </tr>
                
                                </c:forEach>
                
                            </c:otherwise>
                
                    </c:choose>

                   
                </tbody>

        




                
            </table>
            <div class="deleteBtn1-area">

                <button id="deleteBtn1" onclick="deleteClick()">삭제하기</button>
            </div>
        </div>


        <div class="pagination-area">
            <c:set var="url" value="bookMark?&cp="/>

            <ul class="pagination">
                <!-- 첫 페이지로 이동 -->
                <li><a href="${url}1">&lt;&lt;</a></li>
                <!-- 이전 목록 마지막 번호로 이동 -->
                <li><a href="${url}${pagination.prevPage}">&lt;</a></li>


                <!-- 범위가 정해진 일반 for문 사용 -->
                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                    <c:choose>
                        <c:when test="${i == pagination.currentPage}">
                            <li><a class="current">${i}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${url}${i}">${i}</a></li>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>

                <!-- 다음 목록 시작 번호로 이동 -->
                <li><a href="${url}${pagination.nextPage}">&gt;</a></li>

                <!-- 끝 페이지로 이동 -->
                <li><a href="${url}${pagination.maxPage}">&gt;&gt;</a></li>
            </ul>
        </div>

        

    </section>

    <form action="bookMark" method="get" id="boardSearch" onsubmit="return searchValidate()">
        
        <select name="key" id="search-key">
            <option value="t">제목</option>
            <option value="c">내용</option>
            <option value="tc">제목+내용</option>
            <option value="w">작성자</option>
        </select>

        <input type="text" name="query" id="search-query"  placeholder="검색어를 입력해주세요.">

        <button>검색</button>
    </form>

     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
     <jsp:include page="/WEB-INF/views/common/modal.jsp"/>

     <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

     <script>
        const contextPath = "${contextPath}"
        const loginMemberNo = "${loginMember.memberNo}";
     </script>

    <script src="${contextPath}/resources/js/bookMark.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    
</body>
</html>
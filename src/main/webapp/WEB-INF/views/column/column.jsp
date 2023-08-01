<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>컬럼 상세보기</title>

	<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/column.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>

   <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <!-- 전체 컨테이너 -->
    <div class="container">
        <!-- width 65%먹는 컨테이너 -->
        <div class="secon-container">
                    <!-- 칵쓸신잡 배너-->
            <div id="banner">
                <!-- 칵쓸신잡 배너 사진 -->
                <a href="columnAll.html">
                    <img src="https://i.ibb.co/9ZDf4Jk/logo.png" id="bannerPic">
                </a>
            
                <!-- 칵쓸신잡 배너 글 -->
                <div>
                    <p id="banner1" style="font-weight: bold;">칵쓸신잡에서</p>
                    <p id="banner2">칵테일에 대한 흥미로운 정보를 만나보세요</p>
                </div>
            </div>

            <!-- 컬럼 제목 -->
            <div class="title">
                ${detail.boardTitle}
            </div>

            <!-- 올린 시간, 조회수 -->
            <div class="time">
                <div>
                    <p>Mixology | ${detail.boardDate}</p>
                </div>
                <div>
                    조회수 ${detail.readCount}회
                </div>
            </div>

            <!-- 컬럼 헤드라인 -->
            <div class="head">
                
                <!-- ${columnImg.imageRename} -->
            </div>
            <!-- 사진 -->
            <div class="picture">
                <img src="${contextPath}${detail.imageList[0].imageRename}" id="colPic">
            </div>

            <!-- 글 타래 -->
            <div class="textCon">
                ${detail.boardContent}
                
            </div>
            <!-- <form> -->
         
                <div class="alterBtn">
                    <c:if test="${loginMember.managerCode == 'Y'}">
                        <c:if test="${empty param.cp}">
                            <c:set var="cp" value="1"></c:set>
                        </c:if>
                        
                        <c:if test="${!empty param.currentPage}">
                            <c:set var="cp" value="${param.cp}"></c:set>
                        </c:if>
                        <button id="updateBtn" type="button" onclick="location.href='columnWrite?mode=update&type=${param.type}&cp=${param.cp}&no=${detail.boardNo}'">수정</button>
                        <button id="deleteBtn" >삭제</button>
                    </c:if>
                    <button id="goToBtn" >목록으로</button>
                </div>
        
            <!-- </form> -->
                

            
        </div>
        
    </div>
    
   <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
   <jsp:include page="/WEB-INF/views/common/modal.jsp"/>

   <script src="${contextPath}/resources/js/column.js"></script>
</body>
</html>
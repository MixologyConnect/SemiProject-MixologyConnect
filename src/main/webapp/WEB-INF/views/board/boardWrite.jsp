<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/boardWrite.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" 
    integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    
</head>
<body style="overflow-x: hidden">
   <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div class="container">


        <!-- 게시글 입력 바디 -->
        <div class="content">
            <form action="boardWrite" method="post" enctype="multipart/form-data" onsubmit="writeValidate()">
            <div class="top"><p>게시글 입력</p></div>

            <!-- 커뮤니티 정책 가이드 -->
            <div class="guide">
                <div id="pre">
                    Mixology Connect는 스팸, 부적절한 콘텐츠, 신용사기, 잘못된 정보 등을 
                    등록하는 것을 절대 허용하지 않습니다. <a href="#">커뮤니티 정책</a>은 허용되거나 
                    허용되지 않는 활동을 규정하며 스팸이나 부적절하거나 폭력적인 콘텐츠의 신고 가이드를 제공합니다.
                </div>
            </div>
            <!-- 게시글 제목란 -->
            <div class="boardTitle">
                <input type="text" id="boardTitle" name="boardTitle" placeholder="제목을 입력해주세요(20자 이하)" value="${detail.boardTitle}" maxlength="20">
                <label for="image">
            </div>
            
           
            <c:forEach items ="${detail.imageList}" var = "boardImage">

            <c:choose>

            <c:when test = "${boardImage.imageLevel == 0}">
                <%-- c:set 변수는 page scope가 기본값(조건문이 끝나도 사용 가능) --%>
            <c:set var ="img0" value = "${contextPath}${boardImage.imageRename}"></c:set>
            </c:when>

            <c:when test = "${boardImage.imageLevel == 1}">
            <c:set var ="img1" value = "${contextPath}${boardImage.imageRename}"></c:set>
            </c:when>

            <c:when test = "${boardImage.imageLevel == 2}">
            <c:set var ="img2" value = "${contextPath}${boardImage.imageRename}"></c:set>
            </c:when>

            <c:when test = "${boardImage.imageLevel == 3}">
            <c:set var ="img3" value = "${contextPath}${boardImage.imageRename}"></c:set>
            </c:when>

            </c:choose>
            </c:forEach>

            <div class="img-box">

                <div class="boardImg">
                <label for = "img0">
                    <img class="preview" src="${img0}">
                </label>

                <input type="file" class="inputImage" id="img0" name = "0" accept="image/*">
                <span class="delete-image">&times;</span>
            </div>


            <div class="boardImg">
                <label for = "img1">
                    <img class="preview" src="${img1}">
                </label>

                <input type="file" class="inputImage" id="img1" name = "1" accept="image/*">
                <span class="delete-image">&times;</span>
            </div>

            <div class="boardImg">
                <label for = "img2" >
                    <img class="preview" src="${img2}">
                </label>

                <input type="file" class="inputImage" id="img2" name = "2" accept="image/*">
                <span class="delete-image">&times;</span>
            </div>

            <div class="boardImg">
                <label for = "img3">
                    <img class="preview" src="${img3}">
                </label>

                <input type="file" class="inputImage" id="img3" name = "3" accept="image/*">
                <span class="delete-image">&times;</span>
            </div>
        </div>




            <!-- 게시글 작성란 -->
            <div class="detail">
                <textarea name="boardContent" id="boardContent" style="resize: none;" maxlength="500">${detail.boardContent}</textarea>
                <p> <span id="counter">0</span>/500</p>
            </div>

            <!-- 작성완료 버튼 -->
            <div class="btn">
                <button type="submit" id="btn">작성 완료</button>
            </div>

            
            <input type="hidden" name = "mode" value = "${param.mode}">
            <input type="hidden" name = "type" value = "${param.type}">
            <input type="hidden" name = "no" value = "${param.no}">
            <input type="hidden" name = "cp" value = "${param.cp}">
    
            <input type="hidden" id="dlelteList" name = "deleteList" value = "">
        </form>

        </div>


       <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    </div>
    <script src="${contextPath}/resources/js/boardWrite.js"></script>
    
</body>
</html>
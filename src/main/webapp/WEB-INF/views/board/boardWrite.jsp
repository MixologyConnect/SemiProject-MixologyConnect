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
            <form action="boardWrite" method="post" enctype="multipart/form-data">
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
            <div class="title">
                <input type="text" id="title" name="title" placeholder="제목을 입력해주세요(20자 이하)" maxlength="20">
                <label for="image">
                    <div class="image">이미지 선택</div>
                  </label>
                  <input type="file" name="image" id="image">
    
            </div>
            
           

            <!-- 게시글 작성란 -->
            <div class="detail">
                <textarea id="detail" style="resize: none;" maxlength="500"></textarea>
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 공지사항관리</title>
    <link rel="stylesheet" href="../css/manager-manager.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <div id="main">

        <section class="left-side">
            <span>관리자페이지</span>

            <ul  class="list-group">
                <li><a href="#">회원관리</a></li>
                <li> <a href="#">회원 게시글 관리 </a></li>
                <li> <a href="#">칼럼 관리</a></li>
                <li> <a href="#">공지사항관리</a></li>
                <li> <a href="#">칵테일 관리</a></li>
             
            </ul>

        </section>
        
        <section class="manager-area">
                
            <div id="managerPost-area">
                <h3>칵테일 칼럼 작성</h3>
                <span>칵테일 칼럼을 작성하는 공간입니다.</span>
                
                <form action="noticeWrite" id="managerPost" method="post" enctype="multipart/form-data" onsubmit="return noticeImgValidate()">
                    
                    
                    <div class="cocktail-data">
                        <!-- 칵테일 칼럼 제목 input창 -->
                        <label>
                            <b>공지사항 제목</b>
                            <input name="noticeTitle" id="noticeTitle" placeholder="공지사항 제목" maxlength="50" required>
                        </label>
                        <br>
                        
                    </div>
                    
                    <div id="in_content">
                        
                        <textarea name="content" id="content" placeholder="내용" style="resize: none;" maxlength="500" required></textarea>
                    </div>
                    
                    <!-- 공지사항 이미지 -->
                    <div class="cock_write">
                        <img src="" id="notice-image">
                    </div>

                    <div class="bt_se">
                        <label for="input-image">이미지 선택</label>
                        <input type="file" name="SelectFile" id="input-image" accept="image/"/>

                        <button id="updateBtn" type="button" onclick = "location.href ='boardWrite?mode=update&type=${param.type}'">수정</button>
                        <button id="insertBtn" type = "button" onclick="location.href = 'boardWrite?mode=insert&type=${param.type}'">저장</button>
                    </div>

                    <input type="hidden" name="delete" id="delete" value="0">
                </form>
                </div>
                
            </div>
                
        </section>
       
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    <script src="${contextPath}/resources/js/notice.js"></script>
</body>
</html>
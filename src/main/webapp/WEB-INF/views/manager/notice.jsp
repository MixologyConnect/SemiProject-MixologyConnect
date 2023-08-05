<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 공지사항관리</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/manager.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <div id="main">

        <section class="left-side">
            <span>관리자페이지</span>

            <ul  class="list-group">
                <li><a href="${contextPath}/manager/manager?type=2">회원 및 게시글 관리</a></li>

                <li><a onclick = "location.href = 'noticeWrite?mode=update&type=${param.type}&cp=${param.cp}'">공지사항 수정</a></li>
                <!-- <li> <a href="${contextPath}/manager/noticeWrite?mode=updatet&type=2">공지사항 관리</a></li> -->
                <li> <a href="${contextPath}/manager/noticeWrite?mode=insert&type=2">공지사항 작성</a></li>
            </ul>


        </section>
        
        <section class="manager-area">
                
            <div id="managerPost-area">
                <h3>칵테일 칼럼 작성</h3>
                <span>칵테일 칼럼을 작성하는 공간입니다.</span>
                
                <form action="noticeWrite" id="managerPost" method="POST" enctype="multipart/form-data" onsubmit="return noticeImgValidate()">
                    
                    
                    <div class="cocktail-data">
                        <!-- 칵테일 칼럼 제목 input창 -->
                        <label>
                            <b>공지사항 제목</b>
                            <input name="noticeTitle" id="noticeTitle" placeholder="공지사항 제목" maxlength="50" value="${detail.boardTitle}" required>
                        </label>
                        <br>
                        
                    </div>
                    
                    <div id="in_content">

                        
                        <textarea name="content" id="content" placeholder="내용" style="resize: none;" maxlength="100" required>
                        ${detail.boardContent}
                        </textarea>
                    </div>
                    
                    <!-- 공지사항 이미지 -->
                    <div class="img-box">
                        <div class="boardImg thumbnail">
                            <label for="img0">
                                <img class="preview" src="${contextPath}${detail.imageList[0].imageRename}">
                            </label>
                            <input type="file" class="inputImage" id="img0" name="0" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>
                    </div>

                    <button type="button" onclick = "location.href = 'noticeWrite?mode=update&type=${param.type}&cp=${param.cp}'">수정 및 저장</button>

                    <button type="submit">등록</button>

                    <input type="hidden" name = "mode" value = "${param.mode}">
                    <input type="hidden" name = "type" value = "${param.type}">
                    <input type="hidden" name = "no" value = "${param.no}">
                    <input type="hidden" name = "cp" value = "${param.cp}">

                    <input type="hidden" id="deleteList" name="deleteList" value="">
                </form>
                </div>
                
            </div>
                
        </section>
       
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    <script src="${contextPath}/resources/js/notice.js"></script>
</body>
</html>
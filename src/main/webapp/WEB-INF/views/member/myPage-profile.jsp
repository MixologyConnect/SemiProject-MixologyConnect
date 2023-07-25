<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%--문자열 관렬 함수(메소드) 제공 JSTL (EL형식) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지 정보수정</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-info.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="main">
        <section class="left-side">
            <p>마이페이지 </p>
    
            <ul  class="list-group">
               
                <li> <a href="${contextPath}/member/myPage/profile">프로필 수정</a></li>
                <li> <a href="${contextPath}/member/myPage/info">내 정보 수정</a></li>
                <li> <a href="${contextPath}/member/myPage/secession">회원 탈퇴</a></li>
                
            </ul>
    
        </section>
        
        <section class="myInfo-area">
            <article>
                <h3>프로필</h3>
                <p>프로필 이미지를 변경할 수 있습니다.</p>
            </article>
            
            <form action="info" method="post" name="myPage-form" onsubmit="return myInfoValidate()">
                
                <div class="profile-image-area">
                    <img src="${contextPath}/resources/images/user.png" id="profile-image">
                </div>
                <div class="profile-btn-area">
                    <label for="input-image">이미지 선택</label>
                    <input type="file" name="profileImage" id="input-image">
                    <button type="submit">변경하기</button>
                </div>



                <div class="myPage-row">
                    <label>이메일</label>
                    <span>${loginMember.memberEmail}</span>
                </div>

                <div class="myPage-row">
                    <label>가입일</label>
                    <span>${loginMember.enrollDate}</span>
                </div>         
            
               
            
            </form>
            
        </section>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <!-- ----------------------------------------------------------------------------- -->
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	<!-- 다음 우편번호 api -->
    
    <script src="${contextPath}/resources/js/myPage-info.js"></script>
</body>
</html>
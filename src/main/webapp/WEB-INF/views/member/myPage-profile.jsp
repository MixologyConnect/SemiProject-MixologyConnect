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
            
            <form action="profile" method="post" name="myPage-form" 
                enctype="multipart/form-data" onsubmit="return profileValidate()">
                
                <div class="profile-image-area">
                    <c:if test="${empty loginMember.profileImage}">
                        <img src="${contextPath}/resources/images/user1.png" id="profile-image">
                    </c:if>
                    <c:if test="${!empty loginMember.profileImage}">
                        <img src="${contextPath}${loginMember.profileImage}" id="profile-image">
                        
                    </c:if>
                    
                    <!-- 프로필 이미지 삭제 버튼 -->
                    <span id="delete-image">x</span>

                </div>
                <div class="profile-btn-area">
                    <label for="input-image">이미지 선택</label>
                    <input type="file" name="profileImage" id="input-image" accept="image/*">
                    <button type="submit">변경하기</button>
                </div>

                <div class="myPage-row">
                    <label>아이디</label>
                    <span>${loginMember.memberId}</span>
                </div>


                <div class="myPage-row">
                    <label>이메일</label>
                    <span>${loginMember.memberEmail}</span>
                </div>

                    
            
                <!-- 삭제 버튼이 눌러짐을 기록하는 숨겨진 input태그 -->
                <!-- 0: 안눌러짐 / 1: 눌러짐 -->
                <input type="hidden" name="delete" id="delete" value="0">
            
            </form>
            
        </section>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/common/modal.jsp"/>
    <!-- ----------------------------------------------------------------------------- -->
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	<!-- 다음 우편번호 api -->
    <script>
        const contextPath ="${contextPath}"; //최상위 경로를 JS 전역 변수로 선언
    </script>
    <script src="${contextPath}/resources/js/myPage-info.js"></script>
</body>
</html>
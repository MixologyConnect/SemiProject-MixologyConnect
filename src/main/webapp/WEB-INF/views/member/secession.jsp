<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원탈퇴</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/secession.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-info.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    
   <!-- 전체 컨테이너 -->
    <div id="main">
        <section class="left-side">
            <p>마이페이지 </p>
    
            <ul  class="list-group">
               
                <li> <a href="${contextPath}/member/myPage/profile">프로필 수정</a></li>
                <li> <a href="${contextPath}/member/myPage/info">내 정보 수정</a></li>
                <li> <a href="${contextPath}/member/myPage/secession">회원 탈퇴</a></li>
                
            </ul>
    
        </section>
        <!-- width 65%먹는 컨테이너 -->
        <div class="secon-container">

            <section class="content">

                <h3 class="secessionH3">01.회원탈퇴 안내</h3>
    
                <!-- 탈퇴 약관 안내 -->
                <div class="terms">
                    Mixology 탈퇴안내 <br>
                    안녕하세요.
                    나가세요;
                </div>
    
                <form action="secession" method="POST" onsubmit="return secssionValidate()" id="secessionform">
                    <div style="float: right;">
                        <input type="checkbox" name="agree" id="agree">
                        <label for="agree">위 약관에 동의합니다.</label>
                    </div>
    
                    <br><br>
    
                    <h3 class="secessionH3">02. 회원탈퇴 하기</h3>
    
    
                        <!-- 회원탈퇴 하기 -->
                        <div class="memOut">
                            <!-- 비밀번호 -->
                        <div class="password">
                            <div class="passwordC"><b>비밀번호</b></div>
                            <!-- 비밀번호 input창 -->
                            <div id="passwordInput"><input type="password" id="memberPw" name="memberPw" style="height: 50%; width: 35%;" placeholder="비밀번호를 입력해주세요."></div>
                        </div>
                        
                        <!-- 탈퇴사유 -->
                        <div class="reason">
                            <div class="outReason"><b>탈퇴사유</b></div>
                            <!-- 탈퇴사유 checkbox -->
                            <div class="test">
                                
                                <label for="reasonNo"><input type="checkbox" name="reason" id="reasonNo" value="reasonNo"><b>없음</b></label>
                                
                                <label for="useLow"><input type="checkbox" name="reason" id="useLow" value="useLow"><b>사용빈도 낮음</b></label>
                            
                                <label for="contentLow"> <input type="checkbox" name="reason" id="contentLow" value="contentLow"><b>콘텐츠/정보부족</b></label>
                               
                                <label for="anything"><input type="checkbox" name="reason" id="anything" value="anything"><b>기타</b></label>
                            </div>
                        </div>
                        
                        <!-- 남기실 말씀 -->
                        <div style="height: 200px;">
                            <div class="outText"><b>남기실 말씀</b></div>
                            <!-- 말씀 input -->
                            <div><textarea style="width: 100%;"  placeholder="떠나시면서 소중한 의견을 남겨주세요."></textarea></div>
                        </div>
                    </div>
                    
                    <!-- 홈 화면 가기 button -->
                    <div class="back">
                        <a href="">
                            <button id="out">탈퇴(진짜로..?ㅠ)</button>
                        </a>
                    </div>
                </form>
            </section>
            <!-- <div class="back">
                <a href="">
                    <button id="home">홈 화면으로 가기</button>
                </a>
            </div> -->

        </div>
        
    </div>
    
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/common/modal.jsp"/>

   
    <script src="${contextPath}/resources/js/member/secession.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script> 
    
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원탈퇴</title>
    <link rel="stylesheet" href="../css/secession.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>

    <nav id="mc-nav"></nav>

    <!-- 전체 컨테이너 -->
    <div class="container">
        <!-- width 65%먹는 컨테이너 -->
        <div class="secon-container">
            <center><b>회원탈퇴</b></center>
            <br>
            <hr>
            <br>

            <h3>01.회원탈퇴 안내</h3>

            <!-- 탈퇴 약관 안내 -->
            <div class="terms">
                Mixology 탈퇴안내 <br>
                안녕하세요.
                나가세요;
            </div>

            <br><br>

            <h3>02. 회원탈퇴 하기</h3>

            <form action="">

                <!-- 회원탈퇴 하기 -->
                <div class="memOut">
                    <!-- 비밀번호 -->
                <div class="password">
                    <div class="passwordC"><b>비밀번호</b></div>
                    <!-- 비밀번호 input창 -->
                    <div id="passwordInput"><input type="password" style="height: 50%; width: 35%;" placeholder="비밀번호를 입력해주세요."></div>
                </div>
                
                <!-- 탈퇴사유 -->
                <div class="reason">
                    <div class="outReason"><b>탈퇴사유</b></div>
                    <!-- 탈퇴사유 checkbox -->
                    <div class="test">
                        <input type="checkbox" name="reason" id="reasonNo" value="reasonNo">
                        <label for="reasonNo"><b>없음</b></label>
                        <input type="checkbox" name="reason" id="useLow" value="useLow">
                        <label for="useLow"><b>사용빈도 낮음</b></label>
                        <input type="checkbox" name="reason" id="contentLow" value="contentLow">
                        <label for="contentLow"><b>콘텐츠/정보부족</b></label>
                        <input type="checkbox" name="reason" id="anything" value="anything">
                        <label for="anything"><b>기타</b></label>
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
                    <button id="home">홈 화면으로 가기</button>
                </a>
                <a href="">
                    <button id="out">탈퇴(진짜로..?ㅠ)</button>
                </a>
            </div>
            </form>

        </div>
        
    </div>
    
    <div id="mc-footer"></div>

    <script>
        $.ajax({
            url: 'https://gist.githubusercontent.com/abs013r/cb774124e29ab7e396b638939ec0bda1/raw/479c0716a7104236e2e4fdc089586b3aeef5831b/MCnav.html',
            type: 'GET',
            success: function(data) { $('#mc-nav').html(data); },
            error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
        });
        
        $.ajax({
            url: 'https://gist.githubusercontent.com/abs013r/0d6ff4139684cf842192a2d312266a83/raw/6e629f95c437670fc573560fd8559829a25b30c8/MCfooter.html',
            type: 'GET',
            success: function(data) { $('#mc-footer').html(data); },
            error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
        });
    </script>
    
    
</body>
</html>
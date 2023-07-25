<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                [파격특가] 세계적 브랜드 로얄샬루트 98% 할인?!
            </div>

            <!-- 올린 시간, 조회수 -->
            <div class="time">
                <div>
                    <p>Mixology | 2023.07.10 17:44</p>
                </div>
                <div>
                    조회수 132회
                </div>
            </div>

            <!-- 컬럼 헤드라인 -->
            <div class="head">
                <h1>칵테일에 이런일이?</h1>
            </div>
            
            <!-- 사진 -->
            <div class="picture">
                <img src="/report/images/test.png" id="colPic">
            </div>

            <!-- 글 타래 -->
            <div class="textCon">
                    <p>
                        💘2023 서울바앤스피릿쇼 예약 바로가기💘
                    </p>
                    
                    <p>
                        네이버 예약 - 서울바앤스피릿쇼 2023 (naver.com) 
                    </p>
                    <br>
                        
                    <p>
                        <2023 서울바앤스피릿쇼(이하 바앤쇼)>가 7월 28일부터 30일까지 서울 코엑스 D홀에서 열립니다. 
                    </p>
                  
                    <p>
                        올해 바앤쇼에는 전시회장을 더욱 풍성하게 할 프로그램도 다수 준비되어 있다고 해요. 
                    </p>

                    <p>
                        특히 국내 최상급 바 30여곳의 시그니처 칵테일🍸을 각 부스에서 맛볼 수 있는 '인피니티 바', 
                    </p>

                    <p>
                        최정상 바텐더들의 경연 대회인 <span>'월드 칵테일 배틀'</span>🤴은 절대 빼놓지 말고 즐겨야 할 주요 콘텐츠예요. 
                    </p>
                    <p>
                        이외에도 '스마트 오더 파빌리온'에서 백술닷컴 등 주류에 대한 접근성과 편의성을 높이는 
                    </p>
                    <p>
                        다양한 브랜드의 면면도 살펴볼 수 있으니, 이번 행사도 절대 놓쳐서는 안 되겠지요?
                    </p>
                    <p>
                        바앤쇼에서 '백술닷컴'을 찾아보세요😎 깜짝 이벤트가 기다리고 있습니다!
                    </p>
                
                    <center>
                        <a href="columnAll.html">
                             <button id="list">
                                목록
                            </button>
                        </a>
                    </center>
            </div>


            
        </div>
        
    </div>
    
   <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

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
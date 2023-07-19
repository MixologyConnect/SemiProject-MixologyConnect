<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칵테일 추천</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/cocktailTest.css">
    <link href="https://fonts.cdnfonts.com/css/segoe-ui-4" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>


    <section class="banner">
        <img src="../img/칵테일.png" alt=""><p>칵테일취향 테스트</p> <img src="../img/칵테일2.png">
    </section>
    
    <main>

        <div class="text">
            <pre>
                술자리 유형으로 알아보는 칵테일 추천!!

                    나에게 맞는 칵테일을 찾아보세요.
            </pre>

            <br>

            <img src="${contextPath}/resources/images/술자리 이미지.jpeg">

            <br><br>

            <button id="btn">칵테일 취향 테스트 시작하기!</button>
            
        </div>

       

        <div class="q1">

            <input type="range" min="0" max="60" step="10" value="10" class="range"><br>
            <button class="back"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">1/6</span>

            <div class="content">
                <div class="question">Q.1</div>
                <div>술 약속이 잡혔다! 내가 원하는 모임장소는?</div>
                <div><button class="q1-btn">독특한 컨셉으로 유명한 핫플</button></div>
                <div><button class="q1-btn">분위기 최고! 감성적인 LP바</button></div>
                <div><button class="q1-btn">사람 많고 음악 뿜뿜 신나는 곳</button></div>
                <div><button class="q1-btn">편하게 마실 수 있는 집 근처</button></div>
            </div>
        </div>

        <div class="q2">
            <input type="range" min="0" max="60" step="10" value="20" class="range"><br>
            <button class="back"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">2/6</span>

            <div class="content">
                <div class="question">Q.2</div>
                <div>모임 장소 도착! 안주는 뭐먹지?</div>
                <div><button class="q2-btn">귀찮은데 기본 과자 안주나 먹자!</button></div>
                <div><button class="q2-btn">달콤상콤한 과일안주가 좋지~</button></div>
                <div><button class="q2-btn">술 안주는 바삭바삭한 튀김이지!</button></div>
                <div><button class="q2-btn">든든한 식사 메뉴로 반주!</button></div>
            </div>
        </div>

        <div class="q3">
            <input type="range" min="0" max="60" step="10" value="30" class="range"><br>
            <button class="back"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">3/6</span>

            <div class="content">
                <div class="question">Q.3</div>
                <div>나의 가장 favourite 폭탄주는?</div>
                <div><button class="q3-btn">클래식이 최고! 소맥이지</button></div>
                <div><button class="q3-btn">술에는 탄산음료지! 고진감래주</button></div>
                <div><button class="q3-btn">새콤달콤 복분자주!</button></div>
                <div><button class="q3-btn">달달하고 부드러운 메로나주!</button></div>
            </div>
        </div>

        <div class="q4">
            <input type="range" min="0" max="60" step="10" value="40" class="range"><br>
            <button class="back"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">4/6</span>

            <div class="content">
                <div class="question">Q.4</div>
                <div>술을 꽤 많이마셨다.. 지금 상태는?</div>
                <div><button class="q4-btn">기분 업 될만큼 살짝 알딸딸!</button></div>
                <div><button class="q4-btn">이제부터 쉬어가면서 조금씩 마셔야지!</button></div>
                <div><button class="q4-btn">술집이 내 집인거마냥 꿈나라행..zzz</button></div>
                <div><button class="q4-btn">했던 얘기 계속 하기..</button></div>
            </div>
        </div>

        <div class="q5">
            <input type="range" min="0" max="60" step="10" value="50" class="range"><br>
            <button class="back"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">5/6</span>

            <div class="content">
                <div class="question">Q.5</div>
                <div>술자리중.. 당신의 타입은?</div>
                <div><button class="q5-btn">밤새 마시고 첫차 탐</button></div>
                <div><button class="q5-btn">마셔 마셔 더 마셔! 주체못함</button></div>
                <div><button class="q5-btn">중간에 아무도 모르게 탈주</button></div>
                <div><button class="q5-btn">안주 털이범...</button></div>
            </div>
        </div>

        <div class="q6">
            <input type="range" min="0" max="60" step="10" value="60" class="range"><br>
            <button class="back"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">6/6</span>

            <div class="content">
                <div class="question">Q.6</div>
                <div>술 마신 다음날..당신의 해장 원픽은?</div>
                <div><button class="q6-btn" id="one">해장은 기름기진거로 해야지! 햄버거</button></div>
                <div><button class="q6-btn" id="two">해장은 얼큰하고 맵게! 국밥</button></div>
                <div><button class="q6-btn" id="three">속이 다 풀리는 시원한 국물! 냉면</button></div>
                <div><button class="q6-btn" id="four">최고의 숙취해소제는..잠 zzz</button></div>
            </div>
        </div>

        <div class="loading-page">

            <div class="loading">
                <div>결과 분석중..</div>
                <div><img src="${contextPath}/resources/images/로딩.gif"></div>

            </div>

        </div>

        <div class="result">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/갓파더.webp"></div>
                <div>갓 파더</div>
                <div>진한 위스키와 달콤한 향, 달짝지근한 끝맛을 좋아하는 분들에게 추천! <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        <div class="result-two">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/맨해튼(칵테일).jpg"></div>
                <div>맨해튼</div>
                <div>위스키 베이스로, 칵테일의 여왕이라는 별칭을 가지고 있는 칵테일이다. 스위트 베르무트가 들어가 달콤한 맛을 지니고 있다.<br><br>
                    약 30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result-three">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/모히토.jpg"></div>
                <div>모히토</div>
                <div>쿠바의 전통 음료, 달달함과 동시에 민트 향을 내면서 씁쓸한 뒷맛이 스쳐가니 나름 입체적인 맛이라 할 수 있다.<br><br>
                    약 10-20도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        <div class="result-four">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/코스모폴리탄.jpg"></div>
                <div>코스모폴리탄</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        

        

        

        
        
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="${contextPath}/resources/js/cocktailTest.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
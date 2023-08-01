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
        <img src="${contextPath}/resources/images/칵테일.png" alt=""><p>칵테일취향 테스트</p> <img src="${contextPath}/resources/images/칵테일2.png">
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

       
        <!-- 첫번째 공통질문 -->
        <div class="q1">

            <div class="slide">
                <input type="range" min="0" max="30" step="10" value="10" class="range">
            </div>
            <div class="btn">
                <button class="back-re"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">1/3</span>
            </div> 
            <div class="content">
                <div class="question">Q.1</div>
                <div>술자리에서 즐겨마시는 술은?</div>
            </div>
            <div class="choice">
                <div><button class="soju-btn">소주</button></div>
                <div><button class="beer-btn">맥주</button></div>
                <div><button class="non-btn">이슬톡톡</button></div>
                
            </div>
        </div>

        <!-- 소주 관련 질문 -->
        <div class="q1-soju">
    
            <div class="q1-2">

                <div class="slide">
                    <input type="range" min="0" max="30" step="10" value="20" class="range">
                </div>
                <div class="btn">
                    <button class="back"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">2/3</span>
                </div> 
                <div class="content">
                    <div class="question">Q.2</div>
                    <div>나의 주량은?</div>
                </div>
                <div class="choice">
                    <div><button class="q2-btn">소주 1병 이하,,</button></div>
                    <div><button class="q2-btn">소주 2병까지는 가능~</button></div>
                    <div><button class="q2-btn">소주 3병 이상 ㄷㄷ</button></div>
                    
                </div>
            </div>
            <div class="q1-3">
    
                <div class="slide">
                    <input type="range" min="0" max="30" step="10" value="30" class="range">
                </div>
                <div class="btn">
                    <button class="back-3"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">3/3</span>
                </div> 
                <div class="content">
                    <div class="question">Q.3</div>
                    <div>새콤달콤 달달한 칵테일? VS 청량한 탄산감있는 칵테일?</div>
                </div>
                <div class="choice">
                    <div><button class="q3-sojusweet-btn">달달</button></div>
                    <div><button class="q3-sojucoke-btn">청량</button></div>
                    
                </div>
            </div>



        </div>
        
       <!-- --------------------------------------------------------------------------------------------- --> 
        
        <!-- 맥주 관련 질문 -->
        <div class="q2-beer">

            <div class="q2-2">

                <div class="slide">
                    <input type="range" min="0" max="30" step="10" value="20" class="range">
                </div>
                <div class="btn">
                    <button class="back-beer"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">2/3</span>
                </div> 
                <div class="content">
                    <div class="question">Q.2</div>
                    <div>나의 주량은?</div>
                </div>
                <div class="choice">
                    <div><button class="q2-1-btn">생맥 500기준 3잔이하</button></div>
                    <div><button class="q2-1-btn">3잔은 거뜬</button></div>
                    <div><button class="q2-1-btn">맥주먹고 취한적 없음</button></div>
                    
                </div>
            </div>
            <div class="q2-3">
    
                <div class="slide">
                    <input type="range" min="0" max="30" step="10" value="30" class="range">
                </div>
                <div class="btn">
                    <button class="back-3"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">3/3</span>
                </div> 
                <div class="content">
                    <div class="question">Q.3</div>
                    <div>좋아하는 맥주 종류는?</div>
                </div>
                <div class="choice">
                    <div><button class="q3-1-btn">흑맥주</button></div>
                    <div><button class="q3-2-btn">라거</button></div>
                    
                </div>
            </div>

        </div>

        <!-- ------------------------------------------------------------------------------------- -->

        <!-- 이슬톡톡 관련 질문 -->

        <div class="q3-non">

            <div class="q3-2">

                <div class="slide">
                    <input type="range" min="0" max="30" step="10" value="20" class="range">
                </div>
                <div class="btn">
                    <button class="back-beer"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">2/3</span>
                </div> 
                <div class="content">
                    <div class="question">Q.2</div>
                    <div>나의 주량은?</div>
                </div>
                <div class="choice">
                    <div><button class="q3-q-btn">이슽톡톡 1캔</button></div>
                    <div><button class="q3-q-btn">이슬톡톡 먹고 취하지는 않음!</button></div>
                    <div><button class="q3-q-btn">소주 반병은 가능</button></div>
                    
                </div>
            </div>
            <div class="q3-3">
    
                <div class="slide">
                    <input type="range" min="0" max="30" step="10" value="30" class="range">
                </div>
                <div class="btn">
                    <button class="back-3"><i class="fa-solid fa-play fa-rotate-180"></i></button> <span class="num">3/3</span>
                </div> 
                <div class="content">
                    <div class="question">Q.3</div>
                    <div>새콤달콤 달달한 칵테일? VS 청량한 탄산감있는 칵테일?</div>
                </div>
                <div class="choice">
                    <div><button class="q3-3-1-btn">달달</button></div>
                    <div><button class="q3-3-2-btn">청량</button></div>
                    
                </div>
            </div>

        </div>

        <!-- ------------------------------------ 로딩화면--------------------------------------- -->

        

        

        <div class="loading-page">

            
            <div id="loading-word">결과 분석중..</div>
            <div class="loading">
                <span></span>
                <span></span>
                <span></span>
            </div>

        

    </div>



        <!-- ------------------------------------- 칵테일 결과(18가지) --------------------------------------------------- -->
        <!-- result 1~3 : 소주-달달(파우스트, 블랙러시안, 롱아일랜드 아이스티)
            

             
            

             
             
        -->

        <div class="result1">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/갓파더.png"></div>
                <div>파우스트</div>
                <div>진한 위스키와 달콤한 향, 달짝지근한 끝맛을 좋아하는 분들에게 추천! <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        <div class="result2">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/블랙러시안.png"></div>
                <div>블랙러시안</div>
                <div>위스키 베이스로, 칵테일의 여왕이라는 별칭을 가지고 있는 칵테일이다. 스위트 베르무트가 들어가 달콤한 맛을 지니고 있다.<br><br>
                    약 30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result3">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/롱아일랜드 아이스티.png"></div>
                <div>롱아일랜드 아이스티</div>
                <div>쿠바의 전통 음료, 달달함과 동시에 민트 향을 내면서 씁쓸한 뒷맛이 스쳐가니 나름 입체적인 맛이라 할 수 있다.<br><br>
                    약 10-20도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
		
		<!--  result 4~6 : 소주-술맛(갓파더, 사제락, 카타르시스) -->
        <div class="result4">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/갓파더.png"></div>
                <div>갓파더</div>
                <div> 실제로 영화 '대부'를 기념하여 만들어진 칵테일이라고 한다. '갓파더'는 강렬한 위스키의 첫맛에 달달하고 향긋한 아마레또의 향으로 마무리된다. 알콜 도수는 30도 중반대로 높은 편이다.  <br><br>
                    약 30-40도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result5">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/사제락.png"></div>
                <div>사제락</div>
                <div>미국 역사상 가장 오래된 칵테일로 일컬어지는 사제락(Sazerac). 상큼한 레몬 풍미와 상쾌한 허브, 향긋한 아니스, 부드러운 질감과 은은한 단맛이 환상적인 밸런스를 이룬다.  <br><br>
                    약 40-45도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        <div class="result6">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/카타르시스.png"></div>
                <div>카타르시스</div>
                <div>카타르시스는 오버루프 럼, 아마레또, 라임 주스를 빌드해서 만드는 칵테일로, 재료도 간단하고 만드는 방법도 간단해서 쉽게 만들어 마실 수 있는 칵테일입니다! 하지만 오버루프럼이 들어가는 만큼 도수도 높다는 점!<br><br>
                    약 50-55도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <!-- result 7~9 : 맥주-흑맥주(블랙 벨벳, 더티호, 행맨스 블러드) -->
        <div class="result7">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/블랙벨벳.png"></div>
                <div>블랙 벨벳</div>
                <div>블랙 벨벳은 발포성 포도주 또는 스타우트(주로 기네스)를 기반으로 하는 맥주 칵테일이다. 샴페인의 고급스러운 청량감과 단맛이 먼저 느껴지고, 이후 스타우트 흑맥주의 쌉싸름한 맛이 뒷맛으로 남는 정말 고급스러운 칵테일!  <br><br>
                    약 10도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        <div class="result8">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/더티호.png"></div>
                <div>더티호</div>
                <div>아일랜드산 흑맥주인 기네스와 벨기에산 맥주인 호가든 이 두가지 맥주를 1:1로 섞어서 층을 만드는 맥주 플로팅 칵테일의 일종이다. 여담으로 각각의 맥주는 호가든 4.9도, 기네스 4.4도로 높진 않지만, 두 잔 정도 더티호로 만들어 먹으면 꽤나 빨리 취기가 올라온다. 이 점 유념하고 마시자. <br><br>
                    약 5도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        <div class="result9">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/행맨스블러드.png"></div>
                <div>행맨스 블러드</div>
                <div>브랜디의 맛과 흑맥주의 맛이 강하게 나는 칵테일. 진, 럼, 위스키, 브랜디, 와인, 흑맥주 등 거의 모든 양주를 다 베이스로 하는 칵테일로, 그 기원은 영국이라고 한다. <br><br>
                    약 10-20도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <!--  result 10~12 : 맥주-라거(레드아이, 샌디 개프, 소맥) -->
        <div class="result10">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/레드아이.png"></div>
                <div>레드아이</div>
                <div>맥주와 토마토 주스를 이용한 칵테일. 토마토 주스 맛이 나지만 맥주를 베이스로 한다. 도수는 3도 정도. 숙취해소용 칵테일이며 여성, 남성 가릴 것 없이 숙취해소용으로 가볍게 마시면 좋다. <br><br>
                    약 3도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        <div class="result11">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/샌디개프.png"></div>
                <div>샌디 개프</div>
                <div>맥주 베이스로, 맥주와 진저에일을 절반씩 섞어 만드는 칵테일이다. 맛은 진저에일의 생강 향, 약간의 단 맛과 맥주의 씁쓸한 맛이 조화를 이룬다. 이탈리아로부터 역사가 아주 긴 칵테일이라 전해진다.  <br><br>
                    약 5도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        
        <div class="result12">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/소맥.png"></div>
                <div>소맥</div>
                <div>소주와 맥주를 섞은 칵테일의 일종. 대한민국 성인이라면 안먹어 본 사람은 있어도 한번만 먹어본 사람은 없다는 우리나라 대표 칵테일! <br><br>
                    약 10-20도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>


		<!-- result 13~15 : 이슬 달달(피치크러쉬, 준벅, 미도리 사워) -->
        <div class="result13">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/피치크러쉬.png"></div>
                <div>피치크러쉬</div>
                <div>복숭아 향과 맛이 느껴지는 피치 리큐르에 크랜베리 주스를 섞어 만든 칵테일로 복숭아와 크렌베리의 새콤한 향과 맛의 어우러짐을 특징으로 가지고 있는 칵테일! <br><br>
                    약 5도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result14">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/준벅.png"></div>
                <div>준벅</div>
                <div>6월의 푸르름을 표현한 칵테일. 향과 맛이 달콤하기로 유명한 리큐르인 말리부가 들어가서 달달한 맛을 보여주는 칵테일!  <br><br>
                    약 5-10도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result15">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/미도리사워.png"></div>
                <div>미도리 사워</div>
                <div>멜론 리큐르의 한 종류인 미도리를 사용해 만드는 유명한 칵테일이다. 멜론맛인 미도리와 스윗&사워 믹스의 레몬향이 어우러져서 상큼한 색깔과 맛을 연출하는 것이 포인트. <br><br>
                    약 5-10도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        
        <!-- result 16~18 : 이슬 청량(모히토, 팔로마, 산토리 하이볼) -->
        <div class="result16">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/모히토.png"></div>
                <div>모히토</div>
                <div>럼 베이스 칵테일. 맛은 달달함과 동시에 민트 향을 내면서 씁쓸한 뒷맛이 스쳐가니 나름 입체적인 맛이라 할 수 있다.<br><br>
                    약 10-20도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result17">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/팔로마.png"></div>
                <div>팔로마</div>
                <div>데킬라 베이스로 하며, 높은 청량감과 가벼운 알코올 도수 덕분에 더운 여름에 마시기 적합한 음료라고 할 수 있습니다.<br><br>
                    약 10-20도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result18">
            <div class="cocktail">
                <div><img src="${contextPath}/resources/images/cocktailTest/산토리하이볼.png"></div>
                <div>산토리 하이볼</div>
                <div>산토리 하이볼은 일식 이자카야에서도 흔히 찾을 수  있는 유명한 칵테일이죠. 상큼하고 달달한 맛으로 인기를 끌고있는 일본의 산토리 위스키! <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        

        

        

        
        
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/common/modal.jsp"/>

    <script src="${contextPath}/resources/js/cocktailTest.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
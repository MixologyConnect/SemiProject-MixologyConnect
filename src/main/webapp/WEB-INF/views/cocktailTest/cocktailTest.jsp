<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칵테일 추천</title>

    <link rel="stylesheet" href="../css/취향테스트.css">
    <link href="https://fonts.cdnfonts.com/css/segoe-ui-4" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
    <script src="../js/jquery-3.7.0.min.js"></script>

</head>
<body>

    <header>

    </header>

    <nav id="mc-nav"></nav>


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

            <img src="../img/술자리 이미지.jpeg">

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
                <div>좋아하는 술은?</div>
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
                    <div>달달한거 청량한거</div>
                </div>
                <div class="choice">
                    <div><button class="q3-1-btn">달달</button></div>
                    <div><button class="q3-2-btn">청량</button></div>
                    
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
                    <div>달달한거 청량한거</div>
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
                <div><img style="width: 300px;" src="../img/갓파더.webp"></div>
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
                <div><img style="width: 300px;" src="../img/맨해튼(칵테일).jpg"></div>
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
                <div><img style="width: 300px;" src="../img/모히토.jpg"></div>
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
                <div><img style="width: 300px;" src="../img/코스모폴리탄.jpg"></div>
                <div>갓파더</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        <div class="result5">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/예거밤.webp"></div>
                <div>사제락</div>
                <div>폭발적인 에너지를 느낄 수 있는 예거밤, 파티나 클럽에서 텐션 높이는데 딱 좋은 칵테일이죠! 에너지 드링크의 카페인과 리큐르의 알코올이 만나 입은 행복하지만 위장이 박살나는 무시무시한 칵테일이기도 합니다 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        <div class="result6">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/김렛.webp"></div>
                <div>카타르시스</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <!-- result 7~9 : 맥주-흑맥주(블랙 벨벳, 더티호, 행맨스 블러드) -->
        <div class="result7">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/다이키리.webp"></div>
                <div>블랙 벨벳</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        <div class="result8">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/말리부 밀크.webp"></div>
                <div>더티호</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        <div class="result9">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/아디오스 마더퍼커.webp"></div>
                <div>행맨스 블러드</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <!--  result 10~12 : 맥주-라거(레드아이, 샌디 개프, 소맥) -->
        <div class="result10">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>레드아이</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        <div class="result11">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>샌디 개프</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        
        <div class="result12">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>소맥</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>


		<!-- result 13~15 : 이슬 달달(피치크러쉬, 준벅, 미도리 사워) -->
        <div class="result13">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>피치크러쉬</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result14">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>준벅</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result15">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>미도리 사워</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        
        <!-- result 16~18 : 이슬 청량(모히토, 팔로마, 산토리 하이볼) -->
        <div class="result16">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>모히토</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result17">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>팔로마</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>
        
        <div class="result18">
            <div class="cocktail">
                <div><img style="width: 300px;" src="../img/블루하와이안.webp"></div>
                <div>산토리 하이볼</div>
                <div>매혹적인 색깔로 유명한 칵테일, 새콤함에 숨겨진 독한 맛 <br><br>
                    약 20-30도
                </div>


            </div> <br>
            <div class="reset">

                <button>테스트 다시하기</button>
            </div>
        </div>

        

        

        
        
    </main>

    <div id="mc-footer"></div>

    <script src="../js/취향테스트.js"></script>
    
</body>
</html>
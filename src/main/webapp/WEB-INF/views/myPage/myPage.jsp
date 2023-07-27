<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>다른사용자 게시글 모아보기</title>
        
        <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
        <link rel="stylesheet" href="${contextPath}/resources/css/myPage.css">
        <link href="https://fonts.cdnfonts.com/css/segoe-ui-4" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
    	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <main>

        <section class="follow">
            <section class="img">
                <div><img src="${contextPath}/resources/images/user.png"></div>
                
            <input type="file" id="chooseFile"accept="image/*"></div>
            </section>
            <section class="follow2">
                <div id="top">@chosungjin</div>
                <div class="bottom">
                    <span><a href="#">팔로워 8</a></span>
                    <span><a href="#">팔로잉 3</a></span>
                </div>
            </section>
        </section>
        <section id="list">
           <!-- <span><a href="#">작성글</a></span>  
           <span><a href="#">저장한 게시글</a></span>  
           <span><a href="#">알림</a></span>  
           <span id="alarm"><a href="#">글쓰기</a></span>   -->
           <p class="thead"><a href="#">작성글</a></p>  
           <p><a href="${contextPath}/myPage/bookMark">북마크</a></p>  
           <p>
            <li id="myAlarm">
            <a href="#">알림 <i class="fa-solid fa-bell"></i></a>
                <div class="sub-wrap">
                    <div><a href=""><i class="fa-solid fa-bell"></i> 답글이 달렸습니다.</a></div>
                    <div><i class="fa-solid fa-bell"></i> <a href="">@khacademy</a>님의 팔로우 신청 : <button>수락</button> <button>거부</button></div>
                </div>
        </li></p>  
           <p id="alarm"><a href="#">글쓰기 <i class="fa-solid fa-pen-to-square"></i></a></p>  
        </section> 



        <section class="fir">
            <div class="left">
                <div><input type="checkbox" name="feed"><a href="#">게시글 제목</a></div>
                <div>삼겹살 짜장면 김치찌개 소고기 돼지고기 닭발 토마토 파스타 까르보나라 족발 보쌈 오리고기 소맥 참이슬 
                    삼겹살 짜장면 김치찌개 소고기 돼지고기 닭발 토마토 파스타 까르보나라 족발 보쌈 오리고기 소맥 참이슬</div>
                <div>
                <span>@khacademy</span>
                <span>2023.07.05</span>
                <span>조회수 111</span>
                <span>댓글수 5</span>
                </div>
            </div>
            <div><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA2MDVfMjMw%2FMDAxNjg1OTc0MTQ3NDU0.WnCvTZeQNkQ4X0TFe78tSCTbTB3r8NKmTyNITw0Ctfog.B_vuAbe-oIH6AJw0b6coC3X7niIdfeFsfp0LEtlyVDsg.JPEG.ls2924%2FIMG_0536.jpg&type=sc960_832"></div>
                
            
        </section>

        <section class="fir">
            <div class="left">
                <div><input type="checkbox" name="feed"><a href="#">게시글 제목</a></div>
                <div>삼겹살 짜장면 김치찌개 소고기 돼지고기 닭발 토마토 파스타 까르보나라 족발 보쌈 오리고기 소맥 참이슬 
                    삼겹살 짜장면 김치찌개 소고기 돼지고기 닭발 토마토 파스타 까르보나라 족발 보쌈 오리고기 소맥 참이슬</div>
                <div>
                <span>@khacademy</span>
                <span>2023.07.05</span>
                <span>조회수 111</span>
                <span>댓글수 5</span>
                </div>
            </div>
            <div><img src="../img/이미지없음.jpg"></div>
                
            
        </section>

        <section class="fir">
            <div class="left">
                <div><input type="checkbox" name="feed"><a href="#">게시글 제목</a></div>
                <div>삼겹살 짜장면 김치찌개 소고기 돼지고기 닭발 토마토 파스타 까르보나라 족발 보쌈 오리고기 소맥 참이슬 
                    삼겹살 짜장면 김치찌개 소고기 돼지고기 닭발 토마토 파스타 까르보나라 족발 보쌈 오리고기 소맥 참이슬</div>
                <div>
                <span>@khacademy</span>
                <span>2023.07.05</span>
                <span>조회수 111</span>
                <span>댓글수 5</span>
                </div>
            </div>
            <div><img src="../img/이미지없음.jpg"></div>
                
            
        </section>

        <section class="number">
            <div>
                <span><input type="checkbox" id="all">전체선택</span>

            </div>

            <div class="pagination-area">
                <ul class="pagination">
                    <li><a href="#">&lt;&lt</a></li>
                    <li><a href="#">&lt;</a></li>
    
                    <li><a class="current">1</a></li>
    
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                    <li><a href="#">9</a></li>
                    <li><a href="#">10</a></li>
    
                    <li><a href="#">&gt;</a></li>
                    <li><a href="#">&gt;&gt;</a></li>
                </ul>
            </div>

            <div id="delete">
                <span><button>삭제하기</button></span>
            </div>

        </section>
       

    </main>


    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>


    <script src="${contextPath}/resources/js/LoginMyPage.js"></script>
    
    
</body>
</html>
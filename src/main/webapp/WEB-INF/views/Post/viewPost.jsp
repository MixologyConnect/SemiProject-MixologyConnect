<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>다른사용자 게시글 모아보기</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/viewPost.css">
    <link href="https://fonts.cdnfonts.com/css/segoe-ui-4" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

</head>
<body>
    
  


    <nav id="mc-nav"></nav>

    <main>

        <section class="follow">
            <section class="img">
                <img src="../img/user.png">
            </section>
            <section class="follow2">
                <div id="top">@khacademy</div>
                <div class="bottom">
                    <span>팔로워 ${followers.size()}</span>
                    <span>팔로잉 ${followings.size()}</span>
                </div>
            </section>
        </section>
        <section id="list">
            작성글 
        </section> 



        <section class="fir">
            <div class="left">
                <div>게시글 제목</a></div>
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
                <div>게시글 제목</a></div>
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
                <div>게시글 제목</a></div>
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
       

    </main>


    <div id="mc-footer"></div>

    <script src="resources/js/viewPost.js"></script>
</body>
</html>
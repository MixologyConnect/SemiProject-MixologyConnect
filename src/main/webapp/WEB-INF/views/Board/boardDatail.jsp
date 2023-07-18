<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상세 게시글</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/boardDatail.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>

<body style="overflow-x: hidden">
    <nav id="mc-nav"></nav>
    <div class="container">


        <div class="content">
            <div class="title">롱아일랜드 아이스티!</div>
            <div class="name">user</div>
            <div class="date">
                2023.07.12 오전 12:31
                <div class="views">조회수 : 50</div>
            </div>

            <!-- 게시글 사진, 내용, 좋아요, 공유버튼 있는 칸 -->
            <!-- 사진 -->
            <div class="img">
                <div>
                    <img
                        src="https://static.wixstatic.com/media/6c7c63_6ecbbc371bc34437ab1fff7375bf32af~mv2.jpeg/v1/fill/w_420,h_420,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/6c7c63_6ecbbc371bc34437ab1fff7375bf32af~mv2.jpeg">
                </div>
            </div>
            <!-- 게시글 내용 -->
            <div class="datail">
                
                롱일랜드 아이스티, 줄여서 '롱티'라고도 자주 불리는 이 칵테일은 달콤한 콜라 향에 숨겨진 꽤나 높은 알콜도수를 자랑한답니다.
                데킬라, 럼, 보드카 등 다양한 양주가 들어가는 칵테일계의 진정한 폭탄주로 많은 사랑을 받고 있죠!
                롱티는 미국의 금주법 시대에 만들어진 레시피라는 설이 있답니다. 술을 구하기 어려웠기에 소량으로 남았던 술들 종류불문하고
                다 넣어서 한 번에 마시기 위해 섞은 것에서부터 시작되었다고 해요. 그래서인지 달콤한 콜라로 위장하기 딱 좋은 맛과 외형을 가졌으나,
                한 잔으로도 금방 취할 수 있으니 방심은 금물!

                1. 글라스에 얼음을 먼저 넣는다.
                2. 보드카, 데킬라, 진, 럼, 그리고 트리플섹을 먼저 따른 후 사워믹스까지 넣는다.
                3. 남은 공간은 콜라로 가득 채워준다.
                4. 바 스푼으로 천천히 저어주고 웨지 레몬으로 장식한다.
                Tip: 너무 세게 저으면 콜라의 탄산이 쉽게 빠지기 때문에 천천히 저어줘야 함!
            
            </div>

            <form>
                <!-- 좋아요, 북마크 -->
                    <div class="share">
                        <button type="button" id="bookBtn"><img isd="bookBtnImg" src="../images/bookmark.svg" onclick="bookBtnClick()"></button>
                        <button type="button" id="likeBtn"><img src="../images/heart.svg" id="likeBtnImg"
                                onclick="likeBtnClick()"></button>
                    </div>

                <div class="commentWrite">
                    <input type="text" name="commentWrite" id="commentWrite" placeholder="댓글을 입력해주세요.">
                    <button type="submit" name="commentbtn" id="commentbtn">댓글 저장</button>
                </div>
            </form>
            <!-- 댓글 -->
            <div class="comment">
                <div class="profilePicture"><img src="${contextPath}/resources/images/person-circle.svg"></div>
                <div class="userName">
                    user01
                    <div class="commentContent">
                        안녕하세요 글이 너무 좋은걸요?
                    </div>
                </div>
            </div>
            <div class="comment">
                <div class="profilePicture"><img src="${contextPath}/resources/images/person-circle.svg"></div>
                <div class="userName">
                    user02
                    <div class="commentContent">
                        친구해요~~
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div id="mc-footer"></div>

    <script src="${contextPath}/resources/js/boardDatail.js"></script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>
    
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
                <c:if test="${empty loginMember.profileImage}">

                    <div><img src="${contextPath}/resources/images/user.png"  ></div>
                </c:if>
                <c:if test="${!empty loginMember.profileImage}">

                    <div><img src="${contextPath}${loginMember.profileImage}"></div>
                </c:if>
            </section>
            <section class="follow2">
                <div id="top">${loginMember.memberName}</div>
                <div class="bottom">
                    <span><a href="#">팔로워 ${followers.size()}</a></span>
                    <span><a href="#">팔로잉 ${followings.size()}</a></span>
                </div>
            </section>
        </section>
        <section id="list">
           <!-- <span><a href="#">작성글</a></span>  
           <span><a href="#">저장한 게시글</a></span>  
           <span><a href="#">알림</a></span>  
           <span id="alarm"><a href="#">글쓰기</a></span>   -->
           <p class="thead"><a href="#">작성글</a></p>  
           <p><a href="${contextPath}/board/followlist"></a></p>
           <p><a href="${contextPath}/myPage/bookMark">북마크</a></p>  
           <p>
           <p id="alarm"><a href="#">글쓰기 <i class="fa-solid fa-pen-to-square"></i></a></p>  
        </section> 

        <c:choose>
            <c:when test="${empty boardList}">
                <tr>
                    <th>게시글이 존재하지 않습니다.</th>
                </tr>
            </c:when>

                <c:otherwise>

					<c:forEach var="board" items="${boardList}">
						<section class="fir">
							<div class="left">
								<div class="board">
									<a href="${contextPath}/board/boardDetail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}">
                                    <h3><input type="checkbox" name="feed" value="${board.boardNo}" id="check">${board.boardTitle}</h3>
								</div>
								<div>${board.boardContent}</div>
								<div class="nameDateCount">
									<span>${board.memberName}</span> <span>${board.boardDate}</span> <span>조회수 : ${board.readCount}</span>
								</div>
							</div>
							<div class="img">
								<c:if test = "empty${board.thumbnail}">
									<img src="${contextPath}/resources/images/heart.svg">
								</c:if>
								<img src="${contextPath}${board.thumbnail}">
							</div>
						    </a>
						</section>

					</c:forEach>

                </c:otherwise>

        </c:choose>



        

        <section class="number">
            <div>
                <span><input type="checkbox" id="all" onclick="deleteAll()">전체선택</span>

            </div>

            <div class="pagination-area">
                <c:set var="url" value="myPage?&cp="/>

                <ul class="pagination">
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="${url}1">&lt;&lt;</a></li>
                    <!-- 이전 목록 마지막 번호로 이동 -->
                    <li><a href="${url}${pagination.prevPage}">&lt;</a></li>


                    <!-- 범위가 정해진 일반 for문 사용 -->
                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                <li><a class="current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${url}${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>

                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="${url}${pagination.nextPage}">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="${url}${pagination.maxPage}">&gt;&gt;</a></li>
                </ul>
            </div>

            <div id="delete">
                <span><button onclick="deletePost()">삭제하기</button></span>
            </div>

        </section>
       

    </main>


    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script>
        const contextPath = "${contextPath}"
     </script>


    <script src="${contextPath}/resources/js/LoginMyPage.js"></script>
    
    
</body>
</html>
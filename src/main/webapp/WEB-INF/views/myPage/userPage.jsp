<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>
<c:set var="member" value="${map.member}"/>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${member.memberName}님의 페이지입니다.</title>
        
        <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
        <link rel="stylesheet" href="${contextPath}/resources/css/boardAll.css">
         <link rel="stylesheet" href="${contextPath}/resources/css/myPage.css"> 
        <link href="https://fonts.cdnfonts.com/css/segoe-ui-4" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
    	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

</head>
<body>
    
    


    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <main>

        <section class="follow">
            <section class="img1">
                <c:if test = "${empty member.profileImage}">
                    <div><img src="${contextPath}/resources/images/user.png"></div>
                </c:if>

                <c:if test = "${!empty member.profileImage}">
                    <div><img src="${contextPath}${member.profileImage}"></div>
                </c:if>
               
                
            </section>
            <section class="follow2">
                <div id="top">${member.memberName}</div>
                
                <div class="bottom">
                    <span id="followerView">팔로워 ${followers.size()}</span>
                    <span id="folloingView">팔로잉 ${followings.size()}</span>
            </section>
        </section>
        <section id="list">
           <!-- <span><a href="#">작성글</a></span>  
           <span><a href="#">저장한 게시글</a></span>  
           <span><a href="#">알림</a></span>  
           <span id="alarm"><a href="#">글쓰기</a></span>   -->
           <p>
        </section> 

        <c:choose>
            <c:when test="${empty boardList}">
                
                <span class="center">게시글이 존재하지 않습니다.</span>
                
            </c:when>

                <c:otherwise>

					<c:forEach var="board" items="${boardList}">
						<section class="fir">
                            <a href="${contextPath}/board/boardDetail?no=${board.boardNo}&cp=${pagination.currentPage}&type=1">
                            <div class="left">
                                <div class="img">
                                    <c:choose>
                                        <c:when test="${!empty board.thumbnail}">
                                            <img src="${contextPath}${board.thumbnail}">
                                        </c:when>
                                        <c:otherwise>
                                            <img src = "${contextPath}/resources/images/user.png"> 
                                        </c:otherwise>
                                    </c:choose>
                                    

                                    <div class="titleContent">
                                        <div class="board">
                                            <h3>${board.boardTitle}</h3>
                                        </div>
                                        
                                        <span class="memberName">${board.memberName}</span>
                                    </div>
                                    <div class="nameDateCount">
                                    <span class="boardDate">${board.boardDate}</span>
                                        <span class="read">조회수 : ${board.readCount}</span>
                                        <span id="likeResult">좋아요 수 : ${board.boardLikeCount}</span>
                                    </div>
                                    
                                    
                                </div>
                                </a>
                            </div>
                            
                        </section>
                    
                </c:forEach>
                
            </c:otherwise>
            
        </c:choose>
        
        
        
        
        
        <section class="number">

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

        </section>
       

    </main>

   
   


    <div class="follower-modal">
        <div class="follow-wrap1">
            <span class="follower-close">&times;</span>
            <span class="list-title">FOLLOW LIST</span>
            <c:choose>
                <c:when test="${empty followers}">
                    <div class="follow-area">
                        <span>팔로워가 없습니다.</span>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="follower" items="${followers}">
                        <div class="follow-area">
                            <div class="f-info">
                                <c:if  test="${empty follower.profileImage}">
                                   <img class="fprofile" src="${contextPath}/resources/images/user.png">
                                </c:if>
                                <c:if test="${!empty follower.profileImage}">
                                    <img class="fprofile" src="${contextPath}${follower.profileImage}">
                                </c:if>
                                <span>${follower.memberId}</span>
                            </div>
                            <div>
                                
								<button type="button" id="followBtn" onclick="followCancelBtnClick()">Cancel</button>
								<input type="hidden" name="0" id="followCheck">

                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            
           
            
        </div>
    </div>
    <div class="folloing-modal">
        <div class="folloing-wrap2">
            <span class="folloing-close">&times;</span>
            <span class="list-title">FOLLOWING LIST </span>
            <c:choose>
                <c:when test="${empty followings}">
                    <div class="follow-area">
                        <span>팔로워가 없습니다.</span>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="following" items="${followings}">
                        <div class="follow-area">
                            <div class="f-info">
                                <c:if test="${empty following.profileImage}">
                                   <img class="fprofile" src="${contextPath}/resources/images/user.png">
                                </c:if>
                                <c:if test="${!empty following.profileImage}">
                                    <img class="fprofile" src="${contextPath}${following.profileImage}">
                                </c:if>
                                <span>${following.memberId}</span>
                            </div>
                            <div>
								<button type="button" id="followBtn" onclick="unfollowBtnClick()">UnFollow</button>
								<input type="hidden" name="0" id="followCheck">
                            </div>


                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>    
            
                
                
                
            
        </div>
        
    </div>


    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/common/modal.jsp"/>
           
    <script>
        const contextPath = "${contextPath}"
    </script>

    <script src="${contextPath}/resources/js/LoginMyPage.js"></script>
    <script src="${contextPath}/resources/js/boardDatail.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    
    
</body>
</html>
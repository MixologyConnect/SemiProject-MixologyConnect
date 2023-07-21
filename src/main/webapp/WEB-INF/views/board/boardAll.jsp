<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 목록</title>
<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
<link rel="stylesheet" href="${contextPath}/resources/css/boardAll.css">

<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous"></script>
<body style="overflow-x: hidden">

	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<main>
		<div class="top">
			<p>게시글 목록</p>
		</div>

		<!-- 전체, 팔로잉, 공지 -->
		<div class="top-2">
			<button id="all" name="all">전체</button>
			<button id="Following" name="Following">팔로잉</button>
			<button id="notice" name="notice">공지</button>
			<div class="right">
				<button id="new" name="new">최신순</button>
				<button id="top" name="top">인기순</button>
			</div>
		</div>

		
		<section class="fir">
			<div class="left">
				<div class="board">
					<a href="${contextPath}/board/boardDetail">게시글 제목</a>
				</div>
				<div>삼겹살 짜장면 김치찌개 소고기 돼지고기 닭발 토마토 파스타 까르보나라 족발 보쌈 오리고기 소맥 참이슬
					삼겹살 짜장면 김치찌개 소고기 돼지고기 닭발 토마토 파스타 까르보나라 족발 보쌈 오리고기 소맥 참이슬</div>
				<div>
					<span>@khacademy</span> <span>2023.07.05</span> <span>조회수
						111</span> <span>댓글수 5</span>
				</div>
			</div>
			<div class="img">
				<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA2MDVfMjMw%2FMDAxNjg1OTc0MTQ3NDU0.WnCvTZeQNkQ4X0TFe78tSCTbTB3r8NKmTyNITw0Ctfog.B_vuAbe-oIH6AJw0b6coC3X7niIdfeFsfp0LEtlyVDsg.JPEG.ls2924%2FIMG_0536.jpg&type=sc960_832">
			</div>
			

		</section>
			
			
		


		<div class="pagination-area">
			<c:set var="url" value="boardAll?type=${param.type}&cp="/>



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


	</main>


	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

	<script src="${contextPath}/resources/js/boardAll.js"></script>
	<script src="https://kit.fontawesome.com/a5af36132e.js"
		crossorigin="anonymous"></script>
</body>

</html>
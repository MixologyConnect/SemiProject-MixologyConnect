<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:set var="boardName" value="${map.boardName}"/>
	<c:set var="pagination" value="${map.pagination}"/>
	<c:set var="boardList" value="${map.boardList}"/>
	
	
	<!DOCTYPE html>
	<html lang="en">
		
		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>${boardName}</title>
			<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
			<link rel="stylesheet" href="${contextPath}/resources/css/boardAll.css">
			
			<script src="https://code.jquery.com/jquery-3.7.0.min.js"
			integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
			<script src="${contextPath}/resources/js/boardAll.js"></script>
			<script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>

		<body style="overflow-x: hidden">

			<jsp:include page="/WEB-INF/views/common/header.jsp"/>
			<main>
				<div class="top">
					<p>${boardName}</p>
					<p>${loginMember.memberName}님의 팔로잉 게시글들을 모아보세요</p>
					=
				</div>

				<!-- 전체, 팔로잉, 공지 -->
				<div class="top-2">

					<button id="all" name="all"><a href="${contextPath}/board/boardAll?type=1&cp1" style="text-decoration: none;">전체</a></button>

					
				</div>

				<c:choose>
					<c:when test="${empty boardList}">
						<tr>
							<th>게시글이 존재하지 않습니다.</th>
						</tr>
					</c:when>

					<c:otherwise>

					<c:forEach var="board" items="${boardList}">
						<section class="fir">
							<a href="boardDetail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}">
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
										<span class="boardContent">${board.boardContent}</span>

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

				<div class="btn-area">
					<c:if test = "${!empty loginMember}">
					<button id="insertBtn" type = "button" onclick="location.href = 'boardWrite?mode=insert&type=${param.type}&cp=${param.cp}'">글쓰기</button>
				</c:if>
				</div>


				<div class="pagination-area">
					<c:set var="url" value="followList?type=${param.type}&cp="/>

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
			<jsp:include page="/WEB-INF/views/common/footer.jsp" />
			<jsp:include page="/WEB-INF/views/common/modal.jsp"/>
			<!-- <script src="${contextPath}/resources/js/board/board.js"></script> -->
			<script src="${contextPath}/resources/js/main.js"></script>
		</body>
		</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


			<!DOCTYPE html>
			<html lang="en">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>상세 게시글</title>
				<link rel="stylesheet" href="${contextPath}/resources/css/boardDatail.css">
				<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
				<link rel="stylesheet" href="${contextPath}/resources/css/reply.css">

			</head>

			<body style="overflow-x: hidden">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
				<div class="container">


					<div class="content">
						<div class="title">${detail.boardTitle}</div>
						<div class="name">${detail.memberName}</div>
						<div class="date">
							${detail.boardDate}
							<div class="views">조회수 : ${detail.readCount}</div>
						</div>

						<!-- 게시글 사진, 내용, 좋아요, 공유버튼 있는 칸 -->
						<!-- 사진 -->
						<!-- 이미지가 있을 경우 -->
						<c:if test="${!empty detail.imageList}">

							<!-- 썸네일이 있을 경우 변수 생성 -->
							<c:if test="${detail.imageList[0].imageLevel == 0}">
								<c:set var="thumbnail" value="${detail.imageList[0]}" />
								<!-- page scope(페이지 어디서든 사용 가능) -->
							</c:if>

						</c:if>


						<!-- 썸네일 영역(썸네일이 있을 경우) -->
						<c:if test="${!empty thumbnail}">

							<div class="img">
								<div class="boardImg thumnail">
									<img src="${contextPath}${thumbnail.imageRename}">
									<a href="${contextPath}${thumbnail.imageRename}"
										download="${thumbnail.imageOriginal}">다운로드</a>
								</div>
							</div>

						</c:if>

						<c:if test="${empty thumbnail}"> <!-- 썸네일 X -->
							<c:set var="start" value="0"></c:set>
						</c:if>

						<c:if test="${!empty thumbnail}"> <!-- 썸네일 O -->
							<c:set var="start" value="1"></c:set>
						</c:if>

						<!-- 썸네일만 있고 이미지가 없는 경우 -->
						<c:if test="${fn:length(detail.imageList) > start}">

							<!-- 업로드 이미지 영역 -->
							<div class="img">
								<c:forEach var="i" begin="${start}" end="${fn:length(detail.imageList) -1}">
									<div class="boardImg">
										<img src="${contextPath}${detail.imageList[i].imageRename}">
										<a href="${contextPath}${detail.imageList[i].imageRename}"
											download="${detail.imageList[i].imageOriginal}">다운로드</a>
									</div>
								</c:forEach>

							</div>
						</c:if>
						<!-- 게시글 내용 -->
						<div class="datail">
							${detail.boardContent}
						</div>

						<form>
							<!-- 좋아요, 북마크 -->
							<div class="share">
								<button type="button" id="bookBtn">
									<img id="bookBtnImg" src="${contextPath}/resources/images/bookmark.svg"
										onclick="bookBtnClick()">
								</button>
								<button type="button" id="likeBtn">
									<img src="${contextPath}/resources/images/heart.svg" id="likeBtnImg"
										onclick="likeBtnClick()">
								</button>
							</div>
							<div class="alterBtn">
								<button id="goToBtn">목록으로</button>
								<button id="updateBtn">수정</button>
								<button id="deleteBtn">삭제</button>
							</div>

							<jsp:include page="/WEB-INF/views/board/reply.jsp" />

							<jsp:include page="/WEB-INF/views/common/footer.jsp" />

							<script src="https://code.jquery.com/jquery-3.7.0.min.js"
								integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
								crossorigin="anonymous"></script>

							<script src="${contextPath}/resources/js/board/board.js"></script>
							<script src="${contextPath}/resources/js/boardDatail.js"></script>

							<script>
								const contextPath = "${contextPath}";

								const boardNo = "${detail.boardNo}";

								const loginMemberNo = "${loginMember.memberNO}";

							</script>

							<script src="${contextPath}/resources/js/board/reply.js"></script>
			</body>

			</html>
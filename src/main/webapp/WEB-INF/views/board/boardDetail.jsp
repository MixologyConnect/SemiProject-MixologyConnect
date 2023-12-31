<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>




			<!DOCTYPE html>
			<html lang="en">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>${detail.boardTitle}</title>
				<link rel="stylesheet" href="${contextPath}/resources/css/boardDatail.css">
				<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
				<link rel="stylesheet" href="${contextPath}/resources/css/reply.css">
				<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

			</head>

			<body style="overflow-x: hidden">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
				<div class="container">



					<div class="content">
						<form action="../myPage/userPage" method="post">

						<div class="title">${detail.boardTitle}</div>
						<div class="name">
							<c:if test="${empty detail.profileImage}">
								<!-- 프로필 이미지가 없는 경우 -->
								
								
								<c:if test = "${loginMember.memberNo == detail.memberNo}">
									<img src="${contextPath}/resources/images/user.png" onclick="location.href ='${contextPath}/myPage/myPage'">
								</c:if>
								<!-- 로그인 멤버와 상세게시글 멤버의 no가 같지않다면 유저페이지로 이동 -->
								<c:if test = "${loginMember.memberNo != detail.memberNo}">
									<img src="${contextPath}/resources/images/user.png" onclick="submit()">
								</c:if>

								</c:if>



								<c:if test="${!empty detail.profileImage}">
									<c:if test = "${loginMember.memberNo == detail.memberNo}">
										<img src="${contextPath}${detail.profileImage}"  onclick="location.href ='${contextPath}/myPage/myPage'">
								</c:if>
									<!-- 프로필 이미지가 있는 경우 -->
									<c:if test = "${loginMember.memberNo != detail.memberNo}">
									<img src="${contextPath}${detail.profileImage}" onclick="submit()">
								</c:if>
								</c:if>
								<input type="hidden" name="memberNo" value="${detail.memberNo}">
									${detail.memberName}
							</form>
							<!-- 팔로우 버튼 -->
							<c:if test="${loginMember.memberNo != detail.memberNo}">
								<button type="button" id="followBtn" onclick="followBtnClick()">FOLLOW</button>
								<input type="hidden" name="0" id="followCheck">
							</c:if>
						</div>
						<div class="date">${detail.boardDate}
							<div class="views">조회수 : ${detail.readCount}</div>
							<c:if test="${!empty detail.modifyDate}">
								<div class="views">마지막 수정일 : ${detail.modifyDate}</div>
							</c:if>
						</div>

						<!-- 게시글 사진, 내용, 좋아요, 공유버튼 있는 칸 -->

						<c:if test="${empty thumbnail}"> <!-- 썸네일 X -->
							<c:set var="start" value="0"></c:set>
						</c:if>


						<!-- 썸네일만 있고 이미지가 없는 경우 -->
						<c:if test="${fn:length(detail.imageList) > start}">

							<!-- 업로드 이미지 영역 -->
							<div class="img-box">
								<c:forEach var="i" begin="${start}" end="${fn:length(detail.imageList) -1}">
									<div class="boardImg">
										<img class="list-thumbnail"
											src="${contextPath}${detail.imageList[i].imageRename}" class="boardImg1">

									</div>
								</c:forEach>

							</div>
						</c:if>
						<!-- 게시글 내용 -->
						<div class="datail">
							${detail.boardContent}
						</div>


						<!-- 좋아요, 북마크 -->
						<div class="share">

							<button type="button" id="bookBtnMinus">
								<img id="bookBtnImg" src="${contextPath}/resources/images/bookmark-fill.svg"
									onclick="bookBtnClickPlus()">
							</button>
							<button type="button" id="bookBtnPlus">
								<img id="bookBtnImg" src="${contextPath}/resources/images/bookmark.svg"
									onclick="bookBtnClickMinus()">
							</button>

							<button type="button" id="likeBtn">
								<img src="${contextPath}/resources/images/heart.svg" id="likeBtnImg"
									onclick="likeBtnClick()">

								<c:if test="${likeMember==detail.boardNo}">
									<input type="hidden" id="likeCheck" name="1">
								</c:if>
								<c:if test="${likeMember!=detail.boardNo}">
									<input type="hidden" id="likeCheck" name="0">
								</c:if>
							</button>
							<span id="likeResult">${likeCount}</span>



						</div>
						<div class="alterBtn">




							<c:if test="${loginMember.memberNo == detail.memberNo}">
								<c:if test="${empty param.cp}">
									<c:set var="cp" value="1"></c:set>
								</c:if>

								<c:if test="${!empty param.currentPage}">
									<c:set var="cp" value="${param.cp}"></c:set>
								</c:if>

								<button id="updateBtn" type="button"
									onclick="location.href = 'boardWrite?mode=update&type=${param.type}&cp=${param.cp}&no=${detail.boardNo}'">수정</button>
								<button id="deleteBtn" type="button">삭제</button>
							</c:if>

							<c:if test="${!empty param.query}">
								<button id="selectListBtn" type="button">목록으로</button>
							</c:if>

								<c:set var = "referUrl" value = "${header.referer}"></c:set>
								<c:set var = "userPage" value = "http://localhost:10005/SemiProfect_3/myPage/userPage"></c:set>
								
								<c:if test = "${referUrl==userPage}">
									<form action="../myPage/userPage" method="post">
										<button id="backBtn" type="button" onclick="submit()">이전으로</button>
												<input type="hidden" name="memberNo" value="${detail.memberNo}">
											</form>
								</c:if>

								<c:if test="${empty param.query}">
									<button id="goToBtn" type="button">목록으로</button>
								</c:if>



						</div>
						<jsp:include page="/WEB-INF/views/board/reply.jsp" />
					</div>
				</div>

				</div>

				<div class="modal">
					<span id="modal-close">&times;</span>
					<img id="modal-image" src="${contextPath}/resources/images/user.png">
					<a href="${contextPath}${detail.imageList[i].imageRename}"
						download="${contextPath}${detail.imageList[i].imageOriginal}" id="boardImg1"><img id="download"
							src="${contextPath}/resources/images/download.svg"></a>
				</div>





				<jsp:include page="/WEB-INF/views/common/footer.jsp" />
				<script src="${contextPath}/resources/js/boardDatail.js"></script>
				<jsp:include page="/WEB-INF/views/common/modal.jsp" />
				<script src="https://code.jquery.com/jquery-3.7.0.min.js"
					integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

				<script src="${contextPath}/resources/js/board/board.js"></script>

				<script>
					
					const boardNo = "${detail.boardNo}";
					const writerNo = "${detail.memberNo}";
					const loginMemberNo = "${loginMember.memberNo}";
					const likeMember = "${likeMember}"
					const followingWriter = "${writerNo}"
					const memberNo = "${detail.memberNo}";
				</script>


				
				
				<script src="${contextPath}/resources/js/board/reply.js"></script>
				<script src="${contextPath}/resources/js/search/search.js"></script>
				<script src="${contextPath}/resources/js/bookMark.js"></script>
				<script src="${contextPath}/resources/js/main.js"></script>
			</body>

			</html>
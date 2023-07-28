<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--문자열 관렬 함수(메소드) 제공 JSTL (EL형식) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="cocktailList" value="${map.cocktailList}"/>
<c:set var="boardList" value="${map.boardList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>검색 조회</title>


<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
<link rel="stylesheet" href="${contextPath}/resources/css/search.css">
<script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous"></script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div id="content">
	
		<section class="result_search">
			<h4 class="block">검색결과</h4>
			<div class="box_search_new">
				<div class="search_area">
					<form action="search" method="get" name="search" class="search">
						<input type="search" name="query" id="keyword" value="${param.query}"> <a
							href="#" class="search_icon"> <img
							src="https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/skin/front/pub/images/common/icon_magnifier.png"
							alt="">
						</a>
					</form>
				</div>
				<div class="popular_keyword">
					<strong>인기검색어</strong>
					<ul>
						<li><a href="#"><span>#달달한</span></a></li>
						<li><a href="#"><span>#강한</span></a></li>
						<li><a href="#"><span>#칵테일</span></a></li>
						<li><a href="#"><span>#레몬</span></a></li>

					</ul>
				</div>
			</div>
			<p class="txt_result">

				<c:if test="${!empty map}">
					검색하신 <span>“<em>${param.query}</em>”
					</span> 에 대한 개의 검색 결과가 있습니다.
				</c:if>
				
			</p>
			<div class="cocktail_pick_list">
				<span class="pick_list_num"> 칵테일 정보( <strong>3</strong> )
				</span>
			</div>
			<div class="list_prd">
				<ul class="list-shop">
					<div class="list_prd">
						<ul class="list-shop">
							<c:if test="${empty cocktailList}">
								<span>“<em>${param.query}</em>”
								</span> 검색 결과가 없습니다.
							</c:if>
							<c:forEach var="cocktail" items="${cocktailList}">
								<li>
									<a href="#">
										<div class="box_img">
	
											<img
												src="${contextPath}${cocktail.imagePath}"
												style="width: 382px; height: 200px; ">
										</div>
										<div class="txt_box">
											<p class="name cocktail">${cocktail.cocktailName}</p>
										</div>
										<div class="box_absol"></div>
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</ul>
			</div>


			<div class="cocktail_pick_list">
				<span class="pick_list_num"> 커뮤니티 ( <strong>5</strong> )
				</span>
				<br>
				<div class="cocktail_pick_list2">
					<table class="list-table">
						<thead>
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty boardList}">
									<tr>
										<th colspan="5">게시글이 존재하지 않습니다.</th>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="board" items="${boardList}">
										<tr>
											<td>${board.boardNo}</td>
											<td>
												<a href="#">${board.boardTitle}</a>
											</td>
											<td>${board.memberId}</td>
											<td>${board.createDate}</td>
											<td>${board.readCount}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							
							
						</tbody>
					</table>

				</div>

			</div>
			<div class="cocktail_pick_list">
				<span class="pick_list_num"> 믹스올로지 컬럼 ( <strong>1</strong> )
				</span>
				<br>
				<div class="cocktail_pick_list2">
					<table class="list-table">
						<thead>
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>10</td>
								<td>
									<a href="#">10번째글</a>
								</td>
								<td>유저일</td>
								<td>2023-07-17</td>
								<td>50</td>
							</tr>
							<tr>
								<td>10</td>
								<td>
									<a href="#">10번째글</a>
								</td>
								<td>유저일</td>
								<td>2023-07-17</td>
								<td>50</td>
							</tr>
							<tr>
								<td>10</td>
								<td>
									<a href="#">10번째글</a>
								</td>
								<td>유저일</td>
								<td>2023-07-17</td>
								<td>50</td>
							</tr>
							<tr>
								<td>10</td>
								<td>
									<a href="#">10번째글</a>
								</td>
								<td>유저일</td>
								<td>2023-07-17</td>
								<td>50</td>
							</tr>
							<tr>
								<td>10</td>
								<td>
									<a href="#">10번째글</a>
								</td>
								<td>유저일</td>
								<td>2023-07-17</td>
								<td>50</td>
							</tr>
							<tr>
								<td>10</td>
								<td>
									<a href="#">10번째글</a>
								</td>
								<td>유저일</td>
								<td>2023-07-17</td>
								<td>50</td>
							</tr>
						</tbody>
					</table>

				</div>

			</div>

		</section>
		

	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>
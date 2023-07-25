<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--문자열 관렬 함수(메소드) 제공 JSTL (EL형식) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
					<form action="#" method="get" name="search" class="search">
						<input type="search" name="keyword" id="keyword"> <a
							href="#" class="search_icon"> <img
							src="https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/skin/front/pub/images/common/icon_magnifier.png"
							alt="">
						</a>
					</form>
				</div>
				<div class="popular_keyword">
					<strong>인기검색어</strong>
					<ul>
						<li><a href="#"><span>#여름밤</span></a></li>
						<li><a href="#"><span>#과일맛</span></a></li>
						<li><a href="#"><span>#커피맛</span></a></li>
						<li><a href="#"><span>#산뜻한</span></a></li>

					</ul>
				</div>
			</div>
			<p class="txt_result">
				검색하신 <span>“<em>칵테일</em>”
				</span> 에 대한 #개의 검색 결과가 있습니다.
			</p>
			<div class="cocktail_pick_list">
				<span class="pick_list_num"> 칵테일 정보( <strong>3</strong> )
				</span>
			</div>
			<div class="list_prd">
				<ul class="list-shop">
					<div class="list_prd">
						<ul class="list-shop">
							<li><a href="#">
									<div class="box_img">

										<img
											src="https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg"
											style="width: 382px">
									</div>
									<div class="txt_box">
										<p class="name cocktail">서울의 밤</p>
										<p class="exple_bow"
											style="margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;">매실향
											짙은 한국형 진</p>
									</div>
									<div class="box_absol"></div>
							</a></li>
							<li><a href="#">
									<div class="box_img">

										<img
											src="https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg"
											style="width: 382px">
									</div>
									<div class="txt_box">
										<p class="name cocktail">서울의 밤</p>
										<p class="exple_bow"
											style="margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;">매실향
											짙은 한국형 진</p>
									</div>
									<div class="box_absol"></div>
							</a></li>
							<li><a href="#">
									<div class="box_img">

										<img
											src="https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg"
											style="width: 382px">
									</div>
									<div class="txt_box">
										<p class="name cocktail">서울의 밤</p>
										<p class="exple_bow"
											style="margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;">매실향
											짙은 한국형 진</p>
									</div>
									<div class="box_absol"></div>
							</a></li>
							<li><a href="#">
									<div class="box_img">

										<img
											src="https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg"
											style="width: 382px">
									</div>
									<div class="txt_box">
										<p class="name cocktail">서울의 밤</p>
										<p class="exple_bow"
											style="margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;">매실향
											짙은 한국형 진</p>
									</div>
									<div class="box_absol"></div>
							</a></li>
							<li><a href="#">
									<div class="box_img">

										<img
											src="https://cdn-pro-web-251-112.cdn-nhncommerce.com/motioneye1_godomall_com/data/goods/23/03/13/500000326/500000326_detail_083.jpg"
											style="width: 382px">
									</div>
									<div class="txt_box">
										<p class="name cocktail">서울의 밤</p>
										<p class="exple_bow"
											style="margin-top: 20px; font-size: 14px; font-weight: 400; color: #acacac;">매실향
											짙은 한국형 진</p>
									</div>
									<div class="box_absol"></div>
							</a></li>
							
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
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
<link rel="stylesheet" href="resources/css/search.css">
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
							</a></li>
						</ul>

					</div>

				</ul>
			</div>


			<div class="cocktail_pick_list">
				<span class="pick_list_num"> 커뮤니티 ( <strong>5</strong> )
				</span>
				<div class="cocktail_pick_list2">
					<a href="#"> <a
						href="/board/view.php?bdId=free&amp;sno=1263&amp;goodsNo=0">2023.04.14
							기타 &gt; 전통주 무제한 바가 있을까요?</a>
					</a> <br> <a href="#"> <a
						href="/board/view.php?bdId=free&amp;sno=1263&amp;goodsNo=0">2023.04.14
							기타 &gt; 전통주 무제한 바가 있을까요?</a>
					</a> <br> <a href="#"> <a
						href="/board/view.php?bdId=free&amp;sno=1263&amp;goodsNo=0">2023.04.14
							기타 &gt; 전통주 무제한 바가 있을까요?</a>
					</a> <br>

				</div>

			</div>
			<div class="cocktail_pick_list">
				<span class="pick_list_num"> 믹스올로지 컬럼 ( <strong>1</strong> )
				</span>
				<div class="cocktail_pick_list2">
					<a href="#"> <a
						href="/board/view.php?bdId=free&amp;sno=1263&amp;goodsNo=0">2023.04.14
							기타 &gt; 전통주 무제한 바가 있을까요?</a>
					</a> <br> <a href="#"> <a
						href="/board/view.php?bdId=free&amp;sno=1263&amp;goodsNo=0">2023.04.14
							기타 &gt; 전통주 무제한 바가 있을까요?</a>
					</a> <br>


				</div>

			</div>

		</section>

	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>
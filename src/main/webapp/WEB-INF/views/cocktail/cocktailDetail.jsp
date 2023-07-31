<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칵테일 목록</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/cocktailDetail.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<main>
        <div id="head">
			<p>칵테일 정보</p>
			<p>마르티네스</p>
		</div>
        <div id="cocktail-detail">
            <div id="cocktail-image">
                <img>
            </div>
            <div id="cocktail-info">
                <h1>마르티네스</h1>
                <div id="cocktail-property">
                    <p>도수 ★★☆</p>
                    <p>당도 ★☆☆</p>
                    <p>난이도 ★★☆</p>
                </div>
                <div id="full-divider"></div>
                <div id="cocktail-recipe">
                    <h3>레시피</h3>
                    <div>
                        <img src="${contextPath}/resources/images/ingredient/base.png">&nbsp;
                        <p>런던 드라이 진 - 45 ml (1 1/2 oz)</p>
                    </div>
                    <div>
                        <img src="${contextPath}/resources/images/ingredient/juice.png">&nbsp;
                        <p>스위트 베르무트 - 45 ml (1 1/2 oz)</p>
                    </div>
                    <div>
                        <img src="${contextPath}/resources/images/ingredient/garnish.png">&nbsp;
                        <p>룩사르도 마라스키노 - 1 tsp</p>
                    </div>
                    <div>
                        <img src="${contextPath}/resources/images/ingredient/etc.png">&nbsp;
                        <p>앙고스투라 비터 - 2 Dashes</p>
                    </div>
                    <p>위의 재료들을 모두 믹싱 글라스에 얼음과 함께 스터한 후, 얼음을 걸러내고 차갑게 식힌 마티니 글라스에 따라주면 완성.</p>
                </div>
            </div>
        </div>
        <div id="fixed-divider"></div>
        <p id="cocktail-description">
            기원에 대해서는 두 가지 설이 있다. 하나는 옥시덴탈 호텔(Occidental Hotel)의 바텐더였던 제리 토마스가 처음으로 선보였다는 것이고, 다른 하나는 마르티네스 바의 바텐더였던 리슐리외(Richeliue)에 의해 선보여졌다는 것이다. 여담으로, 둘 다 캘리포니아 주에 위치해 있었다.
            마르티네스에 관한 가장 오래된 기록은 1884년 O. H. 바이런(O. H. Byron)의 저서 "모던 바텐더 가이드(The Modern Bartenders' Guide)>와, 1887년 제리 토마스의 저서 "바텐더 가이드(Thomas' The Bar-Tender's Guide)"이다. 바이런의 책에 따르면 마르티네스는 맨해튼에서 위스키를 진으로 대체한 칵테일이다. 원래의 마르티네스는 제네바 진을 사용했을 것으로 추정되나, 1887년 제리 토마스의 레시피에서는 올드 톰 진을 사용했다.
            여담으로, 1888년 해리 존슨(Harry Johnson)의 "New and Improved Illustrated Bartender's Manual"에서는 마지막 글자 ‘z’ 가 빠진 ‘Martine’ 으로 표기되었는데, 그로 인해 ‘마르티네스에서 마티니가 파생되었다’ 는 가설도 상당히 높은 지지를 얻고 있다.
        </p>
        <div id="cocktail-page">
            <p>다음 칵테일  이전 칵테일  목록으로</p>
        </div>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<jsp:include page="/WEB-INF/views/common/modal.jsp"/>
    <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
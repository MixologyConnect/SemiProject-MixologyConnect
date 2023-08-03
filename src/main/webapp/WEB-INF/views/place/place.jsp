<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>플레이스</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/place.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=cz1labzu75"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<main>
        <div id="head">
			<p>플레이스</p>
            <p>칵테일 관련 장소를 찾아보세요</p>
		</div>
        <div id="search">
			<img id="place-search" src="${contextPath}/resources/images/magnifier.png">
			<input id="place-input" type="text" placeholder="지역">
		</div>
        <div id="map"></div>
        <ul id="place-content">
        </ul>
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/common/modal.jsp"/>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="${contextPath}/resources/js/place.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칵테일 목록</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/cocktailList.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<main>
		<div id="head">
			<p>칵테일 목록</p>
			<p>칵테일 정보와 레시피를 조회할 수 있습니다</p>
		</div>
		<div id="search">
			<img src="${contextPath}/resources/images/magnifier.png">
			<input type="text" placeholder="어떤 칵테일을 찾고 계신가요?">
		</div>
		<div id="filter">
			<div>
				<p>베이스</p>
			</div>
		</div>
		<div id="ad"></div>
		<ul id="contents">
		</ul>
	</main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<jsp:include page="/WEB-INF/views/common/modal.jsp"/>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="${contextPath}/resources/js/cocktail/cocktailList.js"></script>
</body>
</html>
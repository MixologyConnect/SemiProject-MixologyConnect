<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<input%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<table>
				<tr>
					<td>베이스</td>
					<td>
						<input type="checkbox" class="radio-ingredient" value="67,70">브랜디</input>
						<input type="checkbox" class="radio-ingredient" value="25,31,37,49">럼</input>
						<input type="checkbox" class="radio-ingredient" value="3,18,27,32,34,35,39,46,48,51,57,68,69">리큐르</input>
						<input type="checkbox" class="radio-ingredient" value="15,45,58,65">위스키</input>
						<input type="checkbox" class="radio-ingredient" value="1,13">진</input>
						<input type="checkbox" class="radio-ingredient" value="2,47">베르무트</input>
					</td>
				</tr>
				<tr>
					<td>부가 재료</td>
					<td>
						<input type="checkbox" class="radio-ingredient" value="5,17,20,28,30,50">과일 주스</input>
						<input type="checkbox" class="radio-ingredient" value="11,16,21,24">탄산 음료</input>
						<input type="checkbox" class="radio-ingredient" value="38,56,63,54,63,66,71">우유/크림/달걀</input>
						<input type="checkbox" class="radio-ingredient" value="7,10,14,26,52">시럽</input>
					</td>
				</tr>
				<tr>
					<td>도수</td>
					<td>
						<input type="radio" name="alcohol" value="상">상</input>
						<input type="radio" name="alcohol" value="중">중</input>
						<input type="radio" name="alcohol" value="하">하</input>
					</td>
				</tr>
				<tr>
					<td>당도</td>
					<td>
						<input type="radio" name="sugar" value="상">상</input>
						<input type="radio" name="sugar" value="중">중</input>
						<input type="radio" name="sugar" value="하">하</input>
					</td>
				</tr>
			</table>
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
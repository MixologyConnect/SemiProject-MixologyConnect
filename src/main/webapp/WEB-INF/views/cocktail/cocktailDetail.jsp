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
            <p>${cocktail.cocktailName}</p>
		</div>
        <div id="cocktail-detail">
            <div id="cocktail-image">
                <img src="${contextPath}${cocktail.imagePath}">
            </div>
            <div id="cocktail-info">
                <div id="cocktail-property">
                    <table>
                        <tr>
                            <th width="70px">도수</th>
                            <td>${cocktail.alcohol}</td>
                        </tr>
                        <tr>
                            <th>당도</th>
                            <td>${cocktail.sugar}</td>
                        </tr>
                        <tr>
                            <th>난이도</th>
                            <td>${cocktail.difficulty}</td>
                        </tr>
                    </table>
                    <p> </p>
                </div>
                <div id="cocktail-description">
                    <h2>설명</h2>
                    <p>${cocktail.cocktailContent}</p>
                </div>
            </div>
        </div>
        <div id="cocktail-recipe">
            <h2>레시피</h2>
            <p>${cocktail.recipeContent}</p>
            <ul>
                <c:forEach var="cktl" items="${cocktail.recipe}">
                    <li>
                        <div><img src="${contextPath}${cktl.key.type.imagePath}" alt="${cktl.key.type.name}"></div>&nbsp;
                        <div>
                            <p>${cktl.key.name}</p>
                            <p>${cktl.value}</p>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<jsp:include page="/WEB-INF/views/common/modal.jsp"/>
    <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
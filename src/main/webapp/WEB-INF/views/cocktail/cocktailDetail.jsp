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
                <img src="${cocktail.imagePath}">
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
                <div id="divider"></div>
                <div id="cocktail-recipe">
                    <h2>레시피</h2>
                    <ul>
                        <li>
                            <div><img src="${contextPath}/resources/images/ingredient/base.png"></div>&nbsp;
                            <div>
                                <p>런던 드라이 진</p>
                                <p>45 ml(1.5 온스)</p>
                            </div>
                        </li>
                        <li>
                            <div><img src="${contextPath}/resources/images/ingredient/juice.png"></div>&nbsp;
                            <div>
                                <p>스위트 베르무트</p>
                                <p>45 ml(1.5 온스)</p>
                            </div>
                        </li>
                        <li>
                            <div><img src="${contextPath}/resources/images/ingredient/garnish.png"></div>&nbsp;
                            <div>
                                <p>룩사르도 마라스키노</p>
                                <p>1 티스푼</p>
                            </div>
                        </li>
                        <li>
                            <div><img src="${contextPath}/resources/images/ingredient/etc.png"></div>&nbsp;
                            <div>
                                <p>앙고스투라 비터</p>
                                <p>2 대시</p>
                            </div>
                        </li>
                    </ul>
                    <p>${cocktail.recipeContent}</p>
                </div>
            </div>

        </div>
        <div id="page-divider"></div>
        <div id="cocktail-description">
            <h2>설명</h2>
            <p>${cocktail.cocktailContent}</p>
        </div>
        <div id="cocktail-page">
            <p>다음 칵테일  이전 칵테일  목록으로</p>
        </div>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<jsp:include page="/WEB-INF/views/common/modal.jsp"/>
    <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
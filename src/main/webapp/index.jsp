<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mixology Connect</title>
    <link rel="stylesheet" href="resources/css/main-style.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/nav.jsp"/>
    <main class="themes-main-1">
        <div id="banner">
            <p>
                THIS IS BANNER<br>
                THIS IS BANNER<br>
                THIS IS BANNER
            </p>
        </div>
        <div id="populars" class="contents">
            <p class="themes-content-1">Populars</p>
            <p class="themes-content-1">인기글</p>
        </div>
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script src="resources/js/main.js?v=1"></script>
</body>
</html>
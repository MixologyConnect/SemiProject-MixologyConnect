<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer>
    <div id="footer-top">
        <a>이용약관</a>
        <a>개인정보처리방침</a>
        <a>청소년보호정책</a>
        <a>고객센터</a>
    </div>
    <div id="footer-bottom">
        <p>&copy; 2023. Javaba All rights reserved.</p>
    </div>
</footer>

<c:if test="${!empty sessionScope.message}">
	<script>alert("${message}");</script>
	<c:remove var="message" scope="session"/>
</c:if>
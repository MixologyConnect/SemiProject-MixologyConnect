<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="account">
	<div>
	    <input type="checkbox" id="input-account">
	    <label for="input-account"><img src="https://i.ibb.co/hdK6rgX/keyhole.png"></label>
	    <p>LOGIN</p>
	</div>
</div>
<nav>
    <div id="nav-top">
        <img src="https://i.ibb.co/9ZDf4Jk/logo.png">
        <p>Mixology Connect</p>
    </div>
    <div id="nav-bottom">
        <section>
            <div><a class="nav-link">안내</a></div>
            <div><a class="nav-link">칼럼</a></div>
            <div><a href="${contextPath}/board/boardAll" class="nav-link">커뮤니티</a></div>
            <div><a class="nav-link">칵테일</a></div>
            <div><a class="nav-link">테스트</a></div>
        </section>
    </div>
</nav>
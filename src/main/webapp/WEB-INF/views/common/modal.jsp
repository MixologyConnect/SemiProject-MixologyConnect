<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="overlay">
    <div id="modal-account">
        <form id="modal-account-form" action="${contextPath}/member/login" method="post">
            <img id="modal-account-logo" src="${contextPath}/resources/images/logo2.svg">
            <p id="modal-account-head">Mixology Connect</p>
            <p id="modal-account-login">로그인</p>
            <input class="modal-account-input" name="inputId" type="text" placeholder="ID">
            <input class="modal-account-input" name="inputPw" type="password" placeholder="PW">
            <button id="modal-account-button">LOGIN</button>
        </form>
    </div>
</div>
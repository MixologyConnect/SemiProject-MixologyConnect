<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="overlay">
    <div id="modal">
        <form id="modal-login-form" action="${contextPath}/member/login" method="post">
            <img id="modal-login-logo" src="${contextPath}/resources/images/logo2.svg">
            <p id="modal-login-head">Mixology Connect</p>
            <h3>로그인</h3>
            <input class="modal-login-input" name="inputId" type="text" placeholder="ID">
            <input class="modal-login-input" name="inputPw" type="password" placeholder="PW">
            <span>아이디 저장</span><input type="checkbox">
            <span>아직 회원이 아니신가요?</span>&nbsp;<a>회원가입</a>
            <button id="modal-login-button">LOGIN</button>
        </form>
        <form id="modal-signup-form" action="signUp" method="post" name="signUp-form" onsubmit="return signValidate()">
            <fieldset>
                <h2>회원가입</h2>
                <p>회원가입 후 회원들과 소통해보세요.</p>
                <p class="w-pct60 right" style="margin: 0 auto; padding-bottom: 5px; font-size: 13px;">* 는 필수 입력 항목입니다.</p>
                <table>
                    <tr>
                        <td>*성명</td>
                        <td></td>
                        <td> 
                            <input type="text" id="memberName" name="memberName" class="chk size1" maxlength="10"
                                class="size" placeholder="성명" required>
                            <div class="signUp-message" id="memberNameMessage">이름을 입력해주세요</div>
                        </td>
                    </tr>
                    <tr>
                        <td>*아이디</td>
                        <td></td>
                        <td>
                            <div id="info_id">
                                <input type="text" id="memberId" name="memberId" class="chk size1" 
                                    maxlength="20" placeholder="아이디" required>
                                    <button id="btn-id" class="btn-fill-s" type="button"> 중복검사</button>
                            </div>
                            <div class="signUp-message" id="idMessage" >아이디를 입력하세요.(영어 대소문자, 숫자 입력 가능) </div>
                        </td>
                    </tr>
                    <tr>
                        <td>*비밀번호 </td>
                        <td></td>
                        <td>
                            <input type="password" id="memberPw" name="memberPw" placeholder="비밀번호" maxlength="30" class="chk size" autocomplete="off">
                        </td>
                    </tr>
                    <tr>
                        <td>*비밀번호 확인</td>
                        <td></td>
                        <td>
                            <input type="password" name="memberPwConfirm" id="memberPwConfirm" placeholder="비밀번호확인" class="chk size" maxlength="30" autocomplete="off">
                            <div class="signUp-message" id="pwMessage">영어, 숫자,특수문자(!,@,#,-,_) 6~30글자 입력해주세요</div>
                        </td>
                    </tr>
                    <tr>
                        <td>*전화번호</td>
                        <td></td>
                        <td>
                            <input type="text" id="memberTel" name="memberTel"placeholder="(-없이 숫자만 입력)" maxlength="11" required>
                            <div class="signUp-message" id="telMessage">전화번호을 입력하세요</div>
                        </td>
                    </tr>
                    <tr>
                        <td>*이메일</td>
                        <td></td>
                        <td>
                            <input type="text" name="memberEmail" id="memberEmail" class="chk size" placeholder="이메일" required>
                            <div class="signUp-message" id="emailMessage">이메일을 입력해 주세요.</div>
                        </td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td></td>
                        <td>
                            <div id="info-postNum">
                                <input type="text" id="sample6_postcode" name="memberAddress" placeholder="우편번호" readonly>
                                <input type="button" id="postBtn" onclick="sample6_execDaumPostcode()" name="btn-fill-s" value="우편번호찾기"><br>
                            </div>
                            <input type="text" id="sample6_address" name="memberAddress" placeholder="주소" readonly><br>
                            <input type="text" id="sample6_detailAddress" name="memberAddress" placeholder="상세주소" >
                            <input type="text" id="sample6_extraAddress" name="memberAddress" placeholder="참고항목" readonly>
                            <!-- <button id="postBtn" class="btn-fill-s" onclick="postNum">우편번호 찾기</button>
                            <input type="text" name="postNum" class="w-px60" readonly>
                            <input type="text" name="address" readonly>
                            <input type="text" name="address"> -->
                        </td>
                    </tr>
                </table>
            </fieldset>
            <div class="btn-area">
                <button type="reset" id="resetBtn">회원가입 취소</button>
                <button id="signUp-btn" type="submit">회원가입</button>
            </div>
        </form>
    </div>
</div>

<input type="checkbox" id="theme-switch-cbox">
<label for="theme-switch-cbox">
    <div id="theme-switch">
        <img>
    </div>
</label>

<c:if test="${!empty sessionScope.message}">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session"/>
</c:if>
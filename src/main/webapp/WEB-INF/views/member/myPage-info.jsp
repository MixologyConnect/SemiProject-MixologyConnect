<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%--문자열 관렬 함수(메소드) 제공 JSTL (EL형식) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지 정보수정</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-info.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="main">
        <section class="left-side">
            <p>마이페이지 </p>
    
            <ul  class="list-group">
               
                <li> <a href="${contextPath}/member/myPage/profile">프로필 수정</a></li>
                <li> <a href="${contextPath}/member/myPage/info">내 정보 수정</a></li>
                <li> <a href="${contextPath}/member/myPage/secession">회원 탈퇴</a></li>
                
            </ul>
    
        </section>
        
        <section class="myInfo-area">
            <article>
                <h3>회원 정보 수정하기</h3>
                <p>회원님의 개인 정보를 수정할 수 있습니다.</p>
            </article>
            
            <form action="info" method="post" name="myPage-form" onsubmit="return myInfoValidate()">
                <fieldset>
                    <table>
                        <tr>
                            <td>성명</td>
                            <td></td>
                            <td> 
                                <input id="memberName" name="memberName" type="text" class="size" value="${loginMember.memberName}">
                            </td>
                        </tr>
                        
                        <tr>
                            <td>전화번호</td>
                            <td></td>
                            <td>
                                <input type="text" name="memberTel" maxlength="11" value="${loginMember.memberTel}" placeholder="(-)기호를 제외해주세요"> 
                                
                            </td>
                        </tr>
                    
                    
                        <tr>
                            <!--주소-->				<!-- fn:split(문자열,'구분자') -->
                    		<c:set var="addr" value="${fn:split(loginMember.memberAddress,',,') }"/>
                    
                            <td>주소</td>
                            <td></td>
                            <td>
                                <input type="text" id="sample6_postcode" name="memberAddress" value="${addr[0]}" readonly>
                                <input type="button" id="postBtn" onclick="sample6_execDaumPostcode()" name="btn-fill-s" value="우편번호 찾기"><br>
                                <input type="text" id="sample6_address" name="memberAddress" value="${addr[1]}" readonly><br>
                                <input type="text" id="sample6_detailAddress" name="memberAddress" value="${addr[2]}">
                                <input type="text" id="sample6_extraAddress" name="memberAddress" value="${addr[3]}" readonly>
                                <!-- <button id="postBtn" class="btn-fill-s" onclick="postNum">우편번호 찾기</button>
                                <input type="text" name="postNum" class="w-px60" readonly>
                                <input type="text" name="address" readonly>
                                <input type="text" name="address"> -->
                            
                            </td>
        
                        </tr>
                        
                    </table>    
            
                </fieldset>
                
                <div class="btn-area">
                    
                    <button id="info-update-btn" >수정 완료</button>
            
                </div>
            </form>
            <br>
            <article>
                <h3>비밀번호 변경</h3>
                <p>비밀번호 변경을 할 수 있습니다.</p>
            </article>

            <form action="changePw" method="post"  onsubmit="return changePwValidate()">
                <fieldset>
                    <table>
                        
                        <tr>
                            <td>비밀번호 변경</td>
                            <td></td>
                            <td>
                                <input type="password" id="currentPw" name="currentPw" placeholder="기존 비밀번호"   maxlength="30">
                                <input type="password" id="newPw" name="newPw" placeholder="새로운 비밀번호"   maxlength="30">
                                <input type="password" name="newPwconfirm" id="newPwconfirm" placeholder="새로운 비밀번호 확인"  maxlength="30">
                                <div id="pwMessage">영문 대/소문자 숫자를 포함해서 8자 이상을 입력하세요</div>
                            </td>

                        </tr>

                    </table>
                </fieldset>
                <div class="btn-area">
                    <button id="changePw-btn">비밀번호 변경</button>
                </div>
            </form>
        </section>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/common/modal.jsp"/>
    <!-- ----------------------------------------------------------------------------- -->
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	<!-- 다음 우편번호 api -->
    
    <script src="${contextPath}/resources/js/myPage-info.js"></script>
</body>
</html>
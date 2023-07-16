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
    <link rel="stylesheet" href="resources/css/myPage-info.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>

	<div id="main">
        <section class="left-side">
            <p>마이페이지 </p>

            <ul  class="list-group">
                <li><a href="#">내 피드</a></li>
                <li> <a href="#">프로필 수정</a></li>
                <li> <a href="#">내 정보 수정</a></li>
                <li> <a href="#">회원 탈퇴</a></li>
             
            </ul>

        </section>

        

        <section class="myInfo-area">
            <h3>회원 정보 수정</h3>
            <form action="#" method="post" name="myPage-form">
                <fieldset>
                
                    <table>
                        <tr>
                            <td>성명</td>
                            <td></td>
                            <td> 
                                <input id="memberName" name="memberName" type="text" class="size" value="로그인 회원의 이름">
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호 변경</td>
                            <td></td>
                            <td>
                                <input type="password" id="currentPw" name="currentPw" placeholder="기본 비밀번호"   maxlength="30">
                                
                                <input type="password" id="newPw" name="newPw" placeholder="새로운 비밀번호"   maxlength="30">
                                <input type="password" name="newPwconfirm" id="newPwconfirm" placeholder="새로운 비밀번호 확인"  maxlength="30">
                                <div id="pwMessage">영문 대/소문자 숫자를 포함해서 8자 이상을 입력하세요</div>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>전화번호</td>
                            <td></td>
                            <td>
                                <input type="text" name="memberTel" maxlength="" value="010"> -
                               
                            </td>
                        </tr>
                    
                    
                        <tr>
                            
                            <td>주소</td>
                            <td></td>
                            <td>
                                <input type="text" id="sample6_postcode" name="memberaddress" value="우편번호">
                                <input type="button" id="postBtn" onclick="sample6_execDaumPostcode()" name="btn-fill-s" value="우편번호 찾기"><br>
                                <input type="text" id="sample6_address" name="memberaddress" value="주소"><br>
                                <input type="text" id="sample6_detailAddress" name="memberaddress" value="상세주소">
                                <input type="text" id="sample6_extraAddress" name="memberaddress" value="참고항목">
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
        </section>
    </div>





	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>
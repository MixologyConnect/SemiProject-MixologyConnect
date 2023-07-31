<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 회원 게시글 관리</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/manager.css">
    <script src="https://kit.fontawesome.com/b5c2a13e26.js" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

   
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div id="main">
        
        <section class="left-side">
            <span><b>관리자페이지</b></span>
            
            <ul  class="list-group">
                <li> <a href="#">회원 및 게시글 관리 </a></li>
                <li> <a href="#">공지사항 관리</a></li>
                
            </ul>
            
        </section>
        
        <!-- section 나누는 div -->
        <div class="section-d">

        
        
        <section class="manager-area1">
            
            <h3>회원 관리</h3>
            
            <!-- 회원관리 검색 창 -->

            <div class="searchArea">
                
                <input type="text" id="searchMember" name="search" 
                placeholder="회원아이디 검색" autocomplete="off">
                
                <button type="submit" id="member-btn" class="fa-solid fa-magnifying-glass"></button>
            </div>
            
            <form action="#" method="" name="manager-member">
                <table>
                
                    <tr>
                        <!-- 전체 선택 체크 박스 -->
                        <th ></th>
                        <th >번호</th>
                        <th >아이디</th>
                        <th >이름</th>
                        <th >전화번호</th>
                        <th >주소</th>
                        <th >탈퇴여부</th>
                    </tr>
                        
                    <tbody id="resultMember">

                    </tbody>
                
                </table>
                <!-- typw="submit" id="borderbtn" -->
                <button type="button" onclick="selectMember()" >회원 탈퇴</button>
                <div id="result1"></div>
            </form>



        </section>


        <section class="manager-area1">
                <br><br>
                <h3>게시글 관리</h3>

            <div class="searchArea">
                
                <input type="text" id="searchBoard" name="search1" 
                placeholder="게시글 검색" autocomplete="off">
                
                <button type="submit" id="board-btn" class="fa-solid fa-magnifying-glass"></button>
            </div>
        
            <form action="#" method="" name="manager-board">
                <table>
                
                    <tr>
                        <!-- 전체 선택 체크 박스 -->
                        <th ></th>
                        <th >게시글 번호</th>
                        <th >게시글 제목</th>
                        <th >아이디</th>
                        <th >전화번호</th>
                        <th >게시글 작성일</th>
                        <th >게시글 삭제 여부</th>
                    </tr>
                    

                    
                    <tr id="resultBoard">
                        <td ><input type="checkbox" name="chk2"></td >
                        <td ><div class="memberNo">1</div></td >
                        <td > <div class="memberId">user01</div></td>
                        <td > <div class="memberName">유저일</div></td>
                        <td > <div class="memberTel">01012345678</div></td>
                        <td > <div class="enrollDate">2023-07-12</div></td >
                        <td > <div class="secession">N</div></td >
                    </tr>
                    <tr>
                        <td ><input type="checkbox" name="chk"></td >
                        <td ><div class="memberNo">1</div></td >
                        <td > <div class="memberId" name="memberId">user01</div></td>
                        <td > <div class="memberName">유저일</div></td>
                        <td > <div class="memberTel">01012345678</div></td>
                        <td > <div class="enrollDate">2023-07-12</div></td >
                        <td > <div class="secession">N</div></td >
                    </tr>
                    <tr>
                        <td ><input type="checkbox" name="chk"></td >
                        <td ><div class="memberNo">1</div></td >
                        <td > <div class="memberId" name="memberId">user01</div></td>
                        <td > <div class="memberName">유저일</div></td>
                        <td > <div class="memberTel">01012345678</div></td>
                        <td > <div class="enrollDate">2023-07-12</div></td >
                        <td > <div class="secession">N</div></td >
                    </tr>
                
                    
                </table>
                
                
                
                <!-- typw="submit" id="borderbtn" -->
                <button type="button" onclick="selectMember()" >회원 탈퇴</button>
                <div id="result2"></div>

            </form>
        </section>



            

        </div>
        
    </div>


    <script src="${contextPath}/resources/js/manager.js"></script>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
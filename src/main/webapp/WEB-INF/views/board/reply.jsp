<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <form action="../myPage/userPage" method="post">

    
    <div id="reply-area">
        <!-- 댓글 목록 -->
        <div class="reply-klist-area">
            
            <ul id="reply-list">
                
                    <c:forEach var="reply" items="${rList}">

                        <li class="reply-row">
                            <p class="reply-writer">
                                    <input type="hidden" name="memberNo" value="${detail.memberNo}">
                                <c:if test="${empty reply.profileImage}">
                                    <!-- 프로필 이미지가 없을 경우 -->
                                    <img src="${contextPath}/resources/images/user.png" onclick="submit()">
                                </c:if>

                                <c:if test="${!empty reply.profileImage}"> 
                                    <!-- 프로필 이미지가 있을 경우 -->
                                    <img src="${contextPath}${reply.profileImage}" onclick="submit()">
                                </c:if>
                                <span class="memberName">${reply.memberName}</span>
                                <span class="reply-date">${reply.replyDate}</span>
                            </p>
                            
                            <p class="replycontent">${reply.replyContent}</p>
                            
                            <c:if test="${loginMember.memberNo == reply.memberNo}">
                                <div class="reply-btn-area">
                                    <button type="button" onclick="showUpdateReply(${reply.replyNo}, this)">수정</button>
                                    <button type="button" onclick="deleteReply(${reply.replyNo})">삭제</button>
                                </div>
                            </c:if>
                        </li>
                    </c:forEach>
                   
                </ul>
            </div>
            
        </form>
            <!-- 댓글 작성 부분 -->
            <div class="reply-writer-area">
                <textarea id="replyContent"></textarea>
                <button id="addBtn" type="button">
                    댓글 등록
                </button>
            </div>


        </div>


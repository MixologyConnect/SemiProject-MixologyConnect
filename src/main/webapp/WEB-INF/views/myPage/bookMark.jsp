<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>북마크</title>

    <link href="https://fonts.cdnfonts.com/css/segoe-ui-4" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/bookMark.css">

    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>
    <script src="../js/jquery-3.7.0.min.js"></script>

</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <section class="board-list">
        <h1 class="board-name">북마크</h1>

        <div class="list-wrapper">
            <table class="list-table">
                <thead>
                    <tr>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>

                    <tr>
                        <td>10</td>
                        <td>
                            <a href="#">10번째 게시글</a>
                        </td>
                        <td>유저일</td>
                        <td>2023-07-17</td>
                        <td>50</td>
                    </tr>
                </tbody>
            </table>
        </div>


        <div class="pagination-area">
            <ul class="pagination">
                <li><a href="#">&lt;&lt</a></li>
                <li><a href="#">&lt;</a></li>

                <li><a class="current">1</a></li>

                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">6</a></li>
                <li><a href="#">7</a></li>
                <li><a href="#">8</a></li>
                <li><a href="#">9</a></li>
                <li><a href="#">10</a></li>

                <li><a href="#">&gt;</a></li>
                <li><a href="#">&gt;&gt;</a></li>
            </ul>
        </div>

        <form action="#" method="get" id="boardSearch">

            <select name="key">
                <option value="t">제목</option>
                <option value="c">내용</option>
                <option value="tc">제목+내용</option>
                <option value="w">작성자</option>
            </select>

            <input type="text" name="query" placeholder="검색어를 입력해주세요.">

            <button>검색</button>
        </form>
        

    </section>

     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="../js/bookmark.js"></script>
    
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: leeym
  Date: 2025. 11. 21.
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@page import ="org.example.project22.dao.BoardDAO, org.example.project22.bean.BoardVO, java.util.*" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" />
<%
    BoardDAO boardDAO = new BoardDAO();
    List<BoardVO> list = boardDAO.getBoardList();
    request.setAttribute("list",list);
%>
<div class="container">
    <h2 class="my-4">JSP 게시판</h2>

    <table class="table table-hover text-center" id = "list">
        <thead class="table-dark">
        <tr>
            <th>번호</th>
            <th>ID</th>
            <th>성</th>
            <th>이름</th>
            <th>나이</th>
            <th>성별</th>
            <th>직업</th>
            <th>날짜</th>
            <th>삭제</th>
            <th>수정</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items = "${list}" var = "u" varStatus = "status">
            <tr>
                <td>${status.count}</td>
                <td>${u.getId()}</td>
                <td>${u.getFirstname()}</td>
                <td>${u.getLastname()}</td>
                <td>${u.getAge()}</td>
                <td>${u.getGender()}</td>
                <td>${u.getOccupation()}</td>
                <td>${u.getRegdate()}</td>
                <td><a href="delete_ok.jsp?id=${u.id}">Delete</a></td>
                <td><a href="edit_ok.jsp?id=${u.id}">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="d-flex justify-content-end">
        <a href="write.jsp" class="btn btn-primary">새 고객 추가하기</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<jsp:include page="footer.jsp" />
</body>
</html>
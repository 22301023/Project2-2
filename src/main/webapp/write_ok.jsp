<%@ page import="org.example.project22.dao.BoardDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="u" class="org.example.project22.bean.BoardVO" />
<jsp:setProperty name="u" property="*"/>

<%
    BoardDAO boardDAO = new BoardDAO();
    int i = boardDAO.insertBoard(u);
    String msg = "데이터 추가 성공";
    if(i == 0) msg = "데이터 추가 실패";
%>

<script>
    alert('<%=msg%>');
    location.href='list.jsp';
</script>

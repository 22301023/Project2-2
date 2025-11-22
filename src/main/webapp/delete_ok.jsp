<%@ page import="org.example.project22.dao.BoardDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(request.getParameter("id"));

    BoardDAO boardDAO = new BoardDAO();
    int i = boardDAO.deleteByID(id);
    String msg = "데이터 삭제 성공";
    if(i == 0) msg = "데이터 삭제 실패";
%>

<script>
    alert('<%=msg%>');
    location.href='list.jsp';
</script>

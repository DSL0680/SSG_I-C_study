<%@ page import="org.example.w1.menu.MenuService" %>
<%@ page import="org.example.w1.menu.MenuVO" %>
<%@ page import ="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-07-22
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<MenuVO> menuVOList = MenuService.INSTANCE.getMenus();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    .menulist {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        gap: 1em;
    }
    .menulist li {
        list-style: none;
    }
    .menulist li img {
        width: 10vw;
        min-width: 200px;
    }
</style>

<ul class="menulist">
<% for (int i = 0; i < menuVOList.size(); i++) {

    MenuVO menuVO = menuVOList.get(i);
    String imgName = "/img/img"+i+".jpg";

    String alink = "/menu/detail.jsp?no="+i;

%>
    <li>
        <div>
            <a href="<%=alink%>">
        <img src="<%=imgName%>">
            </a>
            <span><%=menuVO.getName()%> <%=menuVO.getPrice()%> </span>
        </div>
    </li>
<% } %>
</ul>

</body>
</html>

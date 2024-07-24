<%@ page import="org.example.w1.menu.MenuService" %>
<%@ page import="org.example.w1.menu.MenuVO" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-07-22
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String noStr = request.getParameter("no");
    //문자를 숫자로
    Integer no = Integer.parseInt(noStr);

    MenuVO menuVO = MenuService.INSTANCE.getMenuById(no);
%>

<%@include file="../includes/header.jsp"%>>

    <h1><%= menuVO.getNo()%></h1>
    <h1><%= menuVO.getName()%></h1>
    <h1><%= menuVO.getPrice()%></h1>

    <form action="/cart/addCart.jsp" method="post">

        <input name="no" type="hidden" value="123">

        <button>ADD Cart</button>

    </form>

<%@include file="../includes/footer.jsp"%>>

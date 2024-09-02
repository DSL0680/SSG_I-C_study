<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-07-23
  Time: 오후 5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul class="menulist">
    <% for(int i =1; i< todoList.size(); i++){ //테이블에서 들고온 내용이 들어갈 예정

        Todo todo = todoList.get(i);
        String alink = "/todo/detail.jsp?no="+todo.list_id; //테이블에서 들고온 해당 열의 인덱스
    %>
    <li>
        <div>
            <a href="<%=alink%>">
                <h1><%=todoList.getHeader%></h1>
            </a>
        </div>
    </li>
    <% } %>

</ul>
</body>
</html>
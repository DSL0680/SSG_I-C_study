<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp" %>

${nums}

<h1>Todo List Page</h1>
// JSTL XXS
<c:out value="${tag}"/>

<ul>
    <c:forEach items="${nums}" var="num">
        <li>AAA ${num} </li>
    </c:forEach>
</ul>

<%@include file="../includes/footer.jsp" %>

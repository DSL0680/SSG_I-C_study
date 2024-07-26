<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp" %>

<h1>Todo List Page</h1>

<ul>
    <c:forEach items="${list}" var="todo">
        <li>
            <div>
                <div>${todo.tno}</div>
                <div>${todo.title}</div>
            </div>
        </li>
    </c:forEach>
</ul>
<ul class="pagination">
    <c:if test="${pageInfo.prev}">
    <li class="page-item"><a class="page-link" href="/todo/list?page=${pageInfo.start - 1}">Prev</a></li>
    </c:if>

    <c:forEach begin="${pageInfo.start}" end="${pageInfo.end}" var="num">
        <li class="page-item ${pageInfo.page == num ? 'active':''}"><a class="page-link" href="/todo/list?page=${num}">${num}</a></li>
    </c:forEach>

    <c:if test="${pageInfo.next}">
    <li class="page-item"><a class="page-link" href="/todo/list?page=${pageInfo.end + 1}">Next</a></li>
    </c:if>
</ul>


<%--// JSTL XXS--%>
<%--<c:out value="${tag}"/>--%>

<%--<ul>--%>
<%--    <c:forEach items="${nums}" var="num">--%>
<%--        <li>AAA ${num} </li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>

<%@include file="../includes/footer.jsp" %>

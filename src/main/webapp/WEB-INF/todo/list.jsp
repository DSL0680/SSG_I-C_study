<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../includes/header.jsp" %>

<html>
<head>
    <!-- Bootstrap CSS 포함 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<header class="bg-dark text-white text-center py-3">
    <h1>Todo List Page</h1>
</header>

<div class="container mt-4">


    <a href="/todo/register" class="btn btn-primary mb-3">Todo Register</a>

    <c:if test="${param.tno != null || param.result}">
        <div class="msg alert alert-info text-center">
            <h1>처리 결과 입니다.</h1>
        </div>
    </c:if>

    <ul class="list-group">
        <c:forEach items="${list}" var="todo">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <span>${todo.tno}</span>
                <a href="/todo/get?tno=${todo.tno}">${todo.title}</a>
            </li>
        </c:forEach>
    </ul>

    <nav aria-label="Page navigation" class="mt-4">
        <ul class="pagination justify-content-center">
            <c:if test="${pageInfo.prev}">
                <li class="page-item"><a class="page-link" href="/todo/list?page=${pageInfo.start - 1}">Prev</a></li>
            </c:if>

            <c:forEach begin="${pageInfo.start}" end="${pageInfo.end}" var="num">
                <li class="page-item ${pageInfo.page == num ? 'active' : ''}">
                    <a class="page-link" href="/todo/list?page=${num}">${num}</a>
                </li>
            </c:forEach>

            <c:if test="${pageInfo.next}">
                <li class="page-item"><a class="page-link" href="/todo/list?page=${pageInfo.end + 1}">Next</a></li>
            </c:if>
        </ul>
    </nav>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>Footer Section</p>
</footer>

<%@ include file="../includes/footer.jsp" %>



<!-- Bootstrap JS와 Popper.js 포함 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    window.onload = function() {
        // Show the div when the page loads
        document.querySelector('.msg alert alert-info text-center').style.display = 'block';
    };
</script>
</body>
</html>

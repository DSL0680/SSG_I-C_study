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
    <h1>Get Page</h1>
</header>

<div class="container mt-4">


    <div class="card mb-3">
        <div class="card-body">
            <p class="card-text">${todo}</p>
            <a href="/todo/edit?tno=${todo.tno}" class="btn btn-primary">Modify/Delete</a>
        </div>
    </div>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>Footer Section</p>
</footer>

<%@ include file="../includes/footer.jsp" %>

<!-- Bootstrap JS와 Popper.js 포함 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

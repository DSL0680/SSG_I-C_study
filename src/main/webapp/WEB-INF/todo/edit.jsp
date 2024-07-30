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
    <h1>Edit Page</h1>
</header>

<div class="container mt-4">


    <div class="card mb-3">
        <div class="card-body">
            <p class="card-text">${todo}</p>

            <form action="/todo/edit" method="post">
                <div class="form-group">
                    <label for="tno">TNO</label>
                    <input type="text" id="tno" name="tno" class="form-control" value="${todo.tno}" readonly>
                </div>
                <div class="form-group">
                    <label for="title">TITLE</label>
                    <input type="text" id="title" name="title" class="form-control" value="${todo.title}">
                </div>
                <div class="form-group">
                    <label for="writer">WRITER</label>
                    <input type="text" id="writer" name="writer" class="form-control" value="${todo.writer}">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">MODIFY</button>
                </div>
            </form>

            <form action="/todo/remove" method="post" class="mt-3">
                <input type="hidden" name="tno" value="${todo.tno}">
                <button type="submit" class="btn btn-danger">REMOVE</button>
            </form>
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

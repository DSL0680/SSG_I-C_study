<%@include file="../includes/header.jsp"%>

<html>
<head>
    <!-- Bootstrap CSS 포함 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<header class="bg-dark text-white text-center py-3">
    <h1>Todo Register Page</h1>
</header>

<div class="container mt-4">
    <div class="card" style="margin: 3em">
        <div class="card-header">
            <h3>Todo Register Page</h3>
        </div>
        <div class="card-body">
            <form action="/todo/register" method="post">
                <div class="mb-3">
                    <label class="form-label">Title</label>
                    <input type="text" name="title" class="form-control" placeholder="Enter the title">
                </div>
                <div class="mb-3">
                    <label class="form-label">Writer</label>
                    <input type="text" name="writer" class="form-control" placeholder="Enter the writer">
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-primary">SAVE</button>
                </div>
            </form>
        </div>
    </div>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>Footer Section</p>
</footer>

<%@include file="../includes/footer.jsp"%>

<!-- Bootstrap JS와 Popper.js 포함 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

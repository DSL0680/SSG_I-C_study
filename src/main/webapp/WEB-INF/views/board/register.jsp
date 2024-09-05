<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-09-04(수)
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/board/register" method="post" enctype="multipart/form-data">
    <div>
        title: <input type="text" name="title">
    </div>

    <div>
        content: <input type="text" name="content">
    </div>

    <div>
        writer: <input type="text" name="writer">
    </div>

    <div>
       file: <input type="file" name="files" multiple>
    </div>

    <div>
        <button>SUBMIT</button>
    </div>
</form>

</body>
</html>

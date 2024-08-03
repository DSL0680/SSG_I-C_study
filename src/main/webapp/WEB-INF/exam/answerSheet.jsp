<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    Answer Sheet
</div>


<p>${answerMap} </p>


<ul>
    <c:forEach items="${answerMap}" var="answer">

        <li>
            <a onclick="move(${answer['key']})"> ${answer['key']}번 </a>
            <input type="text" readonly value="${answer['value']} "></input>
        </li>
    </c:forEach>
</ul>

<script>

    const move = (quizNum) => {

        parent.move(quizNum)

    }

</script>


</body>
</html>

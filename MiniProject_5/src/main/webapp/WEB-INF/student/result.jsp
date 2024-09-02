<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.example.miniproject_5.dao.StudentAnswerDAO" %>
<%@ page import="org.example.miniproject_5.vo.StudentAnswerVO" %>

<html>
<head>
    <title>Exam Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        .title {
            font-size: 24px;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        .result {
            margin-bottom: 20px;
        }
        .result h3 {
            margin: 0;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f3e8c2;
        }
        .btn-custom {
            background-color: #f3e8c2;
            color: #333;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
        .btn-custom:hover {
            background-color: #f6e5ae;
        }
        h3 {
            background-color: #f3e8c2;
            display: inline-block;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="title">Exam Result</div>
    <div class="result">
        <h3>Your Score: ${score}</h3>
    </div>
    <div class="title">Your Answers</div>
    <table>
        <thead>
        <tr>
            <th>Question No</th>
            <th>Your Answer</th>
            <th>Result</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${answerList}" var="answer">
            <tr>
                <td>${answer.qno}</td>
                <td><input type="text" readonly value="${answer.checkedNum}" /></td>
                <td>
                    <c:if test="${answer.correct}">
                        Correct
                    </c:if>
                    <c:if test="${!answer.correct}">
                        Incorrect
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!--시험 목록으로 돌아가기-->
    <a href="${pageContext.request.contextPath}/student/examList" class="btn-custom">Back to Exam List</a>
</div>

</body>
</html>

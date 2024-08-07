<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exam View</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 1200px;
            margin-top: 30px;
        }
        .exam-title {
            margin-bottom: 30px;
        }
        .exam-content {
            padding: 20px;
            width: calc(100% - 320px); /* Adjust to fit the answer sheet width */
        }
        .answer-sheet {
            width: 300px; /* Adjust width as needed */
            border-left: 1px solid black;
            padding: 10px;
            background-color: #f9f9f9;
            height: 100vh; /* Full viewport height */
            overflow: auto;
        }
        iframe {
            width: 100%;
            height: 100%;
            border: none;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }
        .question-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            padding: 10px;
            border-bottom: 1px solid #e1e1e1;
        }
        .question p {
            font-weight: bold;
        }
        .submit-button, .action-button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
        .question-table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f3e8c2;
        }
        .submit-button, .btn-custom {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
            border: none;
        }
        .submit-button {
            background-color: #b39e56;
            margin-left: auto; /* Push button to the right */
            display: block; /* Ensure the button is on a new line */
        }
        .submit-button:hover {
            background-color: #b39e56; /* Darker shade for hover effect */
        }
        .btn-custom {
            background-color: #b39e56; /* Same color for both buttons */
        }
        .btn-custom:hover {
            background-color: #b39e56; /* Darker shade for hover effect */
        }
        /* Styling for the <h1> element */
        h1 {
            font-size: 2.5rem; /* Adjust font size */
            font-weight: bold; /* Make text bold */
            color: #333; /* Dark color for contrast */
            margin: 20px 0; /* Add top and bottom margin */
            padding: 10px; /* Add some padding */
            background-color: #f3f9f3; /* Light background color */
            border-radius: 5px; /* Rounded corners */
            display: flex; /* Use flexbox for alignment */
            align-items: center; /* Center align items vertically */
        }
        .exam-label {
            flex: 0 0 auto; /* Allow label to take only as much space as needed */

        }
        .exam-name {
            flex: 0.85; /* Allow exam name to take up the remaining space */
            text-align: center; /* Center align the exam name */
        .submit-button:hover, .action-button:hover {
            background-color: #218838;
        }
        .answer-sheet {
            position: sticky;
            top: 0;
            height: 100vh;
            background-color: #ffffff;
            padding: 20px;
            border-left: 1px solid #e1e1e1;
            box-shadow: 4px 0 6px rgba(0,0,0,0.1);
        }
        .answer-sheet iframe {
            width: 100%;
            height: 100%;
            border: none;
        }
        .back-link {
            margin-top: 20px;
            display: inline-block;
            font-size: 16px;
        }
        .back-link a {
            text-decoration: none;
            color: #007bff;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>
    <span class="exam-label">Exam:</span>
    <span class="exam-name">${exam.examName}</span>
</h1>

<div class="container">
    <div class="exam-title text-center">
        <h1>${exam.examName}</h1>
    </div>

    <div class="row">
        <div class="col-md-8">
            <div class="exam-content">
                <c:forEach var="quiz" items="${quizzes}">
                    <div class="question">
                        <form method="post" action="${pageContext.request.contextPath}/check/answer" target="answerSheet">
                            <input type="hidden" name="examno" value="${exam.eno}">
                            <input type="hidden" name="qno" value="${quiz.qno}">

                            <p><strong>Q${quiz.qno}:</strong> ${quiz.question}</p>
                            <ul class="list-unstyled">
                                <li><input type="radio" name="answer" value="1"> ${quiz.op1}</li>
                                <li><input type="radio" name="answer" value="2"> ${quiz.op2}</li>
                                <li><input type="radio" name="answer" value="3"> ${quiz.op3}</li>
                                <li><input type="radio" name="answer" value="4"> ${quiz.op4}</li>
                                <c:if test="${not empty quiz.op5}">
                                    <li><input type="radio" name="answer" value="5"> ${quiz.op5}</li>
                                </c:if>
                            </ul>
                            <button type="submit" class="btn submit-button">Submit</button>
                        </form>
                    </div>
                </c:forEach>
    <div class="exam-content">
        <c:forEach var="quiz" items="${quizzes}">
            <table class="question-table">
                <thead>
                <tr>
                    <th>Question ${quiz.qno}</th>
                    <th>Options</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${quiz.question}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/check/answer" target="answerSheet">
                            <input type="hidden" name="examno" value="${exam.eno}">
                            <input type="hidden" name="qno" value="${quiz.qno}">
                            <ul style="list-style-type: none; padding: 0;">
                                <li><input type="radio" name="answer" value="1"> ${quiz.op1}</li>
                                <li><input type="radio" name="answer" value="2"> ${quiz.op2}</li>
                                <li><input type="radio" name="answer" value="3"> ${quiz.op3}</li>
                                <li><input type="radio" name="answer" value="4"> ${quiz.op4}</li>
                                <c:if test="${not empty quiz.op5}">
                                    <li><input type="radio" name="answer" value="5"> ${quiz.op5}</li>
                                </c:if>
                            </ul>
                            <button type="submit">Submit</button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </c:forEach>

                <!-- 전체 시험 제출 버튼 추가 -->
                <form method="post" action="${pageContext.request.contextPath}/exam/submit" id="submitExamForm">
                    <input type="hidden" name="examNum" value="${exam.eno}">
                    <button type="submit" class="btn submit-button">Submit All</button>
                </form>
        <!-- 전체 시험 제출 버튼 추가 -->
        <div style="text-align: right;">
            <form method="post" action="${pageContext.request.contextPath}/exam/submit" id="submitExamForm">
                <input type="hidden" name="examNum" value="${exam.eno}">
                <button type="submit" class="submit-button">Submit All</button>
            </form>
        </div>

                <div class="back-link">
                    <a href="${pageContext.request.contextPath}/student/examList">Back to Exam List</a>
                </div>
            </div>
        </div>
        <br>
        <a href="${pageContext.request.contextPath}/student/examList" class="btn-custom">Back to Exam List</a>
    </div>

        <div class="col-md-4">
            <div class="answer-sheet">
                <iframe name="answerSheet" src="${pageContext.request.contextPath}/exam/answerSheet?examNum=${exam.eno}"></iframe>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.10/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

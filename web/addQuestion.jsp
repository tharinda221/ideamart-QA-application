<%--
  Created by IntelliJ IDEA.
  User: tharinda
  Date: 2/6/17
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Question</title>
</head>
<body>
<form action="/addQuestion" method="POST">
    Enter your Question: <input type="text" name="question" style="font-size:9pt;height:100px;width:400px;" required><br>
    Answer 1: <input type="text" name="ans1" required><br>
    Answer 2: <input type="text" name="ans2" required><br>
    Answer 3: <input type="text" name="ans3" required><br>
    Answer 4: <input type="text" name="ans4" required><br>
    Correct Answer: <input type="text" name="correctAns" required><br>
    <input type="submit" value="Submit">
</form>

<br>
<br>
<a href="/" class="button">Home</a>
</body>
</html>

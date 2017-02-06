<%@ page import="com.ideamart.sample.questionMgt.Answers" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tharinda
  Date: 2/6/17
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        a.button {
            -webkit-appearance: button;
            -moz-appearance: button;
            appearance: button;

            text-decoration: none;
            color: initial;
        }

        td, th {
            width: 4rem;
            height: 2rem;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background: lightblue;
            border-color: white;
        }

        body {
            padding: 1rem;
        }
    </style>
    <title>View Submissions</title>
</head>
<body>
<h2>User Submission</h2>

<form action="/viewSubmissions" method="POST">
    <input type="hidden" name="type" value="time">
    Enter Question ID: <input type="text" name="question" required>
    <input type="submit" value="Get Submissions by Time">
</form>

<form action="/viewSubmissions" method="POST">
    <input type="hidden" name="type" value="count">
    Enter Question ID: <input type="text" name="question" required>
    <input type="submit" value="Get Submissions by Count">
</form>

<%
    Answers answers;
    ArrayList<Answers> list = (ArrayList<Answers>) request.getAttribute("resultList");

    if(list != null) {

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>User Address</th>\n<th>Question Number</th>\n<th>Time</th>\n<th>Count</th>\n");
        out.println("</tr>");
        for (int i = 0; i < list.size(); i++) {
            out.println("<tr>");
            answers = list.get(i);
            out.println("<td>");
            out.println(answers.getAddress());
            out.println("</td>");

            out.println("<td>");
            out.println(answers.getQuestionId());
            out.println("</td>");

            out.println("<td>");
            out.println(answers.getTimestamp());
            out.println("</td>");

            out.println("<td>");
            out.println(answers.getCount());
            out.println("</td>");

            out.println("</tr>");
        }
        out.println("</table>");
    }
%>
<br>
<br>
<a href="/" class="button">Home</a>
</body>
</html>

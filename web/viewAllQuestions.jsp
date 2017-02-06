<%@ page import="com.ideamart.sample.questionMgt.Question" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tharinda
  Date: 2/7/17
  Time: 1:08 AM
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
    <title>View All Questions</title>
</head>
<body>
<%
    Question question;
    ArrayList<Question> list = (ArrayList<Question>) request.getAttribute("questionArrayList");

    if(list != null) {

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Index</th>\n<th>Question</th>\n<th>Correct Answer</th>\n");
        out.println("</tr>");
        for (int i = 0; i < list.size(); i++) {
            out.println("<tr>");
            question = list.get(i);
            out.println("<td>");
            out.println(question.getIndex());
            out.println("</td>");

            out.println("<td>");
            out.println(question.getQuestion());
            out.println("</td>");

            out.println("<td>");
            out.println(question.getCorrectAnswer());
            out.println("</td>");

            out.println("</tr>");
        }
        out.println("</table>");
    }
%>
<br>
<a href="/" class="button">Home</a>
</body>
</html>

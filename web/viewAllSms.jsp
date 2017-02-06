<%@ page import="com.ideamart.sample.questionMgt.SMS" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tharinda
  Date: 2/7/17
  Time: 1:55 AM
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
    <title>view All Sms</title>
</head>
<body>
<%
    SMS sms;
    ArrayList<SMS> list = (ArrayList<SMS>) request.getAttribute("smsArrayList");

    if(list != null) {

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>User address</th>\n<th>Your Message</th>\n<th>Response</th>\n");
        out.println("</tr>");
        for (int i = 0; i < list.size(); i++) {
            out.println("<tr>");
            sms = list.get(i);
            out.println("<td>");
            out.println(sms.getAddress());
            out.println("</td>");

            out.println("<td>");
            out.println(sms.getMesssage());
            out.println("</td>");

            out.println("<td>");
            out.println(sms.getResponse());
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

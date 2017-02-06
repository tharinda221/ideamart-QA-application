<%--
  Created by IntelliJ IDEA.
  User: tharinda
  Date: 12/28/16
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ideamart.sample.usermgt.UserDAO" %>
<%@ page import="com.ideamart.sample.dashboardMgt.DashboardDAO" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
    </style>
    <title>Danuma minuma</title>
</head>
<body>
<h2>Welcome to Danuma minuma!</h2><br>

<%String name=(String)request.getAttribute("statusMessage");
    if(name == null) {
        name = "";
    }
%>
<%=name%><br>
<a href="/addQuestion" class="button">Send a question</a>
<a href="/viewSubmissions" class="button">view Submissions</a>
<a href="/viewAllQuestions" class="button">view All Questions</a>
<a href="/sendSms" class="button">send Sms to user</a>
<a href="/viewAllSms" class="button">view All Sms</a>
<a href="/dashboard" class="button">App Dashboard</a>

</body>
</html>

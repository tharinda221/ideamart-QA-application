<%--
  Created by IntelliJ IDEA.
  User: tharinda
  Date: 2/7/17
  Time: 1:17 AM
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
    </style>
    <title>send SMS</title>
</head>
<body>

<form action="/sendSms" method="POST">
    Enter your SMS: <input type="text" name="sms" style="font-size:9pt;height:100px;width:400px;" required><br>
    User Telephone Number(Hash code): <input type="text" name="address" required><br>
    <input type="submit" value="Submit">
</form>

<%String name=(String)request.getAttribute("smsStatus");
    if(name == null) {
        name = "";
    }
%>
<%=name%>
<br>
<br>
<a href="/" class="button">Home</a>

</body>
</html>

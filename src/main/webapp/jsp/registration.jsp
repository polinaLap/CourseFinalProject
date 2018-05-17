<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 16-May-18
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form name="registrationForm" method="POST" action="/controller">
    <input type="hidden" name="command" value="registrate"/>
    Name<br/>
    <input type="text" name="name" value=""/>
    <br/>Email:<br/>
    <input type="email" name="login" value=""/>
    <br/>Password<br/>
    <input type="password" name="password" value=""/>
    <br/>
    ${errorLoginPassMessage}<br/>
    <input type="submit" value="Confirm"/>
</form><hr/>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 12-May-18
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
${user.name}
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="email" name="login" value=""/>
    <br/>Password<br/>
    <input type="password" name="password" value=""/>
    <br/>
    ${errorLoginPassMessage}<br/>
    <input type="submit" value="Log in"/>
</form><hr/>
<form name="toRegistrationForm" method = "POST" action="registration">
    <input type="submit" value="Registration"/>
</form>
${nullPage}
</body>
</html>

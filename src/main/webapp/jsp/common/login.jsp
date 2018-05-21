<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 12-May-18
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
    <title>Login</title>
</head>
<body>
<form class="form-container" method="POST" action="/controller">
    <input type="hidden" name="command" value="login"/>
    <div class="form-title"><h2>Log in</h2></div>
    <div class="form-title">Email</div>
    <input class="form-field" type="email" name="login" value="" /><br />
    <div class="form-title">Password</div>
    <input class="form-field" type="password" name="password" value="" /><br />
    <div class="form-message">${errorLoginPassMessage}</div>
    <div class="submit-container">
        <input class="submit-button" type="submit" value="Login" />
    </div>
        <br/>
        <div class="submit-container">
        <a href="registration" class="submit-button">Registration</a>
        </div>
    <div class="form-message">${nullPage}</div>
</form>

</body>
</html>

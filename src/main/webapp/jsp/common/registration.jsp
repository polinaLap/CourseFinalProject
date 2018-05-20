<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 16-May-18
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">

</head>
<body>
<form class="form-container" method="POST" action="/controller">
        <input type="hidden" name="command" value="registrate"/>
        <div class="form-title"><h2>Registration</h2></div>
        <div class="form-title">Name</div>
        <input class="form-field" type="text" name="name" value="" /><br />
        <div class="form-title">Email</div>
        <input class="form-field" type="email" name="login" value="" /><br />
        <div class="form-title">Password</div>
        <input class="form-field" type="password" name="password" value="" /><br />
        <div class="form-message">
            ${errorLoginPassMessage}
        </div>
        <div class="submit-container">
            <input class="submit-button" type="submit" value="Confirm" />
        </div><br/>
        <div class="submit-container">
            <a href="login" class="submit-button">Back to log in</a>
        </div>
</form>
</body>
</html>

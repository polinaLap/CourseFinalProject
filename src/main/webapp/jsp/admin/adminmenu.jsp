<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 17-May-18
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
</head>
<body>
<div class="form-container">
    <div class="form-title"><h2>Hello, ${user.name}!</h2></div>
    <form method="POST" action="/controller">
        <div class="submit-container-center">
            <input type="hidden" name="command" value="toTable"/>
            <input class="submit-button" type="submit" value="Show table"/>
        </div>
    </form>
    <br/>
    <div class="submit-container-center">
        <a href="/admin/addtest" class="submit-button">Add test</a>
    </div>
    <br/>
    <form method="POST" action="/controller">
        <div class="submit-container-center">
            <input type="hidden" name="command" value="logout"/>
            <input class="submit-button" type="submit" value="Log out"/>
        </div>
    </form>
    <div class="form-message">${error}</div>
</div>
</body>
</html>

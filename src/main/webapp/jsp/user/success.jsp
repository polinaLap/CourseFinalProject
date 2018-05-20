<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 16-May-18
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Results</title>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
</head>
<body>
<div class="form-container">
    <div class="form-title"><h2>${user.name}, your table of success</h2></div>
    <table>
        <tr><td><div class="form-text-bold">Test</div></td>
            <td><div class="form-text-bold">Count of attempts</div></td>
            <td><div class="form-text-bold">Max mark</div></td>
            <td></td></tr>
        <c:forEach var="test" items="${user.success.success.keySet()}">
            <tr><td><div class="form-text">${test.name}</div>  </td>
                <td><div class="form-text">${user.success.attemptCount(test)} </div></td>
                <td><div class="form-text">${user.success.maxMark(test)} </div></td>
            </tr>
        </c:forEach>
    </table>
    <div class="submit-container-center">
        <a href="user/menu" class="submit-button">To menu</a>
    </div>
    <br/>
    <form name="testsForm" method="POST" action="/controller">
        <div class="submit-container-center">
            <input type="hidden" name="command" value="logout"/>
            <input class="submit-button" type="submit" value="Log out"/>
        </div>
    </form>
</div>
</body>
</html>

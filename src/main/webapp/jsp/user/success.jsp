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
    <title>Test</title>
</head>
<body>
${user.name}
<table width =500>
    <tr><td> Test </td>
        <td> Count of attempts </td>
    <td> Max mark </td>
    </tr>
    <c:forEach var="test" items="${user.success.success.keySet()}">
        <tr><td> ${test.name} </td>
            <td>${user.success.attemptCount(test)}</td>
            <td>${user.success.maxMark(test)}</td>
        </tr>
    </c:forEach>
</table>
<form name="toMenu" method="POST" action="user/menu">
    <input type="submit" value="Back to menu"/>
</form>
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="Log out"/>
</form>
</body>
</html>

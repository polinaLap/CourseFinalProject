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
<table width =500>
    <tr><td> Test </td>
    <td> Count of attempts </td>
    <td> Best mark </td>
    </tr>
    <c:forEach var="test" items="${successList}">
        <tr><td> ${test[0]} </td>
            <td> ${test[1]} </td>
            <td> ${test[2]} </td>
        </tr>
    </c:forEach>
</table>
<form name="toTests" method="POST" action="controller">
    <input type="hidden" name="command" value="toMenu"/>
    <input type="submit" value="Back to menu"/>
</form>
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="Log out"/>
</form>
</body>
</html>

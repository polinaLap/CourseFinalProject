<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 17-May-18
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Table of success</title>
</head>
<body>
${user.name}
<table width =500>
    <tr><td> Name </td>
        <td> email</td>
        <td> Test</td>
        <td> Average mark </td>
    </tr>
    <c:forEach var="cur_user" items="${table}">
        <tr><td> ${cur_user.name} </td>
            <td>${cur_user.email}</td>
        <c:forEach var="test" items="${cur_user.success.success.keySet()}">
            <tr><td> ${test.name} </td>
                <td>${cur_user.success.attemptCount(test)}</td>
                <td>${cur_user.success.averageMark(test)}</td>
            </tr>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
<form name="toAdminMenu" method="POST" action="admin/adminmenu">
    <input type="submit" value="Back to menu"/>
</form>
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="Log out"/>
</form>
</body>
</html>

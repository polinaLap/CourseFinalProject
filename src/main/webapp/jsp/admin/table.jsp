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
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
</head>
<body>
<div class="form-container">
    <table>
        <tr><td><div class="form-text-bold">Name</div></td>
            <td><div class="form-text-bold">Email</div></td>
            <td><div class="form-text-bold">Test</div></td>
            <td><div class="form-text-bold">Average mark</div></td>
            <td><div class="form-text-bold">Total mark</div></td>
        </tr>
        <c:forEach var="cur_user" items="${table}">
            <tr><td><div class="form-text">${cur_user.name}</div>  </td>
                <td><div class="form-text">${cur_user.email} </div></td>
                <td></td><td></td>
                <td><div class="form-text">${cur_user.success.averageMark()}</div></td>
            </tr>
            <c:forEach var="test" items="${cur_user.success.success.keySet()}">
                <tr><td></td><td></td>
                    <td><div class="form-text">${test}</div>  </td>
                    <td><div class="form-text">${cur_user.success.averageMark(test)} </div></td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
    <div class="submit-container-center">
        <a href="admin/adminmenu" class="submit-button">To menu</a>
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

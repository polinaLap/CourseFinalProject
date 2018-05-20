<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 13-May-18
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tests</title>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
</head>
<body>

<div class="form-container">
    <table>
        <tr><td><div class="form-text-bold">Test</div></td>
            <td><div class="form-text-bold">Description</div></td>
            <td></td></tr>
    <c:forEach var="test" items="${sessionScope.testsList}">
            <tr><td><div class="form-text">"${test[0]}"</div>  </td>
                <td><div class="form-text">"${test[1]} </div></td>
                <td>
                    <form name="testsForm" method="POST" action="/controller">
                        <input type="hidden" name="command" value="chooseTest"/>
                        <div class="submit-container-center">
                        <input type="hidden" name ="testName" value="${test[0]}"/>
                        <input class="submit-button" type="submit" value="Pass"/>
                    </div>
                </form>
                <td/>
            </tr>
    </c:forEach>
    </table>
    <div class="submit-container-center">
        <a href="/user/menu" class="submit-button">To menu</a>
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

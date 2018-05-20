<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 16-May-18
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result</title>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
</head>
<body>
<form class="form-container" name="testForm" method="POST" action="/controller">
    <div class="form-title"><h2>${test.name}</h2></div>
    <fieldset>
        <input type="hidden" name="command" value="checkTest"/>
        <table>
            <c:forEach var="question" items="${test.questions}">
        <tr>
            <td><div class="form-text-bold">${question.question}</div></td>
            <td><c:choose>
            <c:when test="${question.okAnswer}">
                <div class="form-text-green">1</div>
            </c:when>
            <c:otherwise>
                <div class="form-text-red">0</div>
            </c:otherwise>
            </c:choose><td/></tr>

        </c:forEach>
        </table>
        <br/>
        <div class="form-text-bold">Total mark: ${curMark}</div>
    </fieldset><br/>
    <div class="submit-container">
        <a href="user/tests" class="submit-button">Back to tests</a>
    </div>
    <div class="submit-container-center">
        <input type="hidden" name="command" value="logout"/>
        <input class="submit-button" type="submit" value="Log out"/>
    </div>
</form>
</body>
</html>

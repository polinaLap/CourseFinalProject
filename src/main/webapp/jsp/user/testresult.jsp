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
</head>
<body>
<c:out value="${test.name}"/>
<fieldset disabled>
    <table>
        <c:forEach var="question" items="${test.questions}">
            <tr><td><c:out value="${question.question}"></c:out></td>
                <td><c:choose>
                    <c:when test="${question.okAnswer}">ok</c:when>
                        <c:otherwise>notOk</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
    Total mark: ${curMark}
</fieldset>

<form name="toTests" method="POST" action="controller">
    <input type="hidden" name="command" value="toMenu"/>
    <input type="submit" value="Back to tests"/>
</form>
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
<input type="submit" value="Log out"/>
</form>
</body>
</html>

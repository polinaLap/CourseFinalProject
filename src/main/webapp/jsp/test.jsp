<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 14-May-18
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<c:out value="${test.name}"/>

<form name="testForm" method="POST" action="controller">
    <fieldset>
    <input type="hidden" name="command" value="checkTest"/>
<table>
    <c:forEach var="question" items="${test.questions}">
        <tr><td> <c:out value="${question.question}"/> </td></tr>
        <tr>
        <c:forEach var="answer" items="${question.answerVariants}">
            <td> <input type="radio"
                        name=${question.question} value="${answer}">
                <label for=${answer}>${answer}</label>
            </td>
        </c:forEach>
    </tr>
    </c:forEach>
</table>
    <input type="submit" value="Finish"/>
    </fieldset>
</form>

</body>
</html>

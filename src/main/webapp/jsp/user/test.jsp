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
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
</head>
<body>

<form class="form-container" name="testForm" method="POST" action="/controller">
    <div class="form-title"><h2>${test.name}</h2></div>
    <fieldset>
        <input type="hidden" name="command" value="checkTest"/>

             <c:forEach var="question" items="${test.questions}">
                <div class="form-text-bold">${question.question}</div>
        <table>
                <tr>
                    <c:forEach var="answer" items="${question.answerVariants}">
                         <td>
                             <div class="form-text">
                                 <input type="radio" name=${question.id} value="${answer}">
                                 <label for=${answer}>${answer}</label>
                             </div>
                         </td>
                    </c:forEach>
                </tr>
        </table>
             </c:forEach>

        <div class="submit-container">
            <input class="submit-button" type="submit" value="Finish" />
        </div>
    </fieldset>
    <br/>
    <div class="submit-container">
        <a href="user/tests" class="submit-button">Back to tests</a>
    </div>

    <div class="form-message">${testError}</div>
</form>
</body>
</html>

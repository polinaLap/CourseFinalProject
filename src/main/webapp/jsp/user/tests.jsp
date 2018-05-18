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
<head><title>Tests</title></head>
<body>
<c:out value="${user.name}" /><br/>
<form name="testsForm" method="POST" action="controller">
    <input type="hidden" name="command" value="chooseTest"/>
    <table>
    <c:forEach var="test" items="${sessionScope.testsList}">
            <tr><td> <c:out value="${test[0]}"/> </td><td>
                <c:out value="${test[1]}"/> </td><td>
                <input type="submit" name ="testName" value="${test[0]}"/><td/></tr>
    </c:forEach>

</table>
</form>
<form name="toMenu" method="POST" action="user/menu">
    <input type="submit" value="Back to menu"/>
</form>
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="Log out"/>
</form>
</body>
</html>

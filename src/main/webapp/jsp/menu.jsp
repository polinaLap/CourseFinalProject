<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 16-May-18
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<c:out value="${user.name}"/>
<form name="getTestsForm" method="POST" action="controller">
    <input type="hidden" name="command" value="totests"/>
    <input type="submit" value="Show tests"/>

</form>
<form name="getSuccessForm" method="POST" action="controller">
    <input type="hidden" name="command" value="tousersuccess"/>
    <input type="submit" value="Show my success"/>

</form>
</body>
</html>

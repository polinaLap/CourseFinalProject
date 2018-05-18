<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 17-May-18
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Menu</title>
</head>
<body>
${user.name}
<form name="toTableForm" method="POST" action="controller">
    <input type="hidden" name="command" value="toTable"/>
    <input type="submit" value="Show table"/>

</form>
<form name="toAddTestForm" method="POST" action="admin/addtest">
    <input type="hidden" name="command" value="addTest"/>
    <input type="submit" value="Add test"/>

</form>
<br/>
${error}<br/>
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="Log out"/>
</form>
</body>
</html>

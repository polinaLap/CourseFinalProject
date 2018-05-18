<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 13-May-18
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
Request from ${pageContext.errorData.requestURI} is failed
<br/>
Servlet name of type: ${pageContext.errorData.servletName}
<br/>
Status code: ${pageContext.errorData.statusCode}
<br/>
Exception: ${pageContext.errorData.throwable}

</body>
</html>

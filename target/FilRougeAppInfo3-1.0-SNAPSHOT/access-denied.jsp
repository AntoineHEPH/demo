<%--
  Created by IntelliJ IDEA.
  User: PX
  Date: 20/11/2025
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accès refusé</title>
</head>
<body>
    <h1>😒 Accès refusé</h1>
    <p>Vous n'avez pas accès à la page /admin.</p>

    <a href="${pageContext.request.contextPath}/admin-login.jsp">Redirect</a>
</body>
</html>

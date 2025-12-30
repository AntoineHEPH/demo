<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%--
  Created by IntelliJ IDEA.
  User: PX
  Date: 18/11/2025
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <h1>${title}</h1>
    <ul>
        <c:forEach var="creator" items="${creators}">
            <li>${creator.name} - ${creator.subs} abonnés (bien joué goat)</li>
        </c:forEach>
    </ul>
</body>
</html>

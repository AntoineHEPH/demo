<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: PX
  Date: 18/11/2025
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mon biscuit chinois</title>
</head>
<body>
    <h1>Mon biscuit chinois 🍪</h1>
    <h2>Ma prédiction :</h2>
    <p>Voici ma prédiction du futur.</p>

    <%-- Utilisation d'une "EL" --%>
    <p>${prediction}</p>

    <hr>
    <%-- Jakarta Standart Tag Library (JSTL) --%>
    <small>Généré le <%= new Date()%></small>

    <p><a href="fortune.jsp">En générer un autre</a></p>
</body>
</html>

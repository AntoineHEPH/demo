<%--
  Created by IntelliJ IDEA.
  User: PX
  Date: 18/11/2025
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
    <c:if test="${param == 'access_denied'}">
        <p>Vous devez vous connecter pour accéder à votre profil.</p>
    </c:if>
    <h1>Connexion</h1>

    <form action="login" method="post">
        <label input="username">Nom d'utilisateur :</label>
        <input type="text" name="username" id="username" required>
        <button type="submit">Se connecter</button>
    </form>
</body>
</html>

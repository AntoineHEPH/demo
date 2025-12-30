<%--
  Created by IntelliJ IDEA.
  User: PX
  Date: 20/11/2025
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Admin</title>
</head>
<body>
    <h1>Prouve que tu es admin !</h1>
    <form action ="${pageContext.request.contextPath}/adminLogin" method="post">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username"><br>
        <label for ="password">Mot de passe :</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Se connecter">
    </form>
</body>
</html>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%--
  Ce fichier affiche les détails du personnage 'Garen' stockés dans l'attribut de requête "character"
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>League of Legends</title>
</head>
<body>

    <h1>League of Legends WIKI</h1>

    <form action="${pageContext.request.contextPath}/lol-characters" method="GET">
        <input type="text" name="q" value="${param.q}" placeholder="Nom du champion">
        <button type="submit">Rechercher 🌞</button>
    </form>

    <c:forEach items="${characters}" var="champion">
        <h3>${champion.name()} -- ${champion.role()}</h3>
        <ul>
            Compétences :
            <c:forEach items="${champion.skills()}" var="skills">
                <li>${skills}</li>
            </c:forEach>
        </ul>
    </c:forEach>

    <h2>Nouveau champion</h2>
    <form action="${pageContext.request.contextPath}/lol-characters" method="POST">
        <label for="championName">Nom :</label>
        <input type="text" name="championName" id="championName" placeholder="ex: Teemo">

        <label for="championRole">Rôle :</label>
        <input type="text" name="championRole" id="championRole" placeholder="ex: Cancer">

        <label for="championSkills">Compétences (séparés par virgule) :</label>
        <input type="text" name="championSkills" id="championSkills" placeholder="ex: Ratio Panda, Eteindre la lumière, Champignons toxiques">

        <input type="submit" value="Ajouter">
    </form>

</body>
</html>
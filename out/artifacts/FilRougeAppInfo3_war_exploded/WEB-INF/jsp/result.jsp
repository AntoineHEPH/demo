<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Résultat du Quiz</title>
</head>
<body>
<h1>Quiz Terminé !</h1>

<h2>Votre score : ${sessionScope.score} / 5</h2>

<c:choose>
    <c:when test="${sessionScope.score == 5}">
        <p style="color: green; font-size: 1.5em;">🏆 Incroyable ! Vous êtes un véritable Otaku !</p>
    </c:when>
    <c:when test="${sessionScope.score >= 3}">
        <p style="color: orange;">Pas mal ! Encore un peu d'entraînement.</p>
    </c:when>
    <c:otherwise>
        <p style="color: red;">Aïe... Il faut aller relire les classiques.</p>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/quiz?restart=true">
    <button>Recommencer le Quiz</button>
</a>
</body>
</html>
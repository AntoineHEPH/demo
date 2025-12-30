<%--
  Created by IntelliJ IDEA.
  User: PX
  Date: 01/12/2025
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des vidéos !</title>
</head>
<body>
  <h1>Voici la liste des vidéos !</h1>
  <hr/>

  <h2>Dernières sorties</h2>

  <ul>
    <c:forEach items="${videos}" var="video">
      <li>
        <a href="${video.url()}" target="_blank">
          [${video.title()}]
        </a>
        <span class="desc">${video.description()}</span>
      </li>
    </c:forEach>
  </ul>

  <c:if test="${empty videos}">
    <p>Aucune vidéo disponible pour le moment.</p>
  </c:if>
</body>
</html>

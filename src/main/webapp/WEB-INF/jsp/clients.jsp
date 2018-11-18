<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Les clients</title>
</head>
<body>
<h1>Les clients</h1>
<p />
<hr width="100%" />

<table border="1" >
    <tr><th>Nom</th><th>Prénom</th><th>Détail</th></tr>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td> ${client.nom} </td>
            <td> ${client.pnom} </td>
            <td> <a href="\update?id=${client.num}">Infos</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>


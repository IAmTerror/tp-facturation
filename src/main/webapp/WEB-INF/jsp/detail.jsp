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

<form>
    <fieldset>
        <legend>Client</legend>

            ${client.num}
            ${client.nom}
            ${client.pnom}
            ${client.loc}
            ${client.pays}

    </fieldset>
</form>

</body>
</html>


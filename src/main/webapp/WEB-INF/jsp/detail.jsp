<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Les films</title>
</head>
<body>
<h1>Les films</h1>
<p />
<hr width="100%" />

<form>
    <fieldset>
        <legend>Client</legend>
        <figure>
            <figcaption>${client.num}</figcaption>
            <figcaption>${client.nom}</figcaption>
            <figcaption>${client.pnom}</figcaption>
            <figcaption>${client.loc}</figcaption>
            <figcaption>${client.pays}</figcaption>
        </figure>
    </fieldset>
</form>

</body>
</html>


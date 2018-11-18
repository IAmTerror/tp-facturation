<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Les clients</title>
</head>
<body>
<h1>Les clients</h1>
<p/>
<hr width="100%"/>

<form method="post" action="/detail">
    <fieldset>
        <legend>Client</legend>
        <div>
            <label for="id">ID : </label>
            <input type="text" id="id" name="id" value="${client.num}" readonly />
        </div>
        <br />
        <div>
            <label for="nom">Nom : </label>
            <input type="text" id="nom" name="nom" value="${client.nom}" />
        </div>
        <br />
        <div>
            <label for="pnom">Prénom : </label>
            <input type="text" id="pnom" name="pnom" value="${client.pnom}" />
        </div>
        <br />
        <div>
            <label for="loc">Ville : </label>
            <input type="text" id="loc" name="loc" value="${client.loc}" />
        </div>
        <br />
        <div>
            <label for="pays">Pays : </label>
            <input type="text" id="pays" name="pays" value="${client.pays}" />
        </div>
        <br />
        <div class="button">
            <button type="submit" name=validez">Mettre à jour les données du client</button>
        </div>
    </fieldset>
</form>

</body>
</html>


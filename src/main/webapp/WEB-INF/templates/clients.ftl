<html>
<head>
    <title>Les clients</title>
</head>
<body>
<h1>Les clients</h1>
<p/>
<hr width="100%"/>

<table border="1">
    <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <#list clients as client>
        <tr>
            <td> ${client.nom} </td>
            <td> ${client.pnom} </td>
            <td><a href="\update?id=${client.num}">Do it</a></td>
            <td><a href="\delete?id=${client.num}">Just do it</a></td>
        </tr>
    </#list>
</table>


</body>
</html>
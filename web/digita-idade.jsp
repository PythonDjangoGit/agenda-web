<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 30/01/2019
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Digite sua idade</title>
</head>
<body>
<p>Digite sua idade e aperte o botao Enviar:</p>
<form action="mostra-idade.jsp" method="post">
    <label for="idadeIdentifier"></label>
    <input id="idadeIdentifier" type="number" name="idade">
    <input type="submit" value="Enviar">
</form>
</body>
</html>

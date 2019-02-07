<!DOCTYPE html>
<%@ taglib prefix="jstl-core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag-utils" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>

    <script src="<jstl-core:url value="/js/jquery-3.3.1.js"/>"></script>
    <script src="<jstl-core:url value="/js/jquery-ui.js"/>"></script>
    <link href="<jstl-core:url value="/css/jquery-ui.css"/>" rel="stylesheet"/>

    <meta charset="UTF-8">

    <title>Novo contato</title>

    <style>
        input {
            display: block;
        }
    </style>

</head>
<body>
<jstl-core:import url="cabecalho.jsp"/>
<form action="sistema?logica=AdicionaContato" method="post">
    <label for="campoId">ID:</label>
    <input id="campoId" type="text" name="id">
    <label for="campoNome">Nome:</label>
    <input id="campoNome" type="text" name="nome">
    <label for="campoEmail">E-mail:</label>
    <input id="campoEmail" type="email" name="email">
    <label for="campoEndereco">Endereco: </label>
    <input id="campoEndereco" type="text" name="endereco">
    <tag-utils:campo-data id="dataNascimento" label="Data Nascimento:"/>
    <input type="submit" value="Gravar"/>
</form>
<jstl-core:import url="rodape.jsp"/>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 02/02/2019
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="jstl-core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl-formatting" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag-utils" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html>
<head>
    <title>Listagem de contatos</title>
</head>
<body>

<jstl-core:import url="cabecalho.jsp"/>

<jsp:useBean id="dao" class="br.com.home.dao.ContatoDao"/>
<table border="1">
    <jstl-core:forEach var="contato" items="${dao.lista}">
        <tr>
            <td>${contato.nome}</td>
            <td>
                <jstl-core:choose>
                    <jstl-core:when test="${ not empty contato.email}">
                        <a href="mailto:${contato.email}">
                                ${contato.email}
                        </a>
                    </jstl-core:when>
                    <jstl-core:otherwise>
                        Email nao informado
                    </jstl-core:otherwise>
                </jstl-core:choose>
            </td>
            <td>${contato.endereco}</td>
            <td>
                <jstl-formatting:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
            </td>
        </tr>
    </jstl-core:forEach>
</table>
<jstl-core:import url="rodape.jsp"/>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 05/02/2019
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="jstl-core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="jstl-formatting" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Listagem de contatos</title>
</head>
<body>
    <jstl-core:import url="cabecalho.jsp"/>
    <jsp:useBean id="dao" class="br.com.home.dao.ContatoDao"/>
        <table border="1">
            <thead>
                <th>id</th>
                <th>nome</th>
                <th>endereco</th>
                <th>email</th>
                <th>data nascimento</th>
                <th>Opcoes</th>
                <th>Opcoes</th>
            </thead>
            <tbody>
                <jstl-core:forEach var="contato" items="${dao.lista}">
                    <tr>
                        <td>${contato.id}</td>
                        <td>${contato.nome}</td>
                        <td>${contato.endereco}</td>
                        <td>
                            <jstl-core:choose>
                                <jstl-core:when test="${not empty contato.email}">
                                    <a href="mailto:${contato.email}">${contato.email}</a>
                                </jstl-core:when>
                                <jstl-core:otherwise>
                                    Email nao informado
                                </jstl-core:otherwise>
                            </jstl-core:choose>
                        </td>
                        <td><jstl-formatting:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
                        <td><a href="${pageContext.request.contextPath}/sistema?logica=RemoveContato&id=${contato.id}">Excluir</a></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/sistema?logica=InformeDadosAlteraContato&id=${contato.id}">Alterar</a>
                        </td>
                    </tr>
                </jstl-core:forEach>
            </tbody>
        </table>
    <jstl-core:import url="rodape.jsp"/>
</body>
</html>

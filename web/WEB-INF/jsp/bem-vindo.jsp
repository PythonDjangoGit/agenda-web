<%@ page import="br.com.home.dao.ContatoDao" %>
<%@ page import="br.com.home.domain.Contato" %>
<%@ page import="br.com.home.infra.ConnectionDatabaseFactory" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Bem vindo</title>
</head>
<body>
<table>
    <thead>
    <th>Nome</th>
    <th>Email</th>
    <th>Endereco</th>
    <th>Data de nascimento</th>
    </thead>
    <tbody>
    <%
        ContatoDao dao = new ContatoDao(ConnectionDatabaseFactory.getPostgreSQLConnection());
        List<Contato> contatos = dao.obtenhaContatos();

        for (Contato contato : contatos) {
    %>
    <tr>
        <td><%=contato.getNome()%>
        </td>
        <td><%=contato.getEmail()%>
        </td>
        <td><%=contato.getEndereco()%>
        </td>
        <td><%=contato.getDataNascimento().getTime()%>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>

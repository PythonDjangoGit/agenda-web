package br.com.home.filtros;

import br.com.home.infra.ConnectionDatabaseFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/sistema")
public class FiltroConexao implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Connection connection = ConnectionDatabaseFactory.getPostgreSQLConnection();
        servletRequest.setAttribute("connection", connection);
        System.out.println("Criando conexao no filtro de conexao");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Fechando conexao no filtro de conexao");
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}

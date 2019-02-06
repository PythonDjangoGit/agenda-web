package br.com.home.domain.logica.impl;

import br.com.home.dao.ContatoDao;
import br.com.home.domain.logica.Logica;
import br.com.home.infra.ConnectionDatabaseFactory;
import br.com.home.util.ApplicationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveContato implements Logica {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Integer id = ApplicationUtil.toInteger(req.getParameter("id"));
        ContatoDao dao = new ContatoDao(ConnectionDatabaseFactory.getPostgreSQLConnection());
        dao.remova(id);
        return "/contato-removido.jsp";
    }
}

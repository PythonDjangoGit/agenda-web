package br.com.home.domain.logica.impl;

import br.com.home.dao.ContatoDao;
import br.com.home.domain.logica.Logica;
import br.com.home.util.ApplicationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class RemoveContato implements Logica {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res, Connection connection) {
        Integer id = ApplicationUtil.toInteger(req.getParameter("id"));
        ContatoDao dao = new ContatoDao(connection);
        dao.remova(id);
        return "/WEB-INF/jsp/contato-removido.jsp";
    }
}

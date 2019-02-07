package br.com.home.domain.logica.impl;

import br.com.home.dao.ContatoDao;
import br.com.home.domain.Contato;
import br.com.home.domain.logica.Logica;
import br.com.home.util.ApplicationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InformeDadosAlteraContato implements Logica {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Integer id = ApplicationUtil.toInteger(req.getParameter("id"));
        Contato contato = new ContatoDao().getContato(id);
        req.setAttribute("contato", contato);
        return "/informe-dados-altera-contato.jsp";
    }
}

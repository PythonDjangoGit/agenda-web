package br.com.home.domain.logica.impl;

import br.com.home.dao.ContatoDao;
import br.com.home.domain.Contato;
import br.com.home.domain.builder.ContatoBuilder;
import br.com.home.domain.logica.Logica;
import br.com.home.util.ApplicationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class AdicionaContato implements Logica {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res, Connection connection) {
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String email = req.getParameter("email");
        String datanascimento = req.getParameter("dataNascimento");

        ContatoDao dao = new ContatoDao(connection);

        Contato contato = ContatoBuilder.getInstance()
                .comId(ApplicationUtil.toInteger(id))
                .comNome(nome)
                .comEndereco(endereco)
                .comEmail(email)
                .comDataNascimento(ApplicationUtil.toCalendar(datanascimento))
                .build();
        dao.adicione(contato);

        return "/WEB-INF/jsp/contato-adicionado.jsp";
    }
}

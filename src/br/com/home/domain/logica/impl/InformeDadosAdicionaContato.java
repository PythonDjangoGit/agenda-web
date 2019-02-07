package br.com.home.domain.logica.impl;

import br.com.home.domain.logica.Logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class InformeDadosAdicionaContato implements Logica {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res, Connection connection) {
        return "/WEB-INF/jsp/adiciona-contato.jsp";
    }
}

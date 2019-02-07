package br.com.home.domain.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public interface Logica {
    String execute(HttpServletRequest req, HttpServletResponse res, Connection connection);
}

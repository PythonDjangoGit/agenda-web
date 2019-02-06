package br.com.home.domain.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
    String execute(HttpServletRequest req, HttpServletResponse res);
}

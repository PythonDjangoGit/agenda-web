package br.com.home.servlets;

import br.com.home.domain.logica.Logica;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/sistema")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeDaClasse = req.getParameter("logica");
        String nomeDaClasseQualificado = "br.com.home.domain.logica.impl."+nomeDaClasse;
        try {
            Class clazz = Class.forName(nomeDaClasseQualificado);
            Logica logica = (Logica) clazz.newInstance();
            Connection connection = (Connection) req.getAttribute("connection");
            String pagina = logica.execute(req, resp, connection);
            req.getServletContext().getRequestDispatcher(pagina)
                    .forward(req, resp);
        } catch (Exception e) {
           throw new RuntimeException("Nao foi possivel carregar a logica informada: "+e.getMessage(), e.getCause());
        }
    }
}

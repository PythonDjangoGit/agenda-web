package br.com.home.domain.logica.impl;

        import br.com.home.dao.ContatoDao;
        import br.com.home.domain.Contato;
        import br.com.home.domain.logica.Logica;
        import br.com.home.infra.ConnectionDatabaseFactory;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.List;

public class ListaContatos implements Logica {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return "/lista-contatos-com-logica.jsp";
    }
}

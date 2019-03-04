package br.com.home.servlets;

import br.com.home.dao.ContatoDao;
import br.com.home.domain.Contato;
import br.com.home.domain.builder.ContatoBuilder;
import br.com.home.infra.ConnectionDatabaseFactory;
import br.com.home.util.ApplicationUtil;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

@WebServlet(asyncSupported = true, urlPatterns = {"/adicioneContato"})
public class AdicionaContatoServlet extends HttpServlet {

    private ContatoDao dao;

    @Override
    public void init() throws ServletException {
        try {
            FileReader file = new FileReader(getServletContext()
                    .getResource("./WEB-INF/properties/app.properties")
                    .getPath());
            Properties prop = new Properties();
            prop.load(file);
            System.out.println("Imprimindo propriedades lidas durante init:");
            System.out.println(prop.getProperty("login"));
            System.out.println(prop.getProperty("senha"));
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync(req, resp);
        try {
            System.out.println("AGUARDANDO 5 SEGUNDOS EM THREAD SEPARADA");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                System.out.println("DISPACHANDO PARA HELLO SERVLETHELLO");
                try {
                    asyncEvent.getAsyncContext().getRequest().getRequestDispatcher("/WEB-INF/jsp/hello.jsp")
                            .forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

            }

        });
        Integer id = ApplicationUtil.toInteger(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String dataEmTexto = req.getParameter("dataNascimento");

        Calendar dataNascimento = ApplicationUtil.toCalendar(dataEmTexto);

        Contato contato = ContatoBuilder.getInstance()
                .comId(id)
                .comNome(nome)
                .comEmail(email)
                .comEndereco(endereco)
                .comDataNascimento(dataNascimento)
                .build();
        if (dao == null) {
            dao = new ContatoDao(ConnectionDatabaseFactory.getPostgreSQLConnection());
        }
        dao.adicione(contato);

        asyncContext.complete();
        getServletContext().getRequestDispatcher("/contato-adicionado.jsp")
                .forward(req, resp);
    }

    @Override
    public void destroy() {
        dao.close();
        super.destroy();
    }
}

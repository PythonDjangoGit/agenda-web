package br.com.home.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

public class MeuListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("[CONTEXTO INICIADO...]");
        servletContextEvent.getServletContext().setAttribute("inicializationTime", new Date().getTime());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("[CONTEXTO FINALIZADO...]");
        Long inicializationTime = (Long) servletContextEvent.getServletContext().getAttribute("inicializationTime");
        long tempoExecucao = new Date().getTime() - inicializationTime;
        System.out.printf("Tempo de execucao: %d segundos\n", Math.round(tempoExecucao / 1000));
    }
}

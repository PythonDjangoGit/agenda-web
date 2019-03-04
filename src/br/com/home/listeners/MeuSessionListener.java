package br.com.home.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MeuSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("[SESSAO CRIADA...]");

        while (httpSessionEvent.getSession().getAttributeNames().hasMoreElements()) {
            String parametro = httpSessionEvent.getSession().getAttributeNames().nextElement();
            System.out.printf("%s = %s\n", parametro,
                    httpSessionEvent.getSession().getAttribute(parametro));
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("[SESSAO DESTRUIDA...]");
    }
}
